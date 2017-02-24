package com.terebenin.vkclient.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static retrofit2.converter.gson.GsonConverterFactory.create;

/**
 * Created by evgeny on 26.01.17.
 */

public class RetrofitSingleton {

    public static final String BASE_URL = "https://api.vk.com/method/";

    private RequestInterface request;
    private Retrofit retrofit;

    private static class Loader {
        static volatile RetrofitSingleton INSTANCE = new RetrofitSingleton();
    }


    public RetrofitSingleton() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient.build())
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

