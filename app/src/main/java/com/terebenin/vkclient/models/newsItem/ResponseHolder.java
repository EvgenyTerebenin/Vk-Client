package com.terebenin.vkclient.models.newsItem;

import com.google.gson.annotations.SerializedName;

/**
 * Created by evgeny on 31.01.17.
 */

public class ResponseHolder {
    @SerializedName("response")
    ResponseBean responseBean;

    public ResponseBean getResponseBean() {
        return responseBean;
    }
}
