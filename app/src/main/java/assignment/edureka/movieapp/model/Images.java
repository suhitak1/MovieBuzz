package assignment.edureka.movieapp.model;

import java.io.Serializable;

/**
 * Created by suhit_000 on 7/28/2016.
 */
public class Images implements Serializable{

    private ImageURLs thumb;
    private ImageURLs banner;
    private ImageURLs clearart;
    private ImageURLs logo;
    private ImageURLs poster;
    private ImageURLs fanart;

    public Images(ImageURLs thumb, ImageURLs banner, ImageURLs clearart, ImageURLs logo,
                  ImageURLs poster, ImageURLs fanart) {

        this.thumb = thumb;
        this.banner = banner;
        this.clearart = clearart;
        this.logo = logo;
        this.poster = poster;
        this.fanart = fanart;
    }

    public Images() {
        setThumb(new ImageURLs());
        setBanner(new ImageURLs());
        setClearart(new ImageURLs());
        setLogo(new ImageURLs());
        setPoster(new ImageURLs());
        setFanart(new ImageURLs());
    }

    public ImageURLs getThumb() {
        return thumb;
    }

    public void setThumb(ImageURLs thumb) {
        this.thumb = thumb;
    }

    public ImageURLs getBanner() {
        return banner;
    }

    public void setBanner(ImageURLs banner) {
        this.banner = banner;
    }

    public ImageURLs getClearart() {
        return clearart;
    }

    public void setClearart(ImageURLs clearart) {
        this.clearart = clearart;
    }

    public ImageURLs getLogo() {
        return logo;
    }

    public void setLogo(ImageURLs logo) {
        this.logo = logo;
    }

    public ImageURLs getPoster() {
        return poster;
    }

    public void setPoster(ImageURLs poster) {
        this.poster = poster;
    }

    public ImageURLs getFanart() {
        return fanart;
    }

    public void setFanart(ImageURLs fanart) {
        this.fanart = fanart;
    }
}
