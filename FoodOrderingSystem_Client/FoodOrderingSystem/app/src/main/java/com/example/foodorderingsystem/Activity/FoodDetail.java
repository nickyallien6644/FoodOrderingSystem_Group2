package com.example.foodorderingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodDetail extends AppCompatActivity {

    String pName, pDescription, iURL;
    int pPrice, iID, pID,rID;
    int quantity;

    ImageView imageView, imagePlus, imageMinus, openCart;
    TextView itemName, itemPrice, itemDescription, quantityNumber;
    Button addToCart;
    List<Cart> cartList;

    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        openCart = findViewById(R.id.cartFoodDetail);
        openCart.setOnClickListener(openCart());

        sessionManagement = new SessionManagement(getApplicationContext());


        Intent intent = getIntent();
        pID = intent.getIntExtra("pID", 0);
        pName = intent.getStringExtra("name");
        pPrice = intent.getIntExtra("price", 0);
        pDescription = intent.getStringExtra("description");
        iID = intent.getIntExtra("iID", 0);
        iURL = intent.getStringExtra("image");
        rID = intent.getIntExtra("rID",0);

        imageView = findViewById(R.id.pDetailImage);
        itemName = findViewById(R.id.pDetailName);
        itemPrice = findViewById(R.id.pDetailPrice);
        itemDescription = findViewById(R.id.pDetailDescription);
        imagePlus = findViewById(R.id.img_plus);
        imageMinus = findViewById(R.id.img_minus);
        quantityNumber = findViewById(R.id.quantity_product);
        addToCart = findViewById(R.id.btnAddToCart);

        cartList = new ArrayList<>();

        Glide.with(getApplicationContext()).load(iURL).into(imageView);
        itemName.setText(pName);
        itemPrice.setText(String.valueOf(pPrice) + " Bcoins");
        itemDescription.setText(pDescription);
        quantity = 1;
        imagePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                displayQuantity();
            }
        });

        imageMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity > 1){
                    quantity--;
                    displayQuantity();
                }
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList = sessionManagement.getDataFromSharedPreferences();
                if(cartList == null){
                    sessionManagement.CheckCart(new Cart(1, quantity , pID ,pName, pPrice, iID, iURL, sessionManagement.getSession(),rID));
                    Toast.makeText(getApplicationContext(), "Add to cart successful!", Toast.LENGTH_SHORT).show();
                }else{
                    if(cartList.get(0).getrID() == rID){
                        sessionManagement.CheckCart(new Cart(1, quantity , pID ,pName, pPrice, iID, iURL, sessionManagement.getSession(),rID));
                        Toast.makeText(getApplicationContext(), "Add to cart successful!", Toast.LENGTH_SHORT).show();
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(FoodDetail.this);

                        builder.setMessage("Your product in different restaurant. Do you want to remove your cart and add new product ?")
                                .setPositiveButton("Add to cart", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        sessionManagement.removeCart();
                                        sessionManagement.CheckCart(new Cart(1, quantity , pID ,pName, pPrice, iID, iURL, sessionManagement.getSession(),rID));
                                        Toast.makeText(getApplicationContext(), "Add to cart successful!", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }
                                });
                        builder.create().show();

                    }
                }

            }
        });
    }

    private View.OnClickListener openCart() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
            }
        };
    }

    private void displayQuantity() {
        quantityNumber.setText(String.valueOf(quantity));
    }

    public void outProductDetail(View v) {
        finish();
    }
}