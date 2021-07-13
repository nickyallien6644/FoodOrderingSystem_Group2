package com.example.foodorderingsystem.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.foodorderingsystem.Activity.MainActivity;
import com.example.foodorderingsystem.Activity.SignInActivity;
import com.example.foodorderingsystem.Activity.SignUpActivity;
import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment{
    Button btnSaveChange;
    TextView txtEmail;
    TextInputEditText txtFirstname;
    TextInputEditText txtLastname;
    TextInputEditText txtPhone;
    TextInputLayout txtPassword;
    TextInputLayout txtConfirmpassword;
    ApiInterface accountService;
    Account user;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ex, container, false);
        MainActivity activity = (MainActivity) getActivity();
        Account account1 = activity.getdata();
        txtFirstname = v.findViewById(R.id.txtFirtname);
        txtEmail = v.findViewById(R.id.txtEmail);
        txtPhone = v.findViewById(R.id.txtPhone);
        txtPassword = v.findViewById(R.id.txtPassword);
        btnSaveChange = v.findViewById(R.id.btnSaveChange);
        txtLastname = v.findViewById(R.id.txtLastname);
        txtConfirmpassword = v.findViewById(R.id.txtConfirmPassword);
        txtEmail.setText(account1.getaEmail());
        txtFirstname.setText(account1.getaFirstname());
        txtLastname.setText(account1.getaLastName());
        txtPhone.setText(account1.getaPhone());
        btnSaveChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(!validateLastName ()|!validateFirstName () | !validateConfirmPass() | !validatePass() | !validatePhone ()){
                    return;
                }else {
                    int id = account1.getaID();
                    Account p = new Account();
                    p.setaID(id);
                    p.setaPhone(txtPhone.getText().toString());
                    p.setaFirstname(txtFirstname.getText().toString());
                    p.setaLastName(txtLastname.getText().toString());
                    p.setaPassword(txtPassword.getEditText().getText().toString());
                    p.setaEmail(txtEmail.getText().toString());
                    accountService = Api.getClients();
                    Call<Account>call=accountService.updatePersona(p,id);
                    call.enqueue(new Callback<Account>() {
                        @Override
                        public void onResponse(Call<Account> call, Response<Account> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(getContext(), "Update is successfull.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<Account> call, Throwable t) {
                            Log.e("Error: tú tú ",t.getMessage());
                        }
                    });
                }
            }
        });
        return v;
    }

    private boolean validateLastName(){
        String inputLname = txtLastname.getText ().toString ().trim ();
        if (inputLname.isEmpty()){
            txtLastname.setError ("Last name is not empty");
            return false;
        }else if(!Pattern.compile("^([a-zA-Z]{1,})$").matcher (inputLname).matches ()){
            txtLastname.setError ("Invalid last name");
            return false;
        } else {
            txtLastname.setError (null);
            return true;
        }
    }
    private boolean validateFirstName(){
        String inputFname = txtFirstname.getText ().toString ().trim ();
        if (inputFname.isEmpty ()){
            txtFirstname.setError ("First name is not empty");
            return false;
        }else if(!Pattern.compile("^([a-zA-Z]{2,}(\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)?)").matcher (inputFname).matches ()){
            txtFirstname.setError ("Invalid first name");
            return false;
        } else {
            txtFirstname.setError (null);
            return true;
        }
    }
    private boolean validatePass(){
        String inputPass = txtPassword.getEditText().getText ().toString ().trim ();
        if (inputPass.isEmpty ()){
            txtPassword.setError ("Password is not empty");
            return false;
        }else if(!Pattern.compile("^[A-Z]+[a-z0-9]{7,15}+").matcher (inputPass).matches ()){
            txtPassword.setError ("Password must have 8-16 character, have uppercase character and special character");
            return false;
        }
        else {
            txtPassword.setError (null);
            return true;
        }
    }
    private boolean validateConfirmPass(){
        String inputCpass = txtConfirmpassword.getEditText().getText ().toString ().trim ();
        String password = txtConfirmpassword.getEditText().getText ().toString ().trim ();

        if (inputCpass.isEmpty ()){
            txtConfirmpassword.setError ("Confirm Password is not empty");
            return false;
        }if (!inputCpass.equals (password)) {
            txtConfirmpassword.setError ("Confirm Password is not equals Password");
            return false;
        } else {
            txtConfirmpassword.setError (null);
            return true;
        }
    }
    private boolean validatePhone(){
        String inputPhone = txtPhone.getText ().toString ().trim ();
        if (inputPhone.isEmpty ()){
            txtPhone.setError ("Phone number is not empty");
            return false;
        }else if(inputPhone.length ()>10){
            txtPhone.setError ("Invalid phone number");
            return false;
        }
        else {
            txtPhone.setError (null);
            return true;
        }
    }

}
