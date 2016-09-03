package assignment.edureka.movieapp.model.instancecreator;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

import assignment.edureka.movieapp.model.MovieIds;

/**
 * Created by suhit_000 on 8/2/2016.
 */
public class MovieIdsInstanceCreator implements InstanceCreator<MovieIds> {
    @Override
    public MovieIds createInstance(Type type) {
        return new MovieIds(0, "None", "None",0);
    }
}
