package com.terebenin.vkclient.models.newsItem;

import com.google.gson.annotations.Expose;

/**
 * Created by evgeny on 07.02.17.
 */

public class Attachment {
    @Expose
    private String type;
    @Expose
    private Photo photo;

    public Attachment(String data) {

    }

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
