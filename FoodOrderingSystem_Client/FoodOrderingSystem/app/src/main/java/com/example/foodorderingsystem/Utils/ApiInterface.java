package com.example.foodorderingsystem.Utils;

import android.graphics.ColorSpace;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.Category;
import com.example.foodorderingsystem.Model.FrequentlyAskedQuestion;
import com.example.foodorderingsystem.Model.Notification;
import com.example.foodorderingsystem.Model.Order;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.PrivacyPolicy;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.Restaurant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
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
import retrofit2.http.Path;

public interface ApiInterface {

    Gson gson = new GsonBuilder ().setDateFormat ("yyyy-MM-dd HH:mm:ss").create ();
    ApiInterface apiService  = new Retrofit.Builder().baseUrl ("http://locallhost:8081/")
            .addConverterFactory (GsonConverterFactory.create (gson)).build ().create (ApiInterface.class);
    @GET("account/list")
    Call<List<Account>> getAccounts();
    @GET("account/listbyid")
    Call<List<Account>> getAccountsId();
    @POST("account/add")
    Call<Account>addPersona(@Body Account account);
    @PUT("account/updateCoins")
    Call<Account>updateBcoins(@Body Account account);
    @PUT("account/forgotPassword")
    Call<Account>forgotPassword(@Body Account account);

    @POST("nofication/add")
    Call<Notification> addNofication(@Body Notification notification);

    @POST("cart/addCart")
    Call<Cart>addCart(@Body Cart cart);

    @POST("account/update/{id}")
    Call<Account>updatePersona(@Body Account account,@Path("id") int id);

    @GET("product/listProducts")
    Call<List<Product>> getProducts();

    @GET("product/listProductAllProduct")
    Call<List<Product>> getProductAllProduct();

    @GET("product/listAllProductForAllCategory")
    Call<List<Product>> getAllProductForAllCategory();

    @GET("product/listProductSearchSeeAll/{search}/{rID}")
    Call<List<Product>> getAllProductForAllCategory(@Path("search") String search,@Path("rID") int rID);

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
    @GET("restaurant/getAll")
    Call<List<Restaurant>> getAllRestaurantInfo();

    @GET("nofication/list/{ID}")
    Call<List<Notification>> ListNofication(@Path("ID") int ID);

    @POST("order/add")
    Call<Order>addOrder(@Body Order order);

    @GET("order/list")
    Call<List<Order>> getOrders();

    @POST("orderdetail/add")
    Call<OrderDetail> addOrderDetail(@Body OrderDetail orderDetail);

    @GET("orderdetail/list/{oID}")
    Call<List<OrderDetail>> getOrderDetail(@Path("oID") int oID);

    @GET("orderdetail/list")
    Call<List<OrderDetail>> getAllOrderDetail();

    @GET("order/list/{date}")
    Call<List<Order>> getOrdersDate(@Path("date")String date);



}
