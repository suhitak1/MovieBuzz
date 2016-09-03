package assignment.edureka.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import assignment.edureka.movieapp.model.Movie;
import assignment.edureka.movieapp.utils.Constants;

public class MovieDetailActivity extends AppCompatActivity {

    MovieDetail movieDetail;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        movieDetail = new MovieDetail();
        movie = (Movie) intent.getSerializableExtra(Constants.PARAM_SELECTED_MOVIE);
        updateDisplay(movie);

    }

    public void updateDisplay(Movie movie) {
        movieDetail.movieDetailTitle.setText(movie.getTitle());
        movieDetail.movieRating.setText(movie.getDisplayRating());
        int hour = movie.getRuntime() / Constants.PARAM_SIXTY;
        int mins = movie.getRuntime() % Constants.PARAM_SIXTY;
        movieDetail.movieRuntime.setText(hour + Constants.STR_HOUR + mins + Constants.STR_MINS);
        movieDetail.movieLanguage.setText(movie.getLanguage().toUpperCase());
        movieDetail.movieYear.setText(String.valueOf(movie.getYear()));
        movieDetail.movieGenres.setText(movie.getGenres().toString());
        movieDetail.movieReleased.setText(movie.getReleased().toString());
        movieDetail.movieOverview.setText(movie.getOverview());
        Picasso.with(this).load(movie.getImages().getClearart().getFull()).into(movieDetail.movieLogo);
        String homepage = ((movie.getHomepage()!=null)|| (!TextUtils.isEmpty(movie.getHomepage()))) ?
                movie.getHomepage() : Constants.ERR_NO_LINK_AVAILABLE;
        movieDetail.movieHomePage.setText(homepage);
    }

    class MovieDetail {
        final RelativeLayout movieLayout;
        final TextView movieDetailTitle;
        final TextView movieRating;
        final TextView movieYear;
        final TextView movieLanguage;
        final TextView movieRuntime;
        final TextView movieGenres;
        final TextView movieReleased;
        final TextView movieOverview;
        final ImageView movieLogo;
        final TextView movieHomePage;

        public MovieDetail() {
            movieDetailTitle = (TextView) findViewById(R.id.movieDetailTitle);
            movieRating = (TextView) findViewById(R.id.movieRating);
            movieYear = (TextView) findViewById(R.id.movieYear);
            movieRuntime = (TextView) findViewById(R.id.movieRuntime);
            movieLanguage = (TextView) findViewById(R.id.movieLanguage);
            movieGenres = (TextView) findViewById(R.id.movieGenres);
            movieReleased = (TextView) findViewById(R.id.movieReleased);
            movieOverview = (TextView) findViewById(R.id.movieDetail);
            movieLogo = (ImageView) findViewById(R.id.movieLogo);
            movieLayout = (RelativeLayout) findViewById(R.id.mainLayout);
            movieHomePage = (TextView) findViewById(R.id.movieHomePageURL);
        }
    }
}
