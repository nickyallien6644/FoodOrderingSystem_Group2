package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.CheckoutContentAdapter;
import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.Notification;
import com.example.foodorderingsystem.Model.Order;
import com.example.foodorderingsystem.Model.Restaurant;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckoutActivity extends AppCompatActivity {

    RecyclerView rcy_checkoutContent;
    CheckoutContentAdapter checkoutContentAdapter;
    ApiInterface apiInterface;
    MultiAutoCompleteTextView note;
    Intent intent;
    int total;
    int bcoins;
    String rName,rAddress,cName,cPhone;

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
        note = findViewById(R.id.tv_note);

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
            btn_confirm.setVisibility(View.INVISIBLE);
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
                Toast.makeText(CheckoutActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void UpdateCoins(Account account){
        apiInterface = Api.getClients ();
        Call<Account> call= apiInterface.updateBcoins(account);
        call.enqueue(new Callback<Account> () {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(response.isSuccessful()){
                }else {
                }
            }
            @Override
            public void onFailure(Call<Account> call, Throwable t) {

                Log.e("Error:",t.getMessage());
            }
        });

    }

    public void AddOrder(Order order){
        apiInterface = Api.getClients ();
        Call<Order> call= apiInterface.addOrder(order);
        call.enqueue(new Callback<Order> () {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                if(response.isSuccessful()){
                }else {
                }
            }
            @Override
            public void onFailure(Call<Order> call, Throwable t) {

                Log.e("Error:",t.getMessage());
            }
        });

    }
    public void clickBackCheckout(View v){
        finish();
    }

    public void clickConfirm(View v){
        Intent intent = new Intent(CheckoutActivity.this, CheckoutCompleteActivity.class);
        intent.putExtra("total",total);
        intent.putExtra("rName", resInfo.get(0).getrName());
        intent.putExtra("rAddress", resInfo.get(0).getrAddress());
        intent.putExtra("cName", sessionManagement.getSessionLastname() + " " + sessionManagement.getSessionFirstname());
        intent.putExtra("cPhone", sessionManagement.getSessionPhone());
        intent.putExtra("bcoin", bcoins - total);
        intent.putExtra("note",note.getText().toString());
        intent.putExtra("time", String.valueOf(LocalDateTime.now()));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String stringDate= dateFormat.format(date);

        String day = String.valueOf(date.getDay());
        String month = String.valueOf(date.getMonth());
        String year = String.valueOf(date.getYear());
        String hour = String.valueOf(date.getHours());
        String minues = String.valueOf(date.getMinutes());
        String second = String.valueOf(date.getSeconds());
        intent.putExtra("code", String.valueOf(sessionManagement.getSessionFirstname().substring(0,1)+day+month+year+hour+minues+second));


        Order order = new Order();
        order.setaID(sessionManagement.getSession());
        order.setrID(listCart.get(0).getrID());
        order.setoAmountTotal(total);
        order.setoDateCreate(stringDate);
        order.setoNote(note.getText().toString());
        order.setoCode(String.valueOf(sessionManagement.getSessionFirstname().substring(0,1)+day+month+year+hour+minues+second));
        order.setoStatus(0);
        AddOrder(order);

        Notification  notification = new Notification(1,sessionManagement.getSession(),listCart.get(0).getrID(),"Your order has been confirmed by the administrator",0);
        addNofi(notification);
        Account account = new Account();
        account.setaID(sessionManagement.getSession());
        account.setaCoins(bcoins - total);
        UpdateCoins(account);
        sessionManagement.removeSessionCoin(bcoins - total);
        startActivity(intent);
    }

    public void clickBcoins(View v){
        Intent intent2 = new Intent(CheckoutActivity.this, MainActivity.class);
        startActivity(intent2);
    }


    public void addNofi (Notification notification){
        apiInterface = Api.getClients();
        Call<Notification> call= apiInterface.addNofication(notification);
        call.enqueue(new Callback<Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {
                if(response.isSuccessful()){

                }
            }
            @Override
            public void onFailure(Call<Notification> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });

    }


}