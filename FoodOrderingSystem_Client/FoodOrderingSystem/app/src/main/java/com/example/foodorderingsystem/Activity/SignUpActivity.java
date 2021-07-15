package com.example.foodorderingsystem.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
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
    List<Account> listAccounts;
    boolean checkaccount;
    Account user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        listAccounts = new ArrayList<>();
        CheckDuplicateperson();
        checkaccount = false;
    }

    public void btnSignUp(View view){
        etxtEmail = findViewById (R.id.ipEmail);
        etxtLname= findViewById (R.id.ipLastname);
        etxtFname= findViewById (R.id.ipFirstname);
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
            account.setaCoins(0);
            account.setaFirstname(etxtFname.getEditText ().getText().toString());
            account.setaLastName(etxtLname.getEditText ().getText().toString());
            account.setaPassword(etxtPassword.getEditText ().getText().toString());
            account.setaStatus(1);
            account.setRoleID(1);
            account.setaPhone(etxtPhone.getEditText ().getText().toString());
            for(int i=0 ;i<listAccounts.size();i++){
                if (listAccounts.get(i).getaEmail().equals(account.getaEmail())){
                    checkaccount = true;
                    etxtEmail.setError("Account have exist!!!");
                    break;
                }
            }
            if (!checkaccount){
                addPersona(account);
                Intent intent =new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
                overridePendingTransition (R.anim.slide_in_left,R.anim.slide_out_right);
            }else{
                return;
            }
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
        overridePendingTransition (R.anim.slide_in_left,R.anim.slide_out_right);
    }
    public void CheckDuplicateperson(){
        accountService = Api.getClients();
        Call<List<Account>> call = accountService.getAccounts();
        call.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if(response.isSuccessful()){
                    listAccounts = response.body();
                }

            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
    }
    private boolean validateEmail(){
    String inputEmail = etxtEmail.getEditText().getText ().toString ().trim ();
    if (inputEmail.isEmpty ()){
        etxtEmail.setError ("Email is not empty");
        return false;
    }else if (!Patterns.EMAIL_ADDRESS.matcher (inputEmail).matches ()){
        etxtEmail.setError ("Invalid email");
        return false;
    }
    else {
        etxtEmail.setError (null);
        return true;
    }
}
    private boolean validateLastName(){
        String inputLname = etxtLname.getEditText().getText ().toString ().trim ();
        if (inputLname.isEmpty()){
            etxtLname.setError ("Last name is not empty");
            return false;
        }else if(!Pattern.compile("^([a-zA-Z]{1,})$").matcher (inputLname).matches ()){
            etxtLname.setError ("Invalid last name");
            return false;
        } else {
            etxtLname.setError (null);
            return true;
        }
    }
    private boolean validateFirstName(){
        String inputFname = etxtFname.getEditText().getText ().toString ().trim ();
        if (inputFname.isEmpty ()){
            etxtFname.setError ("First name is not empty");
            return false;
        }else if(!Pattern.compile("^([a-zA-Z]{2,}(\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)?)").matcher (inputFname).matches ()){
            etxtFname.setError ("Invalid first name");
            return false;
        } else {
            etxtFname.setError (null);
            return true;
        }
    }
    private boolean validatePass(){
        String inputPass = etxtPassword.getEditText().getText ().toString ().trim ();
        if (inputPass.isEmpty ()){
            etxtPassword.setError ("Password is not empty");
            return false;
        }else if(!Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$").matcher (inputPass).matches ()){
            etxtPassword.setError ("Password must have 8-16 character, have uppercase character and special character");
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
            etxtCpass.setError ("Confirm Password is not empty");
            return false;
        }if (!inputCpass.equals (password)) {
            etxtCpass.setError ("Confirm Password is not equals Password");
            return false;
        } else {
            etxtCpass.setError (null);
            return true;
        }
    }
    private boolean validatePhone(){
        String inputPhone = etxtPhone.getEditText ().getText ().toString ().trim ();
        if (inputPhone.isEmpty ()){
            etxtPhone.setError ("Phone number is not empty");
            return false;
        }else if(inputPhone.length ()>10){
            etxtPhone.setError ("Invalid phone number");
            return false;
        }
        else {
            etxtPhone.setError (null);
            return true;
        }
    }
    private boolean validateAddress(){
        String address = etxtAdress.getEditText().getText ().toString ().trim ();
        if (address.isEmpty ()){
            etxtAdress.setError ("Address is not empty");
            return false;
        }else if(!Pattern.compile("^\\d+(\\s[A-z]+)+").matcher (address).matches ()){
            etxtAdress.setError ("Invalid address");
            return false;
        }else {
            etxtAdress.setError (null);
            return true;
        }
    }

    public void btnSignin(View v){
        SessionManagement sessionManagement = new SessionManagement (SignUpActivity.this);
        sessionManagement.removeSession ();
        Intent intent =new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
        overridePendingTransition (R.anim.slide_in_left,R.anim.slide_out_right);
    }
    public static final Pattern EMAIL_ADDRESS =
            Pattern.compile ("[a-zA-Z0-9_]{5,20}@(Gmail|gmail|email|Email)(.com|.edu)(.edu|.vn)*$");
}
