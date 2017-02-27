package com.terebenin.vkclient.models.newsItem;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by evgeny on 26.01.17.
 */
@Table(name = "Groups")
public class Group extends Model {
    /**
     * id : 65
     * name : Enter Казань
     * screen_name : enter.media
     * is_closed : 0
     * type : page
     * is_admin : 0
     * is_member : 1
     * photo_50 : https://pp.vk.me/...1a0/oca_fPBuFWs.jpg
     * photo_100 : https://pp.vk.me/...19f/uerDsQqqKR8.jpg
     * photo_200 : https://pp.vk.me/...19d/ZhT4cvPw5J8.jpg
     */
    @Expose
    @Column(name = "Group_id")
    @SerializedName("id")
    private int group_id;
    @Expose
    @Column(name = "Name")
    private String name;
    @Expose
    @Column(name = "Photo_100")
    private String photo_100;


    public Group() {
        super();
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_Id(int id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public void setPhoto_100(String photo_100) {
        this.photo_100 = photo_100;
    }

}