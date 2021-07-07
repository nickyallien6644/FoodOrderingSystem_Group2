package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.Adapter.ProductByFoodAdapter;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductByFood extends AppCompatActivity {

    ApiInterface apiInterface;
    List<Product> listProductByFood;
    RecyclerView productByFoodReCycler;
    ProductByFoodAdapter productByFoodAdapter;

    ImageView imageView;
    TextView itemName, itemPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productbyfood);

        productByFoodReCycler = findViewById(R.id.listProductByFoodRecycler);
        listProductByFood = new ArrayList<>();
        listProductByFood();
    }

    private void listProductByFood() {
        apiInterface = Api.getClients();
        Call<List<Product>> call = apiInterface.getProductByFood();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProductByFood = response.body();
                getProductByFoodData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getProductByFoodData() {
        productByFoodAdapter = new ProductByFoodAdapter(getApplicationContext(), listProductByFood);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        productByFoodReCycler.setLayoutManager(layoutManager);
        productByFoodReCycler.setAdapter(productByFoodAdapter);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        listProductByFood();
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == event.KEYCODE_BACK) {
//            moveTaskToBack(true);
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}