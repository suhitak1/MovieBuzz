package assignment.edureka.movieapp.model.instancecreator;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

import assignment.edureka.movieapp.model.Images;

/**
 * Created by suhit_000 on 8/2/2016.
 */
public class ImageInstanceCreator implements InstanceCreator<Images> {
    @Override
    public Images createInstance(Type type) {
        return new Images();
    }
}
