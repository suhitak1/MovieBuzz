package assignment.edureka.movieapp.model;

import java.io.Serializable;

/**
 * Created by suhit_000 on 7/28/2016.
 */
public class ImageURLs implements Serializable {

    private String full;
    private String medium;
    private String thumb;

    public ImageURLs(String full, String medium, String thumb) {
        this.full = full;
        this.medium = medium;
        this.thumb = thumb;
    }

    public ImageURLs() {
        this.full = new String();
        this.medium = new String();
        this.thumb = new String();
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
