package assignment.edureka.movieapp.model.instancecreator;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

import assignment.edureka.movieapp.model.Movie;

/**
 * Created by suhit_000 on 8/2/2016.
 */
public class MovieInstanceCreator implements InstanceCreator<Movie> {
    @Override
    public Movie createInstance(Type type) {
        return new Movie();
    }
}
