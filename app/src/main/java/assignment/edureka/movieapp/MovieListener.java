package assignment.edureka.movieapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import assignment.edureka.movieapp.model.Movie;
import assignment.edureka.movieapp.utils.Constants;

/**
 * Created by suhit_000 on 7/26/2016.
 */
public class MovieListener implements ListView.OnItemClickListener, ListView.OnItemSelectedListener {

    private Context context;

    public MovieListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        Movie movie = (Movie)adapterView.getItemAtPosition(i);
        intent.putExtra(Constants.PARAM_SELECTED_MOVIE, movie);
        context.startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
