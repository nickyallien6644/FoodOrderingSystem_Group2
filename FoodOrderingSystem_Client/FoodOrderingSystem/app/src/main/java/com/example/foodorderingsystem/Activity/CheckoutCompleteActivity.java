package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingsystem.Model.Order;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.google.android.material.button.MaterialButton;

public class CheckoutCompleteActivity extends AppCompatActivity {
    int total;
    int bcoins;
    String rName,rAddress,cName,cPhone,note,time,code;

    MaterialButton btnhome;

    TextView tv_bcoinpay,tv_customName, tv_change,tv_phone, tv_storeName,tv_address,tv_note,tv_date,tv_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkoutcomplete);

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

}
