package com.terebenin.vkclient.models.newsItem;

import com.google.gson.annotations.Expose;

/**
 * Created by evgeny on 31.01.17.
 */

public class ResponseHolder {
    @Expose
    Response response;

    public Response getResponse() {
        return response;
    }
}
