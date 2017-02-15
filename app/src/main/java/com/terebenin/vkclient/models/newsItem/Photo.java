package com.terebenin.vkclient.models.newsItem;

/**
 * Created by evgeny on 07.02.17.
 */

public class Photo {
    private int id;
    private int album_id;
    private int owner_id;
    private String photo_75;
    private String photo_130;
    private String photo_604;
    private int width;
    private int height;
    private String text;
    private int date;


    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;

    }


    public int getAlbum_id() {
        return album_id;
    }


    public void setAlbum_id(int album_id) {
        this.album_id = album_id;

    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;

    }

    public String getPhoto_75() {
        return photo_75;
    }


    public void setPhoto_75(String photo_75) {
        this.photo_75 = photo_75;

    }


    public String getPhoto_130() {
        return photo_130;

    }


    public void setPhoto_130(String photo_130) {
        this.photo_130 = photo_130;

    }

    public String getPhoto_604() {
        return photo_604;

    }


    public void setPhoto_604(String photo_604) {
        this.photo_604 = photo_604;

    }


    public int getWidth() {
        return width;

    }


    public void setWidth(int width) {
        this.width = width;

    }


    public int getHeight() {
        return height;

    }


    public void setHeight(int height) {
        this.height = height;

    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;

    }

    public int getDate() {
        return date;

    }


    public void setDate(int date) {
        this.date = date;

    }
}