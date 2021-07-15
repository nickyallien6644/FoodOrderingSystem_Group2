package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class ProductByCategory extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView productByCategoryReCycler;

    List<Product> listProductByFood;
    ProductByFoodAdapter productByFoodAdapter;

    List<Product> listProductByDrink;
    ProductByDrinkAdapter productByDrinkAdapter;

    List<Product> listProductByCake;
    ProductByCakeAdapter productByCakeAdapter;

    TextView txtTitle;
    ImageView backCategoryProduct, shoppingCartForCategoryOfProduct;

    SearchView txtSearchProduct;

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productbycategory);

        productByCategoryReCycler = findViewById(R.id.listProductByCategoryRecycler);
        listProductByFood = new ArrayList<>();

        txtTitle = findViewById(R.id.txtTitle);

        txtSearchProduct = (SearchView) findViewById(R.id.resultSearch);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        if(position == 0) {
            txtTitle.setText("Food Category");
            listProductByFood();
            searchProductForFood();
        } else if(position == 1) {
            txtTitle.setText("Drink Category");
            listProductByDrink();
            searchProductForDrink();
        } else if(position == 2) {
            txtTitle.setText("Cake Category");
            listProductByCake();
            searchProductForCake();
        }

        backCategoryProduct = findViewById(R.id.backCategoryProduct);
        backCategoryProduct.setOnClickListener(backProductForCategory());

        shoppingCartForCategoryOfProduct = findViewById(R.id.shoppingCartForCategoryOfProduct);
        shoppingCartForCategoryOfProduct.setOnClickListener(openCart());
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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        productByCategoryReCycler.setLayoutManager(layoutManager);
        productByCategoryReCycler.setAdapter(productByFoodAdapter);
    }

    private void listProductByDrink() {
        apiInterface = Api.getClients();
        Call<List<Product>> call = apiInterface.getProductByDrink();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProductByDrink = response.body();
                getProductByDrinkData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getProductByDrinkData() {
        productByDrinkAdapter = new ProductByDrinkAdapter(getApplicationContext(), listProductByDrink);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        productByCategoryReCycler.setLayoutManager(layoutManager);
        productByCategoryReCycler.setAdapter(productByDrinkAdapter);
    }

    private void listProductByCake() {
        apiInterface = Api.getClients();
        Call<List<Product>> call = apiInterface.getProductByCake();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProductByCake = response.body();
                getProductByCakeData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getProductByCakeData() {
        productByCakeAdapter = new ProductByCakeAdapter(getApplicationContext(), listProductByCake);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        productByCategoryReCycler.setLayoutManager(layoutManager);
        productByCategoryReCycler.setAdapter(productByCakeAdapter);
    }

    private View.OnClickListener openCart() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
            }
        };
    }

    private View.OnClickListener backProductForCategory() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };
    }

    public void searchProductForFood() {
        txtSearchProduct.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getApplicationContext(), SearchForFoodActivity.class);
                intent.putExtra("searchForFood", query);
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

    public void searchProductForDrink() {
        txtSearchProduct.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getApplicationContext(), SearchForDrinkActivity.class);
                intent.putExtra("searchForDrink", query);
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

    public void searchProductForCake() {
        txtSearchProduct.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(getApplicationContext(), SearchForCakeActivity.class);
                intent.putExtra("searchForCake", query);
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