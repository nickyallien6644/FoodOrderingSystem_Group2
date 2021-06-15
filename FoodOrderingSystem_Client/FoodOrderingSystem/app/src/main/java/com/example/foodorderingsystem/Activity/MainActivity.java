package com.example.foodorderingsystem.Activity;

import android.os.Bundle;

import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.AllMenuAdapter;
import com.example.foodorderingsystem.Adapter.PopularAdapter;
import com.example.foodorderingsystem.Adapter.RecommendedAdapter;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    List<Product> listProducts ;

    RecyclerView popularRecyclerView;
    PopularAdapter popularAdapter;

    RecyclerView recommendedRecyclerView;
    RecommendedAdapter recommendedAdapter;

    RecyclerView allMenuRecyclerView;
    AllMenuAdapter allMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listProducts = new ArrayList<>();
        listProducts();

       BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
       navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()) {
                   case R.id.action_coins:
                       Toast.makeText(MainActivity.this, "Coins", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.action_home:
                       Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.action_history:
                       Toast.makeText(MainActivity.this, "History", Toast.LENGTH_SHORT).show();
                       break;
               }
               return true;
           }
       });

    }

    public void listProducts() {
        apiInterface = Api.getClients();

        Call<List<Product>> call = apiInterface.getProducts ();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProducts = response.body();
               getPopularData();
               getRecommendedData();
               getAllMenuData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPopularData() {
        popularRecyclerView = findViewById(R.id.popular_recycler);
        popularAdapter = new PopularAdapter(this, listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);
    }

    private void getRecommendedData() {
        recommendedRecyclerView = findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommendedAdapter(this, listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);
    }

    private void getAllMenuData() {
        allMenuRecyclerView = findViewById(R.id.allMenu_recycler);
        allMenuAdapter = new AllMenuAdapter(this, listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
    }

}