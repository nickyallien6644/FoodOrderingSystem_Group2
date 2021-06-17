package com.example.foodorderingsystem.Utils;

import com.example.foodorderingsystem.Model.Account;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AccountInterface {
    Gson gson = new GsonBuilder ().setDateFormat ("yyyy-MM-dd HH:mm:ss").create ();
    AccountInterface apiService  = new Retrofit.Builder().baseUrl ("http://localhost:8080/")
            .addConverterFactory (GsonConverterFactory.create (gson)).build ().create (AccountInterface.class);
    @GET("account/list")
    Call<List<Account>> getAccounts();

    @POST("account/add")
    Call<Account>addPersona(@Body Account account);
}
