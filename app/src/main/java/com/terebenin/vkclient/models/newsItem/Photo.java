package com.terebenin.vkclient.models.newsItem;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgeny on 07.02.17.
 */

public class Photo implements Parcelable {
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

    List<Photo> mPhotoList;

    public List<Photo> getPhotoList() {
        return mPhotoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        mPhotoList = photoList;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.album_id);
        dest.writeInt(this.owner_id);
        dest.writeString(this.photo_75);
        dest.writeString(this.photo_130);
        dest.writeString(this.photo_604);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeString(this.text);
        dest.writeInt(this.date);
        dest.writeList(this.mPhotoList);
    }

    public Photo() {
    }

    protected Photo(Parcel in) {
        this.id = in.readInt();
        this.album_id = in.readInt();
        this.owner_id = in.readInt();
        this.photo_75 = in.readString();
        this.photo_130 = in.readString();
        this.photo_604 = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.text = in.readString();
        this.date = in.readInt();
        this.mPhotoList = new ArrayList<Photo>();
        in.readList(this.mPhotoList, Photo.class.getClassLoader());
    }

    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };
}