package com.terebenin.vkclient.models.newsItem;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

/**
 * Created by evgeny on 07.02.17.
 */

public class Photo implements Parcelable {
    @Expose
    private int id;
    @Expose
    private int album_id;
    @Expose
    private int owner_id;
    @Expose
    private String photo_75;
    @Expose
    private String photo_130;
    @Expose
    private String photo_604;
    @Expose
    private int width;
    @Expose
    private int height;
    @Expose
    private String text;
    @Expose
    private int date;


    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;

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

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;

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