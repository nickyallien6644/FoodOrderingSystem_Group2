package com.example.foodorderingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Model.*;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.foodorderingsystem.Adapter.SearchAdapter;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.example.foodorderingsystem.Utils.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    ApiInterface apiInterface;

    SearchView searchView;
    List<Product> searchProduct;
    List<Product> resultSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Product> listProductSearch;
        listProductSearch = new ArrayList<>();
        setContentView(R.layout.activity_search);
        searchView = (SearchView) findViewById(R.id.resultSearch);
        searchProduct = new ArrayList<>();
        listProductSearch = new ArrayList<>();
        getResult(listProductSearch);

    }

    public void getResult(List<Product> listProductSearch) {
        apiInterface = Api.getClients();

        resultSearch = new ArrayList<>();
        Intent intent = getIntent();
        String search = intent.getStringExtra("search");
        Call<List<Product>> call = apiInterface.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                resultSearch = (ArrayList) response.body();
                for (Product product : resultSearch) {
                    if (product.getpName().toLowerCase().contains(search.toLowerCase())) {
                        listProductSearch.add(product);
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
                        if (listProductSearch.size() != 0)
                            for (Product product : listProductSearch) {
                                if (product.getpName().toLowerCase().contains(newText.toLowerCase())) {
                                    searchProduct.add(product);
                                }
                            }
                        searchResult(searchProduct);
                        return false;
                    }

                });
                if (!(searchProduct.size() == 0)) {
                    listProductSearch.clear();
                    for (int i = 0; i < searchProduct.size(); i++) {
                        listProductSearch.set(i, searchProduct.get(i));
                    }
                }

                RecyclerView recyclerView = findViewById(R.id.ListRecycleSearch);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
                SearchAdapter searchAdapter = new SearchAdapter(getApplicationContext(), listProductSearch);
                recyclerView.setAdapter(searchAdapter);
            }

            public void searchResult(List<Product> listResult) {
                RecyclerView recyclerView = findViewById(R.id.ListRecycleSearch);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
                SearchAdapter searchAdapter = new SearchAdapter(getApplicationContext(), listResult);
                recyclerView.setAdapter(searchAdapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}