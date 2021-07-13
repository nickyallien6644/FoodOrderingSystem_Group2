package com.example.foodorderingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.fragment.CartFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodDetail extends AppCompatActivity {

    String pName, pDescription, iURL;
    int pPrice;
    int quantity;

    ImageView imageView, imagePlus, imageMinus;
    TextView itemName, itemPrice, itemDescription, quantityNumber;
    Button addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        Intent intent = getIntent();

        pName = intent.getStringExtra("name");
        pPrice = intent.getIntExtra("price", 0);
        pDescription = intent.getStringExtra("description");
        iURL = intent.getStringExtra("image");

        imageView = findViewById(R.id.pDetailImage);
        itemName = findViewById(R.id.pDetailName);
        itemPrice = findViewById(R.id.pDetailPrice);
        itemDescription = findViewById(R.id.pDetailDescription);
        imagePlus = findViewById(R.id.img_plus);
        imageMinus = findViewById(R.id.img_minus);
        quantityNumber = findViewById(R.id.quantity_product);
        addToCart = findViewById(R.id.btnAddToCart);

        Glide.with(getApplicationContext()).load(iURL).into(imageView);
        itemName.setText(pName);
        itemPrice.setText(String.valueOf(pPrice) + " Bcoins");
        itemDescription.setText(pDescription);

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
                if(quantity == 0) {
                    Toast.makeText(FoodDetail.this, "Can't decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                }
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodDetail.this, CartFragment.class);
                intent.putExtra("pName", pName);
                intent.putExtra("pPrice", pPrice);
                intent.putExtra("cartQuantity", quantityNumber.getText());
                intent.putExtra("iURL", iURL);
                startActivity(intent);
            }
        });
    }

    private void displayQuantity() {
        quantityNumber.setText(String.valueOf(quantity));
    }

    public void outProductDetail(View v) {
        finish();
    }
}