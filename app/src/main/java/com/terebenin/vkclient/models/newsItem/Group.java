package com.terebenin.vkclient.models.newsItem;

/**
 * Created by evgeny on 26.01.17.
 */

public class Group {
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

    private int id;
    private String name;
    private String screen_name;
    private int is_closed;
    private String type;
    private int is_admin;
    private int is_member;
    private String photo_50;
    private String photo_100;
    private String photo_200;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public int getIs_closed() {
        return is_closed;
    }

    public void setIs_closed(int is_closed) {
        this.is_closed = is_closed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public int getIs_member() {
        return is_member;
    }

    public void setIs_member(int is_member) {
        this.is_member = is_member;
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

    public String getPhoto_200() {
        return photo_200;
    }

    public void setPhoto_200(String photo_200) {
        this.photo_200 = photo_200;
    }
}