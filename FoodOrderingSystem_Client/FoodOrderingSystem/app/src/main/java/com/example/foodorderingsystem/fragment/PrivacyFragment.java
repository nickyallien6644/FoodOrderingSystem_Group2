package com.example.foodorderingsystem.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.PrivacyPolicyAdapter;
import com.example.foodorderingsystem.Model.PrivacyPolicy;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrivacyFragment extends Fragment {

    ApiInterface apiInterface;
    List<PrivacyPolicy> listPrivacyPolicy ;
    RecyclerView privacyPolicyRecycler;
    PrivacyPolicyAdapter privacyPolicyAdapter;

    public PrivacyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_privacy, container, false);

        privacyPolicyRecycler = v.findViewById(R.id.privacyPolicyRecycler);
        listPrivacyPolicy = new ArrayList<>();
        listPrivacyPolicy();

        return v;
    }

    private void listPrivacyPolicy() {
        apiInterface = Api.getClients();
        Call<List<PrivacyPolicy>> call = apiInterface.getPrivacyPolicy();
        call.enqueue(new Callback<List<PrivacyPolicy>>() {
            @Override
            public void onResponse(Call<List<PrivacyPolicy>> call, Response<List<PrivacyPolicy>> response) {
                listPrivacyPolicy = response.body();
                getPrivacyPolicyData();
            }

            @Override
            public void onFailure(Call<List<PrivacyPolicy>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getPrivacyPolicyData() {
        privacyPolicyAdapter = new PrivacyPolicyAdapter(getContext(), listPrivacyPolicy);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        privacyPolicyRecycler.setLayoutManager(layoutManager);
        privacyPolicyRecycler.setAdapter(privacyPolicyAdapter);
    }
}
