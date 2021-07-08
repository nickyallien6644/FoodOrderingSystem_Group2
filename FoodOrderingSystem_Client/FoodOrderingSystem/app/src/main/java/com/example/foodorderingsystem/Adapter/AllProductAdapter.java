package com.example.foodorderingsystem.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.Activity.FoodDetail;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.AllProductViewHolder> {
    private Context context;
    private List<Product> productList;

    public AllProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @NotNull
    @Override
    public AllProductViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.all_product_recycler_items, parent, false);
        return new AllProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AllProductViewHolder holder, int position) {
        holder.allProductName.setText(productList.get(position).getpName());
        holder.allProductPrice.setText(String.valueOf(productList.get(position).getpPrice()) + " Bcoins");

        Glide.with(context).load(productList.get(position).getiURL()).into(holder.allProductImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDetail.class);
                intent.putExtra("name", productList.get(position).getpName());
                intent.putExtra("price", productList.get(position).getpPrice());
                intent.putExtra("description", productList.get(position).getpDescription());
                intent.putExtra("image", productList.get(position).getiURL());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class AllProductViewHolder extends RecyclerView.ViewHolder{
        ImageView allProductImage;
        TextView allProductName, allProductPrice;

        public AllProductViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            allProductImage = itemView.findViewById(R.id.allProduct_image);
            allProductName = itemView.findViewById(R.id.allProduct_name);
            allProductPrice = itemView.findViewById(R.id.allProduct_price);
        }
    }
}