package com.example.foodorderingsystem.Utils;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.Product;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("list")
    Call<List<Account>> getAccounts();

    @POST("add")
    Call<Account>addPersona(@Body Account account);

    @GET("listProducts")
    Call<List<Product>> getProducts();
}
