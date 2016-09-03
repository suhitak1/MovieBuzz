package assignment.edureka.movieapp.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by suhit_000 on 7/26/2016.
 */
public class Movie implements Serializable{

    private Images images;
    private String certification;
    private List<String> genres;
    private List<String> available_translations;
    private String language;
    private String updated_at;
    private int votes;
    private double rating;
    private String homepage;
    private String trailer;
    private int runtime;
    private String released;
    private String overview;
    private String tagline;
    private MovieIds ids;
    private int year;
    private String title;

    public Movie(Images images, String certification, List<String> genres,
                 List<String> available_translations, String language, String updated_at, int votes,
                 double rating, String homepage, String trailer, int runtime, String released,
                 String overview, String tagline, MovieIds ids, int year, String title) {
        this.images = images;
        this.certification = certification;
        this.genres = genres;
        this.available_translations = available_translations;
        this.language = language;
        this.updated_at = updated_at;
        this.votes = votes;
        this.rating = rating;
        this.homepage = homepage;
        this.trailer = trailer;
        this.runtime = runtime;
        this.released = released;
        this.overview = overview;
        this.tagline = tagline;
        this.ids = ids;
        this.year = year;
        this.title = title;
    }

    public Movie(){}

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getGenres() {
        String strGenres = genres.get(0);
        for(int i=1; i<genres.size();i++)
            strGenres += (", " + genres.get(i));

        return strGenres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getAvailable_translations() {
        return available_translations;
    }

    public void setAvailable_translations(List<String> available_translations) {
        this.available_translations = available_translations;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getDisplayRating() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(rating);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getReleased() {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        //return simpleDateFormat.format(released);
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public MovieIds getIds() {
        return ids;
    }

    public void setIds(MovieIds ids) {
        this.ids = ids;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
