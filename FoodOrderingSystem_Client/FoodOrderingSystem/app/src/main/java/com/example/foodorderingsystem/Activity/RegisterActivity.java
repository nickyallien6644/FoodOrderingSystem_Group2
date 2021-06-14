package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.example.foodorderingsystem.Utils.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    ApiInterface accountService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void btnResgister(View view){
        TextView email =(TextView) findViewById(R.id.RetxtEmail);
        TextView phone =(TextView) findViewById(R.id.RetxtPhone);
        TextView password =(TextView) findViewById(R.id.RetxtPass);
        TextView firstName =(TextView) findViewById(R.id.RetxtFirstName);
        TextView lastName =(TextView) findViewById(R.id.RetxtLastName);
        TextView address = (TextView) findViewById(R.id.RetxtAddress);

        Account account = new Account();
        account.setaEmail(email.getText().toString());
        account.setaAddress(address.getText().toString());
        account.setaCoins(0.0);
        account.setaFirstname(firstName.getText().toString());
        account.setaLastName(lastName.getText().toString());
        account.setaPassword(password.getText().toString());
        account.setaStatus(1);
        account.setRoleID(1);
        account.setaPhone(phone.getText().toString());

        addPersona(account);

        Intent intent =new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void addPersona(Account p){
        accountService = Api.getClients();
        Call<Account> call= accountService.addPersona(p);
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(response.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"AAA",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
