package com.example.foodorderingsystem.fragment;


import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingsystem.Activity.MainActivity;
import com.example.foodorderingsystem.Adapter.AllProductAdapter;
import com.example.foodorderingsystem.Adapter.NoficationAdapter;
import com.example.foodorderingsystem.Adapter.OrderHistoryAdapter;
import com.example.foodorderingsystem.Model.Notification;
import com.example.foodorderingsystem.Model.Order;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.Restaurant;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    List<Notification> listnotification;
    ApiInterface apiInterface;
    RecyclerView allRecyclerView;
    List<Restaurant> listRestaurant;
    NoficationAdapter noficationAdapter;
    SessionManagement sessionManagement;
    int a;
    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.nofication_fragment,container,false);
        listRestaurant = new ArrayList<>();
        listnotification = new ArrayList<>();
        sessionManagement =  new SessionManagement (getActivity().getApplication());
        a = sessionManagement.getSession();
        allRecyclerView = v.findViewById(R.id.recycler_nofication);
        getRestaurantInfo();
        getNofiInfo();
        return v;
    }

    private void getNofiInfo(){
        apiInterface = Api.getClients();
        Call<List<Notification>> call = apiInterface.ListNofication(a);
        call.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                listnotification = response.body();
                setRecycle();
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getRestaurantInfo(){
        apiInterface = Api.getClients();
        Call<List<Restaurant>> call = apiInterface.getAllRestaurantInfo();
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                listRestaurant= response.body();
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setRecycle(){
        noficationAdapter  = new NoficationAdapter(getContext(),listRestaurant,listnotification);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        allRecyclerView.setLayoutManager(layoutManager);
        allRecyclerView.setAdapter(noficationAdapter);
    }
}
