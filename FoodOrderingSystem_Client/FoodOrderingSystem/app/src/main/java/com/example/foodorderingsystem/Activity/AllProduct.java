package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.AllProductAdapter;
import com.example.foodorderingsystem.Adapter.ProductByCakeAdapter;
import com.example.foodorderingsystem.Adapter.ProductByDrinkAdapter;
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

public class AllProduct extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView allProductRecycler;

    List<Product> listAllProduct;
    AllProductAdapter allProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);

        allProductRecycler = findViewById(R.id.listAllProductRecycler);
        listAllProduct = new ArrayList<>();
        listAllProduct();
    }

    private void listAllProduct() {
        apiInterface = Api.getClients();
        Call<List<Product>> call = apiInterface.getAllProductForAllCategory();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listAllProduct = response.body();
                getAllProductData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAllProductData() {
        allProductAdapter = new AllProductAdapter(getApplicationContext(), listAllProduct);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        allProductRecycler.setLayoutManager(layoutManager);
        allProductRecycler.setAdapter(allProductAdapter);
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