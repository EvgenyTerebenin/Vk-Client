package com.terebenin.vkclient.models.newsItem;

import com.activeandroid.Model;

/**
 * Created by evgeny on 07.02.17.
 */

public class Attachment {

    private String type;
    private Photo photo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
