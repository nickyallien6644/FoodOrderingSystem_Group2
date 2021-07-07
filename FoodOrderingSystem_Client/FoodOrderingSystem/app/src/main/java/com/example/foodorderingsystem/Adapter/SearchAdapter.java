package com.example.foodorderingsystem.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.Activity.FoodDetail;
import com.example.foodorderingsystem.Activity.RestaurantActivity;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.R;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    Context context;
    List<Product> products;
    List<Product> searchProduct;
    public SearchAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_search_layout, parent, false);
        return new SearchViewHolder(v);
    }

    @SuppressLint("ListRecycleSearch")
    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        searchProduct = new ArrayList<>();
        holder.txtNameProduct.setText(products.get(position).getpName());
        holder.txtPrice.setText(String.valueOf(products.get(position).getpPrice())+" Bcoin");
        Glide.with(context).load(products.get(position).getiURL()).into(holder.imgSearch);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RestaurantActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                int temp = products.get(position).getrID();
                intent.putExtra("rID", products.get(position).getrID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSearch;
        TextView txtNameProduct, txtPrice;
        Button btnAddCart;
        SearchView searchView;
        public SearchViewHolder(View itemView) {
            super(itemView);
            searchView=itemView.findViewById(R.id.resultSearch);
            imgSearch = itemView.findViewById(R.id.search_image);
            txtNameProduct = itemView.findViewById(R.id.search_name);
            txtPrice = itemView.findViewById(R.id.search_price);
            btnAddCart = itemView.findViewById(R.id.search_addCart);
        }
    }
}
