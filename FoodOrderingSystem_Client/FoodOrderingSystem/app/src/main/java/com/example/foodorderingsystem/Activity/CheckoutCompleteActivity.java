package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.Order;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckoutCompleteActivity extends AppCompatActivity {
    int total;
    int bcoins;
    String rName,rAddress,cName,cPhone,note,time,code;

    ApiInterface apiInterface;
    SessionManagement sessionManagement;

    MaterialButton btnhome;

    List<Order> listOrders;
    List<OrderDetail> listOrderDetails;
    List<Cart> listCart;

    TextView tv_bcoinpay,tv_customName, tv_change,tv_phone, tv_storeName,tv_address,tv_note,tv_date,tv_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkoutcomplete);
        apiInterface = Api.getClients();
        sessionManagement = new SessionManagement(CheckoutCompleteActivity.this);


        listOrders = new ArrayList<>();
        listCart = new ArrayList<>();
        listOrderDetails = new ArrayList<>();

        getLastOrders();
        setInfo();
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CheckoutCompleteActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }
    private void setInfo(){
        Intent intent = getIntent();


        tv_bcoinpay = findViewById(R.id.tv_bcoinpay);
        tv_customName = findViewById(R.id.tv_customName);
        tv_change = findViewById(R.id.tv_change);
        tv_phone = findViewById(R.id.tv_phone);
        tv_storeName = findViewById(R.id.tv_storeName);
        tv_address = findViewById(R.id.tv_address);
        tv_note = findViewById(R.id.tv_note);
        tv_date = findViewById(R.id.tv_date);
        tv_code = findViewById(R.id.tv_code);
        btnhome = findViewById(R.id.btnhome);

        total = intent.getIntExtra("total",0);
        rName = intent.getStringExtra("rName");
        rAddress = intent.getStringExtra("rAddress");
        cName = intent.getStringExtra("cName");
        cPhone = intent.getStringExtra("cPhone");
        bcoins = intent.getIntExtra("bcoin", 0);
        note = intent.getStringExtra("note");
        time = intent.getStringExtra("time");
        code = intent.getStringExtra("code");

        tv_bcoinpay.setText(String.valueOf("- "+total+" BCOINS"));
        tv_customName.setText(cName);
        tv_change.setText(String.valueOf(bcoins));
        tv_phone.setText(cPhone);
        tv_storeName.setText(rName);
        tv_address.setText(rAddress);
        tv_note.setText(note);
        tv_date.setText(time);
        tv_code.setText(code);
    }

    public void getLastOrders(){
        apiInterface = Api.getClients();
        Call<List<Order>> call = apiInterface.getOrders();
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                listOrders = response.body();

                listCart = sessionManagement.getDataFromSharedPreferences();
                listOrderDetails.clear();
                for(Cart cart : listCart){
                    listOrderDetails.add(new OrderDetail(listOrders.get(0).getoID(),cart.getpID(),cart.getCartQuantity(),cart.getpPrice(),cart.getCartQuantity() * cart.getpPrice()));
                }
                for(OrderDetail orderDetail : listOrderDetails){
                    AddOrderDetail(orderDetail);
                }
                sessionManagement.removeCart();
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Log.e("Error: ", t.getMessage().toString());
                Toast.makeText(CheckoutCompleteActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void AddOrderDetail(OrderDetail orderDetail){
        apiInterface = Api.getClients ();
        int id = listOrders.get(0).getoID();
        Call<OrderDetail> call= apiInterface.addOrderDetail(orderDetail);
        call.enqueue(new Callback<OrderDetail> () {
            @Override
            public void onResponse(Call<OrderDetail> call, Response<OrderDetail> response) {
                if(response.isSuccessful()){
                }else {
                }
            }
            @Override
            public void onFailure(Call<OrderDetail> call, Throwable t) {

                Log.e("Error:",t.getMessage());
            }
        });

    }


}
