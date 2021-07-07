package com.example.foodorderingsystem.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.MenuAdapter;
import com.example.foodorderingsystem.Adapter.RecommendedAdapter;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    List<Product> listProducts ;
    RecyclerView menuRecyclerView;
    RecyclerView recommendedRecyclerView;
    RecommendedAdapter recommendedAdapter;
    MenuAdapter menuAdapter;

    TextView tv_restaurant, tv_resName, tv_timeOpen, tv_timeClose, tv_address,tv_phone;
    ImageView iv_restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail_activity);
        listProducts = new ArrayList<>();
        listProducts();
    }

    private void getRestaurantMenu() {
        menuRecyclerView = findViewById(R.id.restaurant_menu);
        menuAdapter = new MenuAdapter(this.getApplicationContext(), listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        menuRecyclerView.setLayoutManager(layoutManager);
        menuRecyclerView.setAdapter(menuAdapter);
    }

    private void getRestaurantInfo(){
        tv_restaurant = findViewById(R.id.tv_restaurant);
        tv_resName = findViewById(R.id.tv_resName);
        tv_timeOpen = findViewById(R.id.tv_timeOpen);
        tv_timeClose = findViewById(R.id.tv_timeClose);
        tv_address = findViewById(R.id.tv_address);
        tv_phone = findViewById(R.id.tv_phone);
        iv_restaurant = findViewById(R.id.iv_restaurant);


    }

    public void listProducts() {
        apiInterface = Api.getClients();
        Call<List<Product>> call = apiInterface.getProducts ();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProducts = response.body();
                getRestaurantMenu();
                getRecommendedData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(RestaurantActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRecommendedData() {
        recommendedRecyclerView = findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommendedAdapter(this.getApplicationContext(), listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);
    }
}