package com.example.foodorderingsystem.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodorderingsystem.Activity.CheckoutCompleteActivity;
import com.example.foodorderingsystem.Activity.RestaurantActivity;
import com.example.foodorderingsystem.Adapter.MenuResAdapter;
import com.example.foodorderingsystem.Adapter.OrderHistoryAdapter;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.Order;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.Restaurant;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    AppCompatButton btn_selectdate,btn_refesh;
    TextView datetime;
    RecyclerView rcy_orderhistory;
    List<Order> listOrders;
    List<Restaurant> resInfo;
    List<OrderDetail> listOrderDetails;
    ApiInterface apiInterface;
    OrderHistoryAdapter orderHistoryAdapter;


    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history,container,false);
        listOrders = new ArrayList<>();
        listOrderDetails = new ArrayList<>();
        resInfo = new ArrayList<>();

        rcy_orderhistory = v.findViewById(R.id.rcy_orderhistory);
        btn_selectdate = v.findViewById(R.id.btn_selectdate);
        btn_refesh = v.findViewById(R.id.btn_refesh);
        datetime = v.findViewById(R.id.datetime);

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        getAllOrderDetail();
        getRestaurantInfo();

        getLastOrders(df.format(date));

        DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        datetime.setText(df2.format(date));

        btn_selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = year + "-" + month + "-" + dayOfMonth;
                        String dateShow = dayOfMonth + "/" + month + "/" + year;
                        datetime.setText(dateShow);

                        getLastOrders(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        btn_refesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = new Date();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                getAllOrderDetail();
                getRestaurantInfo();

                getLastOrders(df.format(date));

                DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
                datetime.setText(df2.format(date));
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    private void setRecycle(){
        orderHistoryAdapter = new OrderHistoryAdapter(getContext(), listOrders,resInfo,listOrderDetails);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        rcy_orderhistory.setLayoutManager(layoutManager);
        rcy_orderhistory.setAdapter(orderHistoryAdapter);
    }

    public void getLastOrders(String date){
        apiInterface = Api.getClients();
        Call<List<Order>> call = apiInterface.getOrdersDate(date);
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                listOrders = response.body();
                setRecycle();
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
            }
        });
    }

    private void getRestaurantInfo(){
        apiInterface = Api.getClients();

        Call<List<Restaurant>> call = apiInterface.getAllRestaurantInfo();
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                resInfo = response.body();
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAllOrderDetail(){
        apiInterface = Api.getClients();

        Call<List<OrderDetail>> call = apiInterface.getAllOrderDetail();
        call.enqueue(new Callback<List<OrderDetail>>() {
            @Override
            public void onResponse(Call<List<OrderDetail>> call, Response<List<OrderDetail>> response) {
                listOrderDetails = response.body();
            }

            @Override
            public void onFailure(Call<List<OrderDetail>> call, Throwable t) {
                Toast.makeText(getContext(), "Server is not responding.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}