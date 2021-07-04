package com.example.foodorderingsystem.Utils;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.FrequentlyAskedQuestion;
import com.example.foodorderingsystem.Model.PrivacyPolicy;
import com.example.foodorderingsystem.Model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    Gson gson = new GsonBuilder ().setDateFormat ("yyyy-MM-dd HH:mm:ss").create ();
    ApiInterface apiService  = new Retrofit.Builder().baseUrl ("http://localhost:8080/")
            .addConverterFactory (GsonConverterFactory.create (gson)).build ().create (ApiInterface.class);
    @GET("account/list")
    Call<List<Account>> getAccounts();

    @POST("account/add")
    Call<Account>addPersona(@Body Account account);

    @GET("product/listProducts")
    Call<List<Product>> getProducts();

    @GET("privacyPolicy/listPrivacyPolicy")
    Call<List<PrivacyPolicy>> getPrivacyPolicy();

    @GET("frequentlyAskedQuestion/listFrequentlyAskedQuestion")
    Call<List<FrequentlyAskedQuestion>> getFrequentlyAskedQuestion();
}
