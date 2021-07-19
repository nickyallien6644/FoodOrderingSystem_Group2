package com.example.foodorderingsystem.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.foodorderingsystem.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = WelcomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getToken();
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
    public void getToken(){
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()){
                    Log.d(TAG, "Failed to get the token");
                    return;
                }
                String token = task.getResult();
                Log.d(TAG, "token: " + token);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {
                Log.d(TAG, "Failed to get the token" + e.getLocalizedMessage());

            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG,"On new intent called");
    }
}