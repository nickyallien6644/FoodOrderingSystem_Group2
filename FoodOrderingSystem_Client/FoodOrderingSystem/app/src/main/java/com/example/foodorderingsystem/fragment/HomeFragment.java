package com.example.foodorderingsystem.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodorderingsystem.Activity.MainActivity;
import com.example.foodorderingsystem.Adapter.AllMenuAdapter;
import com.example.foodorderingsystem.Adapter.PopularAdapter;
import com.example.foodorderingsystem.Adapter.RecommendedAdapter;
import com.example.foodorderingsystem.Model.Product;
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
public class HomeFragment extends Fragment {

    ApiInterface apiInterface;
    List<Product> listProducts ;

    RecyclerView popularRecyclerView;
    PopularAdapter popularAdapter;

    RecyclerView recommendedRecyclerView;
    RecommendedAdapter recommendedAdapter;

    RecyclerView allMenuRecyclerView;
    AllMenuAdapter allMenuAdapter;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main,container,false);
        popularRecyclerView = v.findViewById(R.id.popular_recycler);
        recommendedRecyclerView = v.findViewById(R.id.recommended_recycler);
        allMenuRecyclerView = v.findViewById(R.id.allMenu_recycler);
        listProducts = new ArrayList<>();
        listProducts();
        // Inflate the layout for this fragment
        return v;
    }

    public void listProducts() {
        apiInterface = Api.getClients();

        Call<List<Product>> call = apiInterface.getProducts ();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProducts = response.body();
                getPopularData();
                getRecommendedData();
                getAllMenuData();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPopularData() {
        popularAdapter = new PopularAdapter(getContext(), listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);
    }

    private void getRecommendedData() {
        recommendedAdapter = new RecommendedAdapter(getContext(), listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);
    }

    private void getAllMenuData() {
        allMenuAdapter = new AllMenuAdapter(getContext(), listProducts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
    }

}
