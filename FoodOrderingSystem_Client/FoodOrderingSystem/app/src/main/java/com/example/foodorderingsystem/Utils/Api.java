package com.example.foodorderingsystem.Utils;

public class Api {
    //create string url
    public static final String URL="http://192.168.1.8:8080/";

    public static ApiInterface getClients(){
        //return element of url
        return Client.getRetrofit(URL).create(ApiInterface.class);
    }

    public static AccountInterface getClients1(){
        //return element of url
        return Client.getRetrofit(URL).create(AccountInterface.class);
    }


}
    