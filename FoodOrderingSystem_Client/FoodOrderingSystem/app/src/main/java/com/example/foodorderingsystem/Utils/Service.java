package com.example.foodorderingsystem.Utils;

public class Service {
    //create string url
    public static final String URL="http://192.168.1.45:8080/user/";

    public static AccountInterface getClients(){
        //return element of url
        return Client.getRetrofit(URL).create(AccountInterface.class);
    }
}
