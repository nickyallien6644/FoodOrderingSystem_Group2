package com.example.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.foodorderingsystem.Utils.AccountInterface;
import com.example.foodorderingsystem.Utils.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    AccountInterface accountService;
    private List<Account>listAccounts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfAccounts();

        EditText editEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String txtEmail = editEmail.getText().toString().trim();
        EditText editPass = (EditText) findViewById(R.id.editTextTextPassword);
        String txtPass = editPass.getText().toString().trim();
        Button btnSignin = (Button) findViewById(R.id.btnSignin);



    }

    public void listOfAccounts(){
        //get url
        accountService = Service.getClients();
        //get element of url to list
        Call<List<Account>> call = accountService.getAccounts();
        call.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                listAccounts = response.body();
//                listAccounts.setAdapter(new AccountAdapter(MainActivity.this, R.layout.activity_main,listAccounts));
            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
    }

    public void login(View v){
        for (Account account: listAccounts) {

        }
    }
}