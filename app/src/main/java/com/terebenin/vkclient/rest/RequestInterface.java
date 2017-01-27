package com.terebenin.vkclient.rest;

import com.terebenin.vkclient.models.newsItem.ItemsBean;
import com.terebenin.vkclient.models.newsItem.ResponseBean;
import com.terebenin.vkclient.models.newsItem.newsItem;

import java.util.List;
import java.util.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by evgeny on 26.01.17.
 */
public interface RequestInterface {

    @GET("/newsfeed.get")
    rx.Observable<ResponseBean> getResponseBean(@Query("count")int count,@Query("access_token")String token);

}
