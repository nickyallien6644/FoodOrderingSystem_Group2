package com.example.foodorderingsystem.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingsystem.Activity.MainActivity;
import com.example.foodorderingsystem.Activity.SignInActivity;
import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BcoinsFragment extends Fragment {
    SessionManagement session ;
    List<Account> listAccounts;
    ApiInterface accountService;
    CheckBox cbbank;
    Account account;
    Button btnRecharge;
    TextView txtBconins;
    TextView txtTotal;
    TextInputLayout etxtBcoins;
    TextInputEditText etxtCoins;
    int uID;
    int total;
    public BcoinsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bcoins, container, false);
        listAccounts = new ArrayList<>();
        session = new SessionManagement (getActivity().getApplication());
        uID = session.getSession();
        cbbank = v.findViewById(R.id.cb_bank);
        btnRecharge = v.findViewById(R.id.btn_Recharge);
        txtBconins = v.findViewById(R.id.txt_Bicons);
        etxtBcoins = v.findViewById(R.id.eText_Recharge);
        txtTotal = v.findViewById(R.id.txt_Total);
        etxtCoins = v.findViewById(R.id.etxt_Bcoins);
        int coins= session.getBcoins();
        txtTotal.setText(coins + " Bcoins");

        etxtCoins.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    int rechager = Integer.parseInt(etxtBcoins.getEditText().getText().toString().trim());
                    if (Pattern.compile("^[1-9]+").matcher (etxtBcoins.getEditText().getText().toString().trim()).matches ()) {
                        etxtBcoins.setError(null);
                        total = coins + rechager;
                        String strTotal = String.valueOf(total);
                        txtTotal.setText(strTotal + " Bcoins");
                    }
                    else {
                        etxtBcoins.setError("Bcoins must be more than zero");
                    }

                } else {
                    txtTotal.setText(coins + " Bcoins");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        checkSession(uID);
        cbbank.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked ){
                    btnRecharge.setEnabled(true);
                }else {
                    btnRecharge.setEnabled(false);
                }
            }
        });
        btnRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = new Account();

                account.setaCoins(total);
                account.setaID(uID);

                UpdateCoins(account);

            }
        });

        // Inflate the layout for this fragment
        return v;

    }

    public void UpdateCoins(Account account){
        accountService = Api.getClients ();
        Call<Account> call= accountService.updateBcoins(account);
        call.enqueue(new Callback<Account> () {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getActivity(),"Add coins successful",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(), "Add coins fail", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Account> call, Throwable t) {

                Log.e("Error:",t.getMessage());
            }
        });
        session = new SessionManagement (getActivity()) ;
        session.saveSession (account);
        Intent intent =new Intent(getActivity(), MainActivity.class);
        startActivity(intent);

    }

    public void checkSession(int uID){

        int uBcoins = session.getBcoins ();
        if (uID < 0){
            session.removeSession();
            Intent intent =new Intent(getActivity(), SignInActivity.class);
            startActivity(intent);
        }
        txtBconins.setText(uBcoins + " Bcoins");
    }


}