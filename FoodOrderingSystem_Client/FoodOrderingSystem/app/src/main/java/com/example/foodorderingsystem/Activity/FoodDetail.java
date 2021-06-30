package com.example.foodorderingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDetail extends AppCompatActivity {

    String pName, pDescription, iURL;
    double pPrice;

    ImageView imageView, imageReturnHome;
    TextView itemName, itemPrice, itemDescription;

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

        Glide.with(getApplicationContext()).load(iURL).into(imageView);
        itemName.setText(pName);
        itemPrice.setText(String.valueOf(pPrice) + " Bcoins");
        itemDescription.setText(pDescription);
    }

    public void outProductDetail(View v) {
        finish();
    }
}