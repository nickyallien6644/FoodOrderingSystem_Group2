package com.example.foodorderingsystem.Utils;

import android.graphics.ColorSpace;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.PrivacyPolicy;
import com.example.foodorderingsystem.Model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiInterface {

    Gson gson = new GsonBuilder ().setDateFormat ("yyyy-MM-dd HH:mm:ss").create ();
    ApiInterface apiService  = new Retrofit.Builder().baseUrl ("http://localhost:8081/")
            .addConverterFactory (GsonConverterFactory.create (gson)).build ().create (ApiInterface.class);
    @GET("account/list")
    Call<List<Account>> getAccounts();
    @GET("account/listbyid")
    Call<List<Account>> getAccountsId();
    @POST("account/add")
    Call<Account>addPersona(@Body Account account);
    @PUT("updateCoins/{aID}")
    Call<Account>updateBcoins( @Path("aID") int id ,@Body Account account);
    @GET("product/listProducts")
    Call<List<Product>> getProducts();
    @GET("privacyPolicy/listPrivacyPolicy")
    Call<List<PrivacyPolicy>> getPrivacyPolicy();
}
