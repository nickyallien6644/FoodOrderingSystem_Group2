package com.example.foodorderingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.AllProductAdapter;
import com.example.foodorderingsystem.Adapter.AllProductForRecommendedAdapter;
import com.example.foodorderingsystem.Adapter.CartAdapter;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartListActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    RecyclerView cartRecycler;

    List<Cart> listCart;
    CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        cartRecycler = findViewById(R.id.recycler_cart);
        listCart = new ArrayList<>();
        getCartData();
    }

//    private void listCart() {
//        apiInterface = Api.getClients();
//        Call<List<Product>> call = apiInterface.getAllProductForAllCategory();
//        call.enqueue(new Callback<List<Product>>() {
//            @Override
//            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//                listAllProduct = response.body();
//                getAllProductData();
//            }
//
//            @Override
//            public void onFailure(Call<List<Product>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void getCartData() {
        cartAdapter = new CartAdapter(getApplicationContext(), listCart);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        cartRecycler.setLayoutManager(layoutManager);
        cartRecycler.setAdapter(cartAdapter);
    }
}