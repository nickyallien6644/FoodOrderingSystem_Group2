package com.example.foodorderingsystem.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public static Retrofit getRetrofit(String url){
        //user retrofit to get url of api
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
