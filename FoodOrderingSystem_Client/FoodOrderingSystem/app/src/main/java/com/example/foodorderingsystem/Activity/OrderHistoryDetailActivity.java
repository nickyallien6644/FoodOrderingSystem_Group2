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
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.CheckoutContentAdapter;
import com.example.foodorderingsystem.Adapter.OrderDetailContentAdapter;
import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.Order;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.Product;
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

public class OrderHistoryDetailActivity extends AppCompatActivity {

    RecyclerView rcy_orderhistorycontent;
    OrderDetailContentAdapter orderDetailContentAdapter;
    ApiInterface apiInterface;
    Intent intent;

    TextView tv_customName,tv_customPhone,tv_storeName,tv_code,tv_datetime,tv_total,tv_status;

    List<OrderDetail> listOrderDetails;
    List<Product> listProducts;

    int oID,oStatus,total;
    String rName,oCode,oDateCreate;

    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderhistorydetail);
        sessionManagement = new SessionManagement(this);
        intent = getIntent();

        rcy_orderhistorycontent = findViewById(R.id.rcy_orderhistorycontent);
        tv_customName = findViewById(R.id.tv_customName);
        tv_customPhone = findViewById(R.id.tv_customPhone);
        tv_storeName = findViewById(R.id.tv_storeName);
        tv_code = findViewById(R.id.tv_code);
        tv_datetime = findViewById(R.id.tv_datetime);
        tv_total = findViewById(R.id.tv_total);
        tv_status = findViewById(R.id.tv_status);

        listOrderDetails = new ArrayList<>();
        listProducts = new ArrayList<>();

        oID = intent.getIntExtra("oID",0);
        rName = intent.getStringExtra("rName");
        oCode = intent.getStringExtra("oCode");
        oDateCreate = intent.getStringExtra("oDateCreate");
        oStatus = intent.getIntExtra("oStatus",0);
        total = intent.getIntExtra("oTotal",0);

        getOrderDetail(oID);
        getProduct();


    }

    private void setRecycleView(){
        rcy_orderhistorycontent.setHasFixedSize(true);
        rcy_orderhistorycontent.setLayoutManager(new LinearLayoutManager(this));
        orderDetailContentAdapter = new OrderDetailContentAdapter(this, listOrderDetails, listProducts);
        rcy_orderhistorycontent.setAdapter(orderDetailContentAdapter);
    }

    private void setInfo(){
        tv_customName.setText(String.valueOf(sessionManagement.getSessionLastname() + " " + sessionManagement.getSessionFirstname()));
        tv_customPhone.setText(String.valueOf(sessionManagement.getSessionPhone()));
        tv_storeName.setText(rName);
        tv_datetime.setText(oDateCreate);
        tv_code.setText(oCode);
        if(oStatus == 1){
            tv_status.setText("CONFIRMED");
            tv_status.setTextColor(ContextCompat.getColor(OrderHistoryDetailActivity.this, R.color.confirm));
        }else{
            tv_status.setText("UNCONFIRMED");
            tv_status.setTextColor(ContextCompat.getColor(OrderHistoryDetailActivity.this, R.color.red));
        }
        tv_total.setText(String.valueOf(total));
    }

    private void getOrderDetail(int oID){
        apiInterface = Api.getClients();

        Call<List<OrderDetail>> call = apiInterface.getOrderDetail(oID);
        call.enqueue(new Callback<List<OrderDetail>>() {
            @Override
            public void onResponse(Call<List<OrderDetail>> call, Response<List<OrderDetail>> response) {
                listOrderDetails = response.body();
                setInfo();
            }

            @Override
            public void onFailure(Call<List<OrderDetail>> call, Throwable t) {
                Toast.makeText(OrderHistoryDetailActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getProduct(){
        apiInterface = Api.getClients();

        Call<List<Product>> call = apiInterface.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProducts = response.body();
                setRecycleView();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(OrderHistoryDetailActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickBackCheckout(View v){
        finish();
    }

}