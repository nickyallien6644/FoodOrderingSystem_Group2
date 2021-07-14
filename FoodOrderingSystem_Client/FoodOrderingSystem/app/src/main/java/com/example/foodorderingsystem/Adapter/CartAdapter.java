package com.example.foodorderingsystem.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    private Context context;
    private List<Cart> cartList;
    int totalPrice;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @NotNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_recycler_items, parent, false);
        return new CartViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull CartViewHolder holder, int position) {
        holder.cartName.setText(cartList.get(position).getpName());
        holder.cartPrice.setText(cartList.get(position).getpPrice() + " Bcoins");
        Glide.with(context).load(cartList.get(position).getiURL()).into(holder.imgCart);
        holder.cartQuantity.setText(String.valueOf(cartList.get(position).getCartQuantity()));

    }

    @Override
    public int getItemCount() {
        if(cartList != null)    {
            return cartList.size();
        }
        return 0;
    }


    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCart;
        TextView cartName, cartPrice, cartQuantity, finalPrice;

        public CartViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imgCart = itemView.findViewById(R.id.img_product);
            cartName = itemView.findViewById(R.id.txt_product_name);
            cartPrice = itemView.findViewById(R.id.txt_product_price);
            cartQuantity = itemView.findViewById(R.id.quantity_product);
        }
    }
}
