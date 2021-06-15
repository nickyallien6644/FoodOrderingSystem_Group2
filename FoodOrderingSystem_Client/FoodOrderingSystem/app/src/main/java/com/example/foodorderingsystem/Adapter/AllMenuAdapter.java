package com.example.foodorderingsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.Model.Image;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.R;

import java.util.List;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.AllMenuViewHolder> {

    private Context context;
    private List<Product> allMenuList;

    public AllMenuAdapter(Context context, List<Product> allMenuList) {
        this.context = context;
        this.allMenuList = allMenuList;
    }

    @NonNull
    @Override
    public AllMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false);
        return new AllMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllMenuAdapter.AllMenuViewHolder holder, int position) {
            holder.allMenuName.setText(allMenuList.get(position).getpName());
            holder.allMenuPrice.setText(String.valueOf(allMenuList.get(position).getpPrice()) + " VND");

        Glide.with(context).load(allMenuList.get(position).getiURL()).into(holder.allMenuImage);
    }

    @Override
    public int getItemCount() {
        return allMenuList.size();
    }

    public static class AllMenuViewHolder extends RecyclerView.ViewHolder {
        ImageView allMenuImage;
        TextView allMenuName, allMenuPrice;

        public AllMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            allMenuImage = itemView.findViewById(R.id.all_menu_image);
            allMenuName = itemView.findViewById(R.id.all_menu_name);
            allMenuPrice = itemView.findViewById(R.id.all_menu_price);
        }
    }
}
