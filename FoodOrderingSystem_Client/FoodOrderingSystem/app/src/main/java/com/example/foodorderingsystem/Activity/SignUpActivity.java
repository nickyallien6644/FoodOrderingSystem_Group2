package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    ApiInterface accountService;
    TextInputLayout etxtEmail;
    TextInputLayout etxtLname;
    TextInputLayout etxtFname;
    TextInputLayout etxtPassword;
    TextInputLayout etxtCpass;
    TextInputLayout etxtPhone;
    TextInputLayout etxtAdress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void btnSignUp(View view){
        etxtEmail = findViewById (R.id.ipEmail);
        etxtLname= findViewById (R.id.ipLastname);
        etxtFname= findViewById (R.id.ipFirthname);
        etxtPassword= findViewById (R.id.ipPassword);
        etxtCpass= findViewById (R.id.inConfirmPass);
        etxtPhone= findViewById (R.id.ipPhone);
        etxtAdress= findViewById (R.id.ipAddress);
        if(!validateEmail()|!validateLastName ()|!validateFirstName ()|!validatePass ()|!validateConfirmPass ()|!validatePhone ()|!validateAddress ()){
            return;
        }else {
            Account account = new Account();
            account.setaEmail(etxtEmail.getEditText ().getText().toString());
            account.setaAddress(etxtAdress.getEditText ().getText().toString());
            account.setaCoins(0.0);
            account.setaFirstname(etxtFname.getEditText ().getText().toString());
            account.setaLastName(etxtLname.getEditText ().getText().toString());
            account.setaPassword(etxtPassword.getEditText ().getText().toString());
            account.setaStatus(1);
            account.setRoleID(1);
            account.setaPhone(etxtPhone.getEditText ().getText().toString());
            addPersona(account);
            Intent intent =new Intent(SignUpActivity.this,SignInActivity.class);
            startActivity(intent);
            overridePendingTransition (R.anim.slide_in_right,R.anim.slide_out_left);
        }

    }
    public void addPersona(Account p){
        accountService = Api.getClients ();
        Call<Account> call= accountService.addPersona(p);
        call.enqueue(new Callback<Account> () {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(response.isSuccessful()){
                    Toast.makeText(SignUpActivity.this,"Register successful",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(SignUpActivity.this,SignInActivity.class);
        startActivity(intent);
        overridePendingTransition (R.anim.slide_in_right,R.anim.slide_out_left);
    }
    private boolean validateEmail(){
    String inputEmail = etxtEmail.getEditText().getText ().toString ().trim ();
    if (inputEmail.isEmpty ()){
        etxtEmail.setError ("Email not empty");
        return false;
    }else if (!Patterns.EMAIL_ADDRESS.matcher (inputEmail).matches ()){
        etxtEmail.setError ("Email invaluable please input again");
        return false;
    }
    else {
        etxtEmail.setError (null);
        return true;
    }
}
    private boolean validateLastName(){
        String inputLname = etxtLname.getEditText().getText ().toString ().trim ();
        if (inputLname.isEmpty ()){
            etxtLname.setError ("Last name not empty");
            return false;
        } else {
            etxtLname.setError (null);
            return true;
        }
    }
    private boolean validateFirstName(){
        String inputFname = etxtFname.getEditText().getText ().toString ().trim ();
        if (inputFname.isEmpty ()){
            etxtFname.setError ("Name is not empty");
            return false;
        } else {
            etxtFname.setError (null);
            return true;
        }
    }
    private boolean validatePass(){
        String inputPass = etxtPassword.getEditText().getText ().toString ().trim ();
        if (inputPass.isEmpty ()){
            etxtPassword.setError ("Password not empty");
            return false;
        }
        else {
            etxtPassword.setError (null);
            return true;
        }
    }
    private boolean validateConfirmPass(){
        String inputCpass = etxtCpass.getEditText().getText ().toString ().trim ();
        String password = etxtPassword.getEditText().getText ().toString ().trim ();

        if (inputCpass.isEmpty ()){
            etxtCpass.setError ("Confirm Password not empty");
            return false;
        }else if (!inputCpass.equals (password)) {
            etxtCpass.setError ("Confirm Password not equals Password");
            return false;
        } else {
            etxtCpass.setError ("Confirm Password not empty");
            return true;
        }
    }
    private boolean validatePhone(){
        String inputPhone = etxtPhone.getEditText ().getText ().toString ().trim ();
        if (inputPhone.isEmpty ()){
            etxtPhone.setError ("Phone not empty");
            return false;
        }else if(inputPhone.length ()>10){
            etxtPhone.setError ("Phone Number qua lon ");
            return false;
        }
        else {
            etxtPhone.setError (null);
            return true;
        }
    }
    private boolean validateAddress(){
        if (etxtAdress.getEditText().getText ().toString ().trim ().isEmpty ()){
            etxtAdress.setError ("Address not empty");
            return false;
        }
        else {
            etxtAdress.setError (null);
            return true;
        }
    }

    public void btnSignin(View v){
        SessionManagement sessionManagement = new SessionManagement (SignUpActivity.this);
        sessionManagement.removeSession ();
        Intent intent =new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
        overridePendingTransition (R.anim.slide_in_right,R.anim.slide_out_left);
    }
    public static final Pattern EMAIL_ADDRESS =
            Pattern.compile ("[a-zA-Z0-9_]{5,20}@(Gmail|gmail|email|Email)(.com|.edu)(.edu|.vn)*$");
}
