package com.example.foodorderingsystem.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    private Context context;
    private List<Cart> cartList;
    private int quantity;
    private String pName, iURL;
    int pPrice;

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
        Intent  intent = ((Activity)context).getIntent();
        pName = intent.getStringExtra("pName");
        pPrice = intent.getIntExtra("pPrice", 0);
        iURL = intent.getStringExtra("iURL");
        quantity = intent.getIntExtra("cartQuantity", 0);
        holder.cartName.setText(pName);
        holder.cartPrice.setText(pPrice);
        Glide.with(context).load(iURL).into(holder.imgCart);
        holder.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
            }
        });
        holder.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(holder.cartQuantity.getText().toString()) < 0) {
                    Toast.makeText(context, "Can't quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                }
            }
        });

        holder.cartQuantity.setText(quantity);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCart, imgPlus, imgMinus;
        TextView cartName, cartPrice, cartQuantity;

        public CartViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imgCart = itemView.findViewById(R.id.img_product);
            cartName = itemView.findViewById(R.id.txt_product_name);
            cartPrice = itemView.findViewById(R.id.txt_product_price);
            cartQuantity = itemView.findViewById(R.id.quantity_product);
            imgPlus = itemView.findViewById(R.id.img_plus);
            imgMinus = itemView.findViewById(R.id.img_minus);
        }
    }
}
