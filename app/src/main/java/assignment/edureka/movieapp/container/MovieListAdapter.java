package assignment.edureka.movieapp.container;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import assignment.edureka.movieapp.R;
import assignment.edureka.movieapp.model.Movie;

/**
 * Created by suhit_000 on 7/26/2016.
 */
public class MovieListAdapter extends ArrayAdapter<Movie>{

    Context context;
    List<Movie> movieList;

    public MovieListAdapter(Context context, int resource, List<Movie> objects) {
        super(context, resource, objects);
        this.context = context;
        this.movieList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.movie_list_item,parent,false);

        ImageView movieImage = (ImageView) view.findViewById(R.id.movieImage);
        TextView movieTitle = (TextView) view.findViewById(R.id.movieTitle);
       // TextView movieTagline = (TextView) view.findViewById(R.id.movieTag);

        Movie movieListItem = movieList.get(position);
        Picasso.with(context)
                .load(movieListItem.getImages().getFanart().getFull())
                .into(movieImage);
        movieTitle.setText(movieListItem.getTitle());
       // movieTagline.setText(movieListItem.getDisplayRating());

        return view;
    }
}
