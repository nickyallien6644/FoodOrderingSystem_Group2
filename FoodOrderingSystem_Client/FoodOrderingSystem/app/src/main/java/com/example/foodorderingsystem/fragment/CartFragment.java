package com.example.foodorderingsystem.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.foodorderingsystem.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {


    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_cart_list, container, false);
    }
}