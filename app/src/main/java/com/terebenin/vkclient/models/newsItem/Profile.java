package com.terebenin.vkclient.models.newsItem;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by evgeny on 27.01.17.
 */
@Table(name = "Profiles")
public class Profile extends Model {
    @Expose
    @Column(name = "Profile_id")
    @SerializedName("id")
    private int profile_id;
    @Expose
    @Column(name = "First_name")
    private String first_name;
    @Expose
    @Column(name = "Last_name")
    private String last_name;
    @Expose
    @Column(name = "Photo_100")
    private String photo_100;


    public Profile() {
        super();
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int id) {
        this.profile_id = profile_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public void setPhoto_100(String photo_100) {
        this.photo_100 = photo_100;
    }

}
