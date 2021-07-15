package com.example.foodorderingsystem.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodorderingsystem.Activity.SignInActivity;
import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CreateNewPassword extends Fragment {

    SessionManagement session ;
    TextInputLayout elayoutNewpass;
    TextInputLayout elayoutConfigrmNewpass;
    TextInputEditText etxtNewpass;
    TextInputEditText etxtConfigrmNewpass;
    List<Account> listAccounts;
    ApiInterface accountService;
    Account account;
    Button btnCreateNew;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create_new_password, container, false);
        session = new SessionManagement(getActivity().getApplication());
        int uID = session.getSession();
        etxtNewpass = v.findViewById(R.id.etxt_newPass);
        elayoutNewpass = v.findViewById(R.id.elayout_NewPass);

        etxtConfigrmNewpass = v.findViewById(R.id.etxt_ConfigmnewPass);
        elayoutConfigrmNewpass= v.findViewById(R.id.elayout_ConfigmNewPass);
        btnCreateNew = v.findViewById(R.id.btn_CreateNewPass);
        etxtNewpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    if (!validatePass()) {
                        elayoutNewpass.setError(" Password is not empty");
                    }else {
                        elayoutNewpass.setError(null);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etxtConfigrmNewpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    if (!validateConfirmPass()) {
                        elayoutConfigrmNewpass.setError("Confirm Password is not equals Password");
                    }else {
                        elayoutConfigrmNewpass.setError(null);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnCreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = new Account();
                String NewPass = etxtNewpass.getText().toString().trim();
                account.setaPassword(NewPass);
                account.setaID(uID);
                CreadNewPass(account);
            }
        });
        return  v;
    }
    private boolean validatePass(){
        String inputPass = elayoutNewpass.getEditText().getText ().toString ().trim ();
        if (inputPass.isEmpty ()){
            elayoutNewpass.setError ("Password is not empty");
            return false;
        }else if(!Pattern.compile("^[A-Z]+[a-z0-9]{7,15}+").matcher (inputPass).matches ()){
            elayoutNewpass.setError ("Password must have 8-16 character, have uppercase character and special character");
            return false;
        }
        else {
            elayoutNewpass.setError (null);
            return true;
        }
    }

    private boolean validateConfirmPass(){
        String inputCpass = elayoutConfigrmNewpass.getEditText().getText ().toString ().trim ();
        String password = elayoutNewpass.getEditText().getText ().toString ().trim ();

        if (inputCpass.isEmpty ()){
            elayoutConfigrmNewpass.setError ("Confirm Password is not empty");
            return false;
        }if (!inputCpass.equals (password)) {
            elayoutConfigrmNewpass.setError ("Confirm Password is not equals Password");
            return false;
        } else {
            elayoutConfigrmNewpass.setError (null);
            return true;
        }
    }
    public void CreadNewPass(Account account){
        accountService = Api.getClients ();
        Call<Account> call= accountService.forgotPassword(account);
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getActivity(),"Create new Password successful",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(), "Create new Password fail", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Account> call, Throwable t) {

                Log.e("Error:",t.getMessage());
            }
        });
        session = new SessionManagement (getActivity()) ;
        session.removeSession();
        Intent intent =new Intent(getActivity(), SignInActivity.class);
        startActivity(intent);

    }
}