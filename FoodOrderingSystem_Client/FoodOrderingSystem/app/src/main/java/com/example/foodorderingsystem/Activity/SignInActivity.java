package com.example.foodorderingsystem.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.example.foodorderingsystem.Utils.Api;
import com.google.android.material.textfield.TextInputLayout;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    ApiInterface accountService;
    private List<Account> listAccounts;
    Account user;

    String email, password;
    boolean isAcount = false;
    TextInputLayout etxtMail;
    TextInputLayout etxtpass;
    TextView txtError;
    SessionManagement sessionManagement;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        listAccounts = new ArrayList<> ();
        getUser ();
        checkSession();

    }
    private boolean validateEmail(){
        String inputEmail = etxtMail.getEditText().getText ().toString ().trim ();
        if (inputEmail.isEmpty ()){
            etxtMail.setError ("Email not empty");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher (inputEmail).matches ()){
            etxtMail.setError ("Email invaluable please input again");
            return false;
        }
        else {
            etxtMail.setError (null);
            return true;
        }
    }
    private boolean validatePass(){
        if (etxtpass.getEditText().getText ().toString ().trim ().isEmpty ()){
            etxtpass.setError ("Pass not empty");
            return false;
        }
        else {
            etxtpass.setError (null);
            return true;
        }
    }
    public void getUser() {
        listAccounts = new ArrayList<> ();
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
    public void btnSignin(View v){
        txtError = findViewById (R.id.txtError);
        etxtMail = findViewById(R.id.inputLayoutEmail);
        etxtpass = findViewById(R.id.inputLayoutPass);
        if(!validateEmail () |!validatePass () | listAccounts == null || listAccounts.isEmpty ()){
            return;
        }else {
            email = etxtMail.getEditText ().getText ().toString ().trim ();
            password = md5 (etxtpass.getEditText ().getText ().toString ().trim ());
            for (Account account : listAccounts) {
                if (email.equals (account.getaEmail ()) && password.equals (account.getaPassword ())) {
                    isAcount = true;
                    user = account;
                    Toast.makeText (SignInActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show ();
                    break;
                }
            }
            if (isAcount) {
                Intent intent = new Intent (SignInActivity.this, MainActivity.class);
                sessionManagement = new SessionManagement (SignInActivity.this) ;
                sessionManagement.saveSession (user);
                startActivity (intent);
                overridePendingTransition (R.anim.slide_in_right, R.anim.slide_out_left);
            } else {
                txtError.setVisibility (View.VISIBLE);
                Toast.makeText (SignInActivity.this, "Sign in fail", Toast.LENGTH_SHORT).show ();
            }
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
    public static final Pattern EMAIL_ADDRESS =
            Pattern.compile ("[a-zA-Z0-9_]{5,20}@(Gmail|gmail|email|Email)(.com|.edu)(.edu|.vn)*$");
    public void checkSession(){
        SessionManagement sessionManagement = new SessionManagement (SignInActivity.this);
        int uID = sessionManagement.getSession ();
        if (uID !=-1){
            Intent intent = new Intent (SignInActivity.this, MainActivity.class);
            startActivity (intent);
        }
    }
    public void btnSignup(View v){
        Intent intent =new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
        overridePendingTransition (R.anim.slide_in_right,R.anim.slide_out_left);
    }
    public void ForgotPassword(View v){
        Intent intent =new Intent(SignInActivity.this, ForgotPassword.class);
        startActivity(intent);
        overridePendingTransition (R.anim.slide_in_right,R.anim.slide_out_left);
    }

}
