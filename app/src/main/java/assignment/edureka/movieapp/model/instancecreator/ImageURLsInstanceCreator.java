package assignment.edureka.movieapp.model.instancecreator;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

import assignment.edureka.movieapp.model.ImageURLs;

/**
 * Created by suhit_000 on 8/2/2016.
 */
public class ImageURLsInstanceCreator implements InstanceCreator<ImageURLs> {
    @Override
    public ImageURLs createInstance(Type type) {
        return new ImageURLs("None","None","None");
    }
}
