package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.Adapter.MenuResAdapter;
import com.example.foodorderingsystem.Adapter.RecommendedResAdapter;
import com.example.foodorderingsystem.Adapter.SeeAllResAdapter;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.Restaurant;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    List<Product> listProducts;
    List<Product> listSeeAll;
    List<Restaurant> resInfo;
    RecyclerView menuRecyclerView;
    RecyclerView recommendedRecyclerView;
    RecyclerView MenuSeeAllRecyclerView;
    RecommendedResAdapter recommendedAdapter;
    SeeAllResAdapter seeAllResAdapter;
    MenuResAdapter menuResAdapter;
    SearchView searchSeeAll;

    View bottomSheetView;

    TextView tv_restaurant, tv_timeOpen, tv_timeClose, tv_address,tv_phone;
    ImageView iv_restaurant;

    int rID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail_activity);
        bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_seeallmenu,(LinearLayout)findViewById(R.id.bottom_menu));

        Intent intent = getIntent();
        rID  = intent.getIntExtra("rID",0);
        resInfo = new ArrayList<>();
        getRestaurantInfo(rID);
        listProducts = new ArrayList<>();
        listProducts(rID);
        listSeeAll = new ArrayList<>();
        listSeeAll(rID);
    }

    private void getRestaurantMenu() {
        menuRecyclerView = findViewById(R.id.restaurantRes_menu);
        menuResAdapter = new MenuResAdapter(this.getApplicationContext(), listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantActivity.this, LinearLayoutManager.VERTICAL, false);

        menuRecyclerView.setLayoutManager(layoutManager);
        menuRecyclerView.setAdapter(menuResAdapter);
    }

    private void getRestaurantMenuSeeAll() {
        MenuSeeAllRecyclerView = bottomSheetView.findViewById(R.id.seeall_ryc);
        searchSeeAll = bottomSheetView.findViewById(R.id.searchSeeAll);
        searchSeeAll.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.equals("")){
                    listSeeAll.clear();
                    listSeeAll = new ArrayList<>();
                    listSeeAll(rID);
                }else{
                    listSeeAll.clear();
                    listSeeAll = new ArrayList<>();
                    listSeeAllSearch(newText,rID);
                }
                return false;
            }
        });
        seeAllResAdapter = new SeeAllResAdapter(this.getApplicationContext(), listSeeAll);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantActivity.this, LinearLayoutManager.VERTICAL, false);

        MenuSeeAllRecyclerView.setLayoutManager(layoutManager);
        MenuSeeAllRecyclerView.setAdapter(seeAllResAdapter);
    }

    private void getRestaurantInfo(int rID){
        apiInterface = Api.getClients();

        Call<List<Restaurant>> call = apiInterface.getRestaurantInfo(rID);
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                resInfo = response.body();
                setResInfo();
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Toast.makeText(RestaurantActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setResInfo(){
        tv_restaurant = findViewById(R.id.tv_restaurant);
        tv_timeOpen = findViewById(R.id.tv_timeOpen);
        tv_timeClose = findViewById(R.id.tv_timeClose);
        tv_address = findViewById(R.id.tv_address);
        tv_phone = findViewById(R.id.tv_phone);
        iv_restaurant = findViewById(R.id.iv_restaurant);

        tv_restaurant.setText(resInfo.get(0).getrName());
        tv_timeOpen.setText(resInfo.get(0).getrTimeOpen());
        tv_timeClose.setText(resInfo.get(0).getrTimeClose());
        tv_address.setText(resInfo.get(0).getrAddress());
        tv_phone.setText(resInfo.get(0).getrPhone());
        Glide.with(RestaurantActivity.this).load(resInfo.get(0).getrImage()).into(iv_restaurant);

     }

    public void listProducts(int rID) {
        apiInterface = Api.getClients();
        Call<List<Product>> call = apiInterface.getProductByRID(rID);
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
        recommendedRecyclerView = findViewById(R.id.recommendedRes_recycler);
        recommendedAdapter = new RecommendedResAdapter(this.getApplicationContext(), listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);
    }

    public void clickBack(View v){
        Intent intent = new Intent(RestaurantActivity.this, SearchActivity.class);
        startActivity(intent);
    }

    public void listSeeAll(int rID){
        apiInterface = Api.getClients();
        Call<List<Product>> call = apiInterface.getProductByRIDSeeAll(rID);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listSeeAll = response.body();
                getRestaurantMenuSeeAll();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(RestaurantActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void listSeeAllSearch(String search, int rID){
        apiInterface = Api.getClients();
        Call<List<Product>> call = apiInterface.getAllProductForAllCategory(search,rID);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listSeeAll = response.body();
                getRestaurantMenuSeeAll();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(RestaurantActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickSeeall(View v){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(RestaurantActivity.this, R.style.BottomSheatDialogTheme);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}