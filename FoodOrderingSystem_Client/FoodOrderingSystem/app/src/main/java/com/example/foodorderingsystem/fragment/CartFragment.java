package com.example.foodorderingsystem.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Adapter.CartAdapter;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.ApiInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {
    ApiInterface apiInterface;
    RecyclerView cartRecycler;
    ImageView imgPlus, imgMinus;
    TextView cartQuantity;

    List<Cart> listCart;
    CartAdapter cartAdapter;

    private int quantity;
    private String pName, iURL;
    int pPrice, iID, pID;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_cart_list, container, false);
       // Intent intent = getActivity().getIntent();
//        cartRecycler = v.findViewById(R.id.recycler_cart);
//        cartQuantity = v.findViewById(R.id.quantity_product);
//        imgPlus = v.findViewById(R.id.img_plus);
//        imgMinus = v.findViewById(R.id.img_minus);
////        pID = intent.getIntExtra("pID", 0);
////        pName = intent.getStringExtra("pName");
////        pPrice = intent.getIntExtra("pPrice", 0);
////        iID = intent.getIntExtra("iID", 0);
////        iURL = intent.getStringExtra("iURL");
////        quantity = intent.getIntExtra("cartQuantity", 0);
//        getArguments().getInt("pID");
//        getArguments().getString("pName");
//        getArguments().getInt("pPrice");
//        getArguments().getInt("iID");
//        getArguments().getString("iURL");
//        getArguments().getInt("cartQuantity");
//        Log.e("onCreateView: ", quantity + "");
//        listCart = new ArrayList<>();
//        listCart.add(new Cart(1, quantity, pID ,pName, pPrice, iID, iURL, 34 ));
//        getCartData();
        return v;
    }

    //    private void listCart() {
//        apiInterface = Api.getClients();
//        Call<List<Product>> call = apiInterface.getAllProductForAllCategory();
//        call.enqueue(new Callback<List<Product>>() {
//            @Override
//            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//                listAllProduct = response.body();
//                getAllProductData();
//            }
//
//            @Override
//            public void onFailure(Call<List<Product>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void getCartData() {
        cartAdapter = new CartAdapter(getContext(), listCart);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        cartRecycler.setLayoutManager(layoutManager);
        cartRecycler.setAdapter(cartAdapter);
    }
}