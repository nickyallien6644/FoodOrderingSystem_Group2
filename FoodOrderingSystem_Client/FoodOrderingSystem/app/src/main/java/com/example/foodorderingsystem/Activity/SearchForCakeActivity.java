package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.SearchAdapter;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.Restaurant;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchForCakeActivity extends AppCompatActivity {
    ApiInterface apiInterface;

    SearchView searchView;
    List<Product> searchProduct;
    List<Product> resultSearch;
    List<Restaurant> getAllRes;
    List<Product> listProductSearchForCake;
    boolean checkResult = false, checkChangeText = false;
    String search = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAllRes();

        setContentView(R.layout.activity_search);
        searchView = (SearchView) findViewById(R.id.resultSearch);
        searchProduct = new ArrayList<>();
        getAllRes = new ArrayList<>();
        listProductSearchForCake = new ArrayList<>();
        getResultForCake(listProductSearchForCake);

    }
    public void getAllRes(){
        apiInterface = Api.getClients();
        Call<List<Restaurant>> call = apiInterface.getAllRestaurantInfo();
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                getAllRes = (ArrayList)response.body();
            }
            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {

            }
        });

    }

    public void getResultForCake(List<Product> listProductSearchForCake) {
        apiInterface = Api.getClients();

        resultSearch = new ArrayList<>();
        Intent intent = getIntent();
        if (intent.getStringExtra("searchForCake") != null) {
            search = intent.getStringExtra("searchForCake");
        }
        Call<List<Product>> call = apiInterface.getProductByCake();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                resultSearch = (ArrayList) response.body();
                if (!search.equals(null)) {
                    searchView.setQuery(search, false);
                    for (Product product : resultSearch) {
                        if (product.getpName().toLowerCase().contains(search.toLowerCase())) {
                            listProductSearchForCake.add(product);
                            checkResult = true;
                        }
                    }
                    if (listProductSearchForCake.size() == 0) {
                        Toast.makeText(SearchForCakeActivity.this, "Couldn't find the matching result you were searching for!", Toast.LENGTH_SHORT).show();
                    }
                }

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        searchProduct.clear();
                        if (resultSearch.size() != 0) {
                            for (Product product : resultSearch) {
                                if (product.getpName().toLowerCase().contains(newText.toLowerCase())) {
                                    searchProduct.add(product);
                                } else if (newText.equals("")) {
                                    searchProduct.add(product);
                                }
                            }
                            checkChangeText = true;
                            searchResult(searchProduct);
                        }
                        return false;
                    }
                });
                if (checkResult == true) {
                    searchResult(listProductSearchForCake);
                    checkResult = false;
                }

            }

            public void searchResult(List<Product> listResult) {
                RecyclerView recyclerView = findViewById(R.id.ListRecycleSearch);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                SearchAdapter searchAdapter = new SearchAdapter(getApplicationContext(), listResult, getAllRes);
                recyclerView.setAdapter(searchAdapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void main(View v) {
//        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.removeExtra("search");
        startActivity(intent);
    }
}