package assignment.edureka.movieapp.model;

import java.io.Serializable;

/**
 * Created by suhit_000 on 7/26/2016.
 */
public class MovieIds implements Serializable {

    private int tmdb;
    private String imdb;
    private String slug;
    private int trakt;

    public MovieIds(int tmdb, String imdb, String slug, int trakt) {
        this.tmdb = tmdb;
        this.imdb = imdb;
        this.slug = slug;
        this.trakt = trakt;
    }

    public MovieIds(){

    }

    public MovieIds(int trakt) {
        this.trakt = trakt;
    }

    public int getTmdb() {
        return tmdb;
    }

    public void setTmdb(int tmdb) {
        this.tmdb = tmdb;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getTrakt() {
        return trakt;
    }

    public void setTrakt(int trakt) {
        this.trakt = trakt;
    }
}
