package com.example.foodorderingsystem.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.AccountInterface;
import com.example.foodorderingsystem.Utils.Api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    AccountInterface accountService;
    private List<Account> listAccounts;
    Account user;

    String email, password;
    boolean isAcount = false;
    Button btnSignIn;
    EditText txtMail;
    EditText txtpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        listAccounts = new ArrayList<> ();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        txtMail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        txtpass = (EditText) findViewById(R.id.editTextTextPassword);

        btnSignIn = (Button) findViewById(R.id.btnSignin);
        getUser();

        btnSignIn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Login ();
            }
        });
    }
    public void getUser() {
        accountService= Api.getClients ();  // call Api get PersonService
        Call<List<Account>> call=accountService.getAccounts (); // call list get Student
        call.enqueue(new Callback<List<Account>> () {
            /**
             * On Response is the data that the server returns to the client
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if(response.isSuccessful()) {
                    listAccounts = response.body();
                    Log.e ("List User",listAccounts.size ()+"");
                }
            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
    }
    public void Login(){
        email = txtMail.getText ().toString ().trim ();
        password  = md5 (txtpass.getText ().toString ().trim ());
        if(listAccounts == null || listAccounts.isEmpty ()){
            return;
        }
        for ( Account account: listAccounts){

            if(email.equals (account.getaEmail ()) && password.equals (account.getaPassword ())){
                isAcount = true;
                user = account;
                Toast.makeText (LoginActivity.this, "Yes",Toast.LENGTH_SHORT).show();
                break;
            }
        }
        if (isAcount){
            Intent intent = new Intent (LoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle ();
            bundle.putSerializable ("Oject_User",user);
            intent.putExtras (bundle);
            startActivity (intent);
        }else {
            Toast.makeText (LoginActivity.this, "likecat",Toast.LENGTH_SHORT).show();
        }
    }
    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
