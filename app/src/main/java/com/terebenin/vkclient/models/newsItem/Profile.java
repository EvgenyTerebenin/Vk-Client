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

    public int getProfileId() {
        return profile_id;
    }

    public void setProfileId(int id) {
        this.profile_id = profile_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoto100() {
        return photo_100;
    }

    public void setPhoto100(String photo_100) {
        this.photo_100 = photo_100;
    }

}
