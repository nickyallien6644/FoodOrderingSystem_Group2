package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.foodorderingsystem.Adapter.AllMenuAdapter;
import com.example.foodorderingsystem.Adapter.CategoryAdapter;
import com.example.foodorderingsystem.Adapter.CheckoutContentAdapter;
import com.example.foodorderingsystem.Adapter.RecommendedAdapter;
import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.Restaurant;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.example.foodorderingsystem.fragment.HomeFragment;
import com.example.foodorderingsystem.fragment.NotificationFragment;
import com.example.foodorderingsystem.fragment.PrivacyFragment;
import com.example.foodorderingsystem.fragment.ProfileFragment;
import com.example.foodorderingsystem.fragment.QuestionsFragment;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckoutActivity extends AppCompatActivity {

    RecyclerView rcy_checkoutContent;
    CheckoutContentAdapter checkoutContentAdapter;
    ApiInterface apiInterface;
    Intent intent;
    int total;
    int bcoins;

    AppCompatButton btn_confirm,btn_addcoin;
    TextView tv_errorCoin,tv_customName,tv_customPhone,tv_storeName,tv_total;

    List<Cart> listCart;
    List<Restaurant> resInfo;

    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        sessionManagement = new SessionManagement(this);
        intent = getIntent();

        btn_confirm = findViewById(R.id.btn_confirm);
        btn_addcoin = findViewById(R.id.btn_addBcoins);
        rcy_checkoutContent = findViewById(R.id.rcy_contentView);
        tv_errorCoin = findViewById(R.id.tv_errorcoin);
        tv_customName = findViewById(R.id.tv_customName);
        tv_customPhone = findViewById(R.id.tv_customPhone);
        tv_storeName = findViewById(R.id.tv_storeName);
        tv_total = findViewById(R.id.tv_total);

        listCart = new ArrayList<>();
        resInfo = new ArrayList<>();
        listCart = sessionManagement.getDataFromSharedPreferences();
        total = intent.getIntExtra("total",0);
        bcoins = sessionManagement.getBcoins();

        if(sessionManagement.getBcoins() > total){
            tv_errorCoin.setVisibility(View.INVISIBLE);

            btn_addcoin.setVisibility(View.INVISIBLE);
        }else{
            tv_errorCoin.setVisibility(View.VISIBLE);

            btn_addcoin.setVisibility(View.VISIBLE);
        }


        getRestaurantInfo(listCart.get(0).getrID());

        setRecycleView();
    }

    private void setRecycleView(){
        rcy_checkoutContent.setHasFixedSize(true);
        rcy_checkoutContent.setLayoutManager(new LinearLayoutManager(this));
        checkoutContentAdapter = new CheckoutContentAdapter(this,listCart);
        rcy_checkoutContent.setAdapter(checkoutContentAdapter);
    }

    private void setInfo(){
        tv_customName.setText(String.valueOf(sessionManagement.getSessionLastname() + " " + sessionManagement.getSessionFirstname()));
        tv_customPhone.setText(String.valueOf(sessionManagement.getSessionPhone()));
        tv_storeName.setText(resInfo.get(0).getrName());
        tv_total.setText(String.valueOf(total));
    }

    private void getRestaurantInfo(int rID){
        apiInterface = Api.getClients();

        Call<List<Restaurant>> call = apiInterface.getRestaurantInfo(rID);
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                resInfo = response.body();
                setInfo();
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void clickBackCheckout(View v){
        finish();
    }
}