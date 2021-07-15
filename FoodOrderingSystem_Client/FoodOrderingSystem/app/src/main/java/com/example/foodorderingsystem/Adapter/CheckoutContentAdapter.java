package com.example.foodorderingsystem.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.Activity.FoodDetail;
import com.example.foodorderingsystem.Activity.RestaurantActivity;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckoutContentAdapter extends RecyclerView.Adapter<CheckoutContentAdapter.CheckoutContentViewHolder> {

    private Context context;
    private List<Cart> cartList;
    private List<Product>listProducts;
    SessionManagement sessionManagement;

    String productName;

    public CheckoutContentAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
        sessionManagement = new SessionManagement(context);
    }

    @NonNull
    @NotNull
    @Override
    public CheckoutContentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_checkoutcontents,parent,false);
        return new CheckoutContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CheckoutContentViewHolder holder, int position) {
        holder.tv_foodrow.setText(cartList.get(position).getpName().split(" ",2)[0]);
        holder.tv_amountrow.setText(String.valueOf(cartList.get(position).getCartQuantity()));
        holder.tv_pricerow.setText(String.valueOf(cartList.get(position).getpPrice()));
        holder.tv_totalrow.setText(String.valueOf(cartList.get(position).getCartQuantity() * cartList.get(position).getpPrice()));
    }

    @Override
    public int getItemCount() {
        if(cartList != null){
            return cartList.size();
        }
        return 0;
    }



    public class CheckoutContentViewHolder extends RecyclerView.ViewHolder {
        TextView tv_foodrow,tv_amountrow, tv_pricerow, tv_totalrow;
        public CheckoutContentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tv_foodrow = itemView.findViewById(R.id.tv_foodrow);
            tv_amountrow = itemView.findViewById(R.id.tv_amountrow);
            tv_pricerow = itemView.findViewById(R.id.tv_pricerow);
            tv_totalrow = itemView.findViewById(R.id.tv_totalrow);

        }
    }
}
