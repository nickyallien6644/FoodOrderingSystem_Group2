package com.example.foodorderingsystem.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private Context context;
    private List<Product> menuList;

    public MenuAdapter(Context context, List<Product> menuList) {
        this.context = context;
        this.menuList = menuList;
    }
    @NonNull
    @NotNull
    @Override
    public MenuAdapter.MenuViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_menus, parent, false);
        return new MenuAdapter.MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MenuAdapter.MenuViewHolder holder, int position) {
        holder.menuName.setText(menuList.get(position).getpName());
        holder.menubcoin.setText(String.valueOf(menuList.get(position).getpPrice()) + " Bcoins");
        Glide.with(context).load(menuList.get(position).getiURL()).into(holder.menuImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDetail.class);
                intent.putExtra("name", menuList.get(position).getpName());
                intent.putExtra("price", menuList.get(position).getpPrice());
                intent.putExtra("description", menuList.get(position).getpDescription());
                intent.putExtra("image", menuList.get(position).getiURL());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(menuList != null) return menuList.size();
        return 0;
    }
    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        ImageView menuImage;
        TextView menuName, menubcoin;
        Button menuAddCart;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            menuImage = itemView.findViewById(R.id.iv_food);
            menuName = itemView.findViewById(R.id.tv_foodName);
            menubcoin = itemView.findViewById(R.id.tv_coin);
            menuAddCart = itemView.findViewById(R.id.btnAddCart);
        }
    }
}