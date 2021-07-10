package com.example.foodorderingsystem.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class ConfirmEmail extends Fragment {
    SessionManagement session ;
    TextView sstxtEmail;
    TextView txtError;
    EditText eTxtNum1;
    EditText eTxtNum2;
    EditText eTxtNum3;
    EditText eTxtNum4;
    EditText eTxtNum5;
    Button btnConfigmCode;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_confirm_email, container, false);
        session = new SessionManagement(getActivity().getApplication());
        sstxtEmail = v.findViewById(R.id.txt_ssEmail);
        txtError = v.findViewById(R.id.txt_ErrorForgot);
        String Emailconfign = session.getEmailforgot();
        sstxtEmail.setText("Email has been sent ' " + Emailconfign + " '");
        eTxtNum1 = v.findViewById(R.id.edit_Num1);
        eTxtNum2 = v.findViewById(R.id.edit_Num2);
        eTxtNum3 = v.findViewById(R.id.edit_Num3);
        eTxtNum4 = v.findViewById(R.id.edit_Num4);
        eTxtNum5 = v.findViewById(R.id.edit_Num5);
        btnConfigmCode = v.findViewById(R.id.btn_ConfigmCode);
        btnConfigmCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eTxtNum1.getText().toString().trim().isEmpty() ||eTxtNum2.getText().toString().trim().isEmpty() ||
                        eTxtNum3.getText().toString().trim().isEmpty() ||
                        eTxtNum4.getText().toString().trim().isEmpty() ||
                        eTxtNum5.getText().toString().trim().isEmpty()){
                    txtError.setText("Code is empty");
                    txtError.setVisibility(View.VISIBLE);
                }else {
                    txtError.setVisibility(View.INVISIBLE);
                    String CodeConfirm = (eTxtNum1.getText().toString() + eTxtNum2.getText().toString()+
                            eTxtNum3.getText().toString()+eTxtNum4.getText().toString()+eTxtNum5.getText().toString());
                    if(CodeConfirm.equals(session.getCodeforgot())){
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.add(R.id.Frgment_ConfigEmail, new CreateNewPassword());
                        fragmentTransaction.commit();
                    }else {
                        txtError.setText("Code invalid ");
                        txtError.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        EventInput();
        return v;
    }
    public void EventInput(){
        eTxtNum1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    eTxtNum1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        eTxtNum2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    eTxtNum2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        eTxtNum3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    eTxtNum3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        eTxtNum4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    eTxtNum4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        eTxtNum5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    eTxtNum5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


}