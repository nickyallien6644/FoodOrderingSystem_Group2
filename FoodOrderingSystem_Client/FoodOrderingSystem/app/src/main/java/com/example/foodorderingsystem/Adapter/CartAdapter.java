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
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
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
    SessionManagement sessionManagement;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
        sessionManagement = new SessionManagement(context);
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
        holder.clickAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.increaseQuantity(cartList.get(position).getpID());
                cartList = sessionManagement.getDataFromSharedPreferences();
                holder.cartQuantity.setText(String.valueOf(cartList.get(position).getCartQuantity()));
                Intent intent = new Intent("clickAdd");
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });
        holder.clickMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sessionManagement.decreaseQuantity(cartList.get(position).getpID());
                cartList = sessionManagement.getDataFromSharedPreferences();
                holder.cartQuantity.setText(String.valueOf(cartList.get(position).getCartQuantity()));
                Intent intent = new Intent("clickMinus");
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });
        holder.cartQuantity.setText(String.valueOf(cartList.get(position).getCartQuantity()));

        holder.deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.deleteProductFromCart(cartList.get(position).getpID());
                cartList = sessionManagement.getDataFromSharedPreferences();
                Intent intent = new Intent("deleteItemCart");
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(cartList != null)    {
            return cartList.size();
        }
        return 0;
    }


    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCart, clickAdd, clickMinus, deleteItem;
        TextView cartName, cartPrice, cartQuantity;

        public CartViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            deleteItem = itemView.findViewById(R.id.img_delete_cart);
            clickAdd = itemView.findViewById(R.id.img_plus);
            clickMinus = itemView.findViewById(R.id.img_minus);
            imgCart = itemView.findViewById(R.id.img_product);
            cartName = itemView.findViewById(R.id.txt_product_name);
            cartPrice = itemView.findViewById(R.id.txt_product_price);
            cartQuantity = itemView.findViewById(R.id.quantity_product);
        }
    }
}
