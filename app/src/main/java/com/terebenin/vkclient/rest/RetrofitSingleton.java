package com.terebenin.vkclient.rest;

import com.vk.sdk.VKAccessToken;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by evgeny on 26.01.17.
 */

public class RetrofitSingleton {

    public static final String METHOD_NAME = "newsfeed.get";
    public static final String ACCESS_TOKEN = VKAccessToken.currentToken().accessToken;
    public static final String BASE_URL = String.format("https://api.vk.com/method/%s?PARAMETERS&access_token=%s&v=V", METHOD_NAME, ACCESS_TOKEN);

    private RequestInterface request;
    private Retrofit retrofit;

    private static class Loader {
        static volatile RetrofitSingleton INSTANCE = new RetrofitSingleton();
    }

    public RetrofitSingleton() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        request = retrofit.create(RequestInterface.class);
    }

    public static RetrofitSingleton getInstance() {
        return Loader.INSTANCE;
    }

    public RequestInterface getRequest() {
        return request;
    }
}

