package com.example.foodorderingsystem.Utils;

public class Api {
    //create string url
    public static final String URL="http://192.168.1.9:8080/account/";

    public static ApiInterface getClients(){
        //return element of url
        return Client.getRetrofit(URL).create(ApiInterface.class);
    }
}
