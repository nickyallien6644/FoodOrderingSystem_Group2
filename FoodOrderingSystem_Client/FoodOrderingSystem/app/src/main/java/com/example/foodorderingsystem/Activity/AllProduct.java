package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.AllProductAdapter;
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

    SearchView txtSearchProduct;

    ImageView backAllProduct, shoppingCartAllProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);

        allProductRecycler = findViewById(R.id.listAllProductRecycler);
        listAllProduct = new ArrayList<>();
        listAllProduct();

        backAllProduct = findViewById(R.id.backAllProduct);
        backAllProduct.setOnClickListener(backAllProduct());

        shoppingCartAllProduct = findViewById(R.id.shoppingCartAllProduct);
        shoppingCartAllProduct.setOnClickListener(openCart());

        txtSearchProduct = (SearchView) findViewById(R.id.resultSearch);
        searchProduct();
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

    private View.OnClickListener openCart() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
            }
        };
    }

    private View.OnClickListener backAllProduct() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };
    }

    public void searchProduct() {
        txtSearchProduct.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                intent.putExtra("search", query);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
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