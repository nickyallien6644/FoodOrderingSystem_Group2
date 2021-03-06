package com.example.foodorderingsystem.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.CartAdapter;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.example.foodorderingsystem.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    RecyclerView cartRecycler;
    ImageView imgPlus, imgMinus;
    TextView cartQuantity, cartTotalPrice;
    SessionManagement session ;
    List<Cart> listCart;
    List<OrderDetail> listOrderDetails;
    CartAdapter cartAdapter;
    SessionManagement sessionManagement;
    AppCompatButton btn_order;
    ImageView backCart;
    int totalPrice = 0;
    private int quantity;
    private String pName, iURL;
    int pPrice, iID, pID,rID;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        backCart = findViewById(R.id.backCart);
        backCart.setOnClickListener(backCart());

        sessionManagement = new SessionManagement(getApplicationContext());

        session = new SessionManagement (CartActivity.this);

        cartTotalPrice = findViewById(R.id.txt_final_price);

        Intent intent = getIntent();
        cartRecycler = findViewById(R.id.recycler_cart);
        cartQuantity = findViewById(R.id.quantity_product);
        imgPlus = findViewById(R.id.img_plus);
        imgMinus = findViewById(R.id.img_minus);
        btn_order = findViewById(R.id.btn_order);
        pID = intent.getIntExtra("pID", 0);
        rID = intent.getIntExtra("rID",0);
        pName = intent.getStringExtra("pName");
        pPrice = intent.getIntExtra("pPrice", 0);
        iID = intent.getIntExtra("iID", 0);
        iURL = intent.getStringExtra("iURL");
        quantity = intent.getIntExtra("cartQuantity", 0);
        listCart = new ArrayList<>();
        listOrderDetails = new ArrayList<>();
        listCart = sessionManagement.getDataFromSharedPreferences();
        if(listCart != null) {
            for (Cart c : listCart) {
                totalPrice += c.getpPrice() * c.getCartQuantity();
            }
        } else {
            totalPrice = 0;
        }
        cartTotalPrice.setText(String.valueOf(totalPrice) + " Bcoins");
        getCartData();
        LocalBroadcastManager.getInstance(this).registerReceiver(mQuantityReceiver, new IntentFilter("clickAdd"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mQuantityReceiver, new IntentFilter("clickMinus"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mQuantityReceiver, new IntentFilter("deleteItemCart"));
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listCart != null){
                    Intent intent1 = new Intent(CartActivity.this, CheckoutActivity.class);
                    intent1.putExtra("total",totalPrice);
                    startActivity(intent1);
                }else {
                    Toast.makeText(CartActivity.this, "Your cart is empty, please add to cart", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public BroadcastReceiver mQuantityReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            listCart = sessionManagement.getDataFromSharedPreferences();
            totalPrice = 0;
            if(listCart != null) {
                for (Cart c : listCart) {
                    totalPrice += c.getpPrice() * c.getCartQuantity();
                }
            } else {
                totalPrice = 0;
            }
            cartTotalPrice.setText(String.valueOf(totalPrice) + " Bcoins");
            getCartData();
        }
    };

    private void getCartData() {
        cartAdapter = new CartAdapter(getApplicationContext(), listCart);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        cartRecycler.setLayoutManager(layoutManager);
        cartRecycler.setAdapter(cartAdapter);
    }

    private View.OnClickListener backCart() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };
    }



}
