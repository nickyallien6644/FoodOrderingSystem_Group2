package com.example.foodorderingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.foodorderingsystem.R;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        final Intent i = new Intent(this, SignInActivity.class);
        Thread timer = new Thread(){
            @Override
            public void run() {
               try {
                   sleep(2000);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }finally {
                   startActivity(i);
                   finish();
               }
            }
        };
        timer.start();
    }
}