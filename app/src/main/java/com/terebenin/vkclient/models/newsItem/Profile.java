package com.terebenin.vkclient.models.newsItem;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by evgeny on 27.01.17.
 */

@Entity
public class Profile {
    @Property
    private int id;
    @Property
    private String first_name;
    @Property
    private String last_name;
    private int sex;
    private String screen_name;
    private String photo_50;
    @Property
    private String photo_100;
    private int online;

    @Generated(hash = 1597521389)
    public Profile(int id, String first_name, String last_name, int sex,
            String screen_name, String photo_50, String photo_100, int online) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.sex = sex;
        this.screen_name = screen_name;
        this.photo_50 = photo_50;
        this.photo_100 = photo_100;
        this.online = online;
    }

    @Generated(hash = 782787822)
    public Profile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getPhoto_50() {
        return photo_50;
    }

    public void setPhoto_50(String photo_50) {
        this.photo_50 = photo_50;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public void setPhoto_100(String photo_100) {
        this.photo_100 = photo_100;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }
}
