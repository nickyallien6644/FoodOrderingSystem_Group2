package com.example.foodorderingsystem.Utils;

import android.graphics.ColorSpace;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.Category;
import com.example.foodorderingsystem.Model.FrequentlyAskedQuestion;
import com.example.foodorderingsystem.Model.PrivacyPolicy;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.Restaurant;
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

    @GET("product/listAllProductForAllCategory")
    Call<List<Product>> getAllProductForAllCategory();

    @GET("product/listAllProductForRecommended")
    Call<List<Product>> getAllProductForRecommended();

    @GET("product/listProductByFood")
    Call<List<Product>> getProductByFood();

    @GET("product/listProductByDrink")
    Call<List<Product>> getProductByDrink();

    @GET("product/listProductByCake")
    Call<List<Product>> getProductByCake();

    @GET("product/listProductForRecommended")
    Call<List<Product>> getProductForRecommended();

    @GET("product/listCategory")
    Call<List<Category>> getCategory();

    @GET("product/listProductByRID/{rID}")
    Call<List<Product>> getProductByRID(@Path("rID") int rID);

    @GET("product/listProductByRIDSeeAll/{rID}")
    Call<List<Product>> getProductByRIDSeeAll(@Path("rID") int rID);

    @GET("privacyPolicy/listPrivacyPolicy")
    Call<List<PrivacyPolicy>> getPrivacyPolicy();

    @GET("frequentlyAskedQuestion/listFrequentlyAskedQuestion")
    Call<List<FrequentlyAskedQuestion>> getFrequentlyAskedQuestion();

    @GET("restaurant/info/{rID}")
    Call<List<Restaurant>> getRestaurantInfo(@Path("rID") int rID);


}
