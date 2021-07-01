package com.example.foodorderingsystem.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BcoinsFragment extends Fragment {

    CheckBox cbbank;
    Button btnRecharge;
    SessionManagement session;
    TextView txtBconins;
    TextInputLayout etxtBcoins;
    public BcoinsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bcoins, container, false);
        cbbank = v.findViewById(R.id.cb_bank);
        btnRecharge = v.findViewById(R.id.btn_Recharge);
        txtBconins = v.findViewById(R.id.txt_Bicons);
        etxtBcoins = v.findViewById(R.id.inputLayoutBcoins);
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
        // Inflate the layout for this fragment
        return v;

    }

}