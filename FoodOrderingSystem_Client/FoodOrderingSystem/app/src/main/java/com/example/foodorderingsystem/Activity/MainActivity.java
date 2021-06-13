package com.example.foodorderingsystem.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById (R.id.btnLogin);

        TextView txtuser = findViewById (R.id.test);
        Bundle bundleUser = getIntent().getExtras();
        if(bundleUser != null){
            Account account = (Account) bundleUser.get ("Oject_User");
            if (account != null){
                txtuser.setText (account.toString());
            }
       }
    }

}