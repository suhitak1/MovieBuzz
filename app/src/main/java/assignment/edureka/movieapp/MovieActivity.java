package assignment.edureka.movieapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import assignment.edureka.movieapp.container.MovieListAdapter;
import assignment.edureka.movieapp.model.ImageURLs;
import assignment.edureka.movieapp.model.Images;
import assignment.edureka.movieapp.model.MovieIds;
import assignment.edureka.movieapp.model.Movie;
import assignment.edureka.movieapp.model.instancecreator.ImageInstanceCreator;
import assignment.edureka.movieapp.model.instancecreator.ImageURLsInstanceCreator;
import assignment.edureka.movieapp.model.instancecreator.MovieIdsInstanceCreator;
import assignment.edureka.movieapp.model.instancecreator.MovieInstanceCreator;
import assignment.edureka.movieapp.utils.Constants;
import assignment.edureka.movieapp.utils.MovieAppComparator;

public class MovieActivity extends AppCompatActivity {

    List<Movie> movies;
    MovieListAdapter movieListAdapter;
    ListView listView;
    MovieListener movieListener;
    Gson gson;

    public static final String TAG = MovieActivity.class.getSimpleName();
    private final String MOVIE_URL = "http://beta.json-generator.com/api/json/get/41M1XVfF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movies = new ArrayList();
        createMovieGSON();
        initMovie();
        getMovies();
    }

    private void createMovieGSON(){
        Log.d(TAG, Constants.STR_START + "createMovieGSON");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MovieIds.class, new MovieIdsInstanceCreator());
        gsonBuilder.registerTypeAdapter(ImageURLs.class, new ImageURLsInstanceCreator());
        gsonBuilder.registerTypeAdapter(Images.class, new ImageInstanceCreator());
        gsonBuilder.registerTypeAdapter(Movie.class, new MovieInstanceCreator());
        gson = gsonBuilder.create();
        Log.d(TAG, Constants.STR_END + "createMovieGSON");
    }

    private void initMovie(){
        Log.d(TAG, Constants.STR_START + "initMovies");
        listView = (ListView) findViewById(R.id.movieListView);
        movieListener = new MovieListener(this);
        listView.setOnItemClickListener(movieListener);
        Log.d(TAG, Constants.STR_END + "initMovies");
    }

    public void getMovies() {
        Log.d(TAG, Constants.STR_START + "getMovies");
        if (isNetworkAvailable()) {
            new MovieLoadTask().execute(MOVIE_URL);
        } else {
            Toast.makeText(MovieActivity.this, Constants.ERR_NO_NETWORK, Toast.LENGTH_LONG).show();
        }
        Log.d(TAG, Constants.STR_END + "getMovies");
    }

    private void parseResponseData(String responseData){
            Movie movie = gson.fromJson(responseData, Movie.class);
            movies.add(movie);
    }

    private class MovieLoadTask extends AsyncTask<String, Void, Void>{

        private ProgressDialog progressDialog = new ProgressDialog(MovieActivity.this);
        String result = "";

        @Override
        protected void onPreExecute() {
            Log.d(TAG, Constants.STR_START + "MovieLoadTask > onPreExecute");
            super.onPreExecute();
            progressDialog.setMessage(Constants.INFO_FETCHING_DATA);
            progressDialog.show();
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    MovieLoadTask.this.cancel(true);
                }
            });
            Log.d(TAG, Constants.STR_END + "MovieLoadTask > onPreExecute");
        }

        @Override
        protected Void doInBackground(String... urls) {
            Log.d(TAG, Constants.STR_START + "MovieLoadTask > doInBackground");
            result = getMoviesData(urls[0]);
            Log.d(TAG, Constants.STR_END + "MovieLoadTask > doInBackground");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d(TAG, Constants.STR_START + "MovieLoadTask > onPostExecute");
            super.onPostExecute(aVoid);
            try {
                JSONArray jsonArray = new JSONArray(result);
                for(int i=0; i<jsonArray.length();i++) {
                    JSONObject jObject = jsonArray.getJSONObject(i);
                    JSONObject movieObject = jObject.getJSONObject(Constants.PARAM_MOVIE);
                    parseResponseData(String.valueOf(movieObject));
                }
            } catch (JSONException e){
                Log.e(TAG, e.toString());
            }
            //initMovie();
            progressDialog.hide();
            MovieActivity.this.populateMovieList(movies);
            Log.d(TAG, Constants.STR_END + "MovieLoadTask > onPostExecute");
        }
    }

    public void populateMovieList(List<Movie> movieList){
        Log.d(TAG, Constants.STR_START + "populateMovieList");
        Collections.sort(movieList, MovieAppComparator.ratingComparator);
        movies = movieList.subList(Integer.parseInt(getString(R.string.lst_start)),
                Integer.parseInt(getString(R.string.lst_limit)));
        movieListAdapter = new MovieListAdapter(this,R.layout.movie_list_item,movies);
        listView.setAdapter(movieListAdapter);
        Log.d(TAG, Constants.STR_END + "populateMovieList");
    }

    @NonNull
    private String getMoviesData(String connectURL){
        Log.d(TAG, Constants.STR_START + "getMoviesData");

        InputStream is = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(connectURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            is = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            String line = null;

            while((line=br.readLine())!=null){
                sb.append(line);
            }
            connection.disconnect();

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(is != null)
                    is.close();

                if (br != null)
                    br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, Constants.STR_END + "getMoviesData");
        return sb.toString();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }
}
