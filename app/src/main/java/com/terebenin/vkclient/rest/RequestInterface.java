package com.terebenin.vkclient.rest;

import com.terebenin.vkclient.models.newsItem.ResponseBean;
import com.terebenin.vkclient.models.newsItem.ResponseHolder;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by evgeny on 26.01.17.
 */
public interface RequestInterface {

    @GET("newsfeed.get")
    rx.Observable<ResponseHolder> getResponseHolder(@Query("filters") String filters, @Query("count") int count, @Query("access_token") String token, @Query("v") double version);

}
