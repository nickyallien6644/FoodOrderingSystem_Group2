package com.example.foodorderingsystem.Activity;

import android.accounts.Account;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.AccountInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    AccountInterface accountService;
    private List<Account> listAccounts;

    String email, password;

    Button btnSignIn;
    Button btnRegister;
    EditText txtMail;
    EditText txtpass;

    private static final String URL_PRODUCTS = "http://192.168.1.45:8080/user/list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        txtMail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        txtpass = (EditText) findViewById(R.id.editTextTextPassword);

        btnSignIn = (Button) findViewById(R.id.btnSignin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }
}
