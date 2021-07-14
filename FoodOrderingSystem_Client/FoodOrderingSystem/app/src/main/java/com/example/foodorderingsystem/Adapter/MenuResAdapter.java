package com.example.foodorderingsystem.Adapter;

import android.content.Context;
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
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MenuResAdapter extends RecyclerView.Adapter<MenuResAdapter.MenuResViewHolder> {
    private Context context;
    private List<Product> menuList;
    SessionManagement sessionManagement;

    public MenuResAdapter(Context context, List<Product> menuList) {
        this.context = context;
        this.menuList = menuList;
        sessionManagement = new SessionManagement(context);
    }
    @NonNull
    @NotNull
    @Override
    public MenuResAdapter.MenuResViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_menus, parent, false);
        return new MenuResAdapter.MenuResViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MenuResAdapter.MenuResViewHolder holder, int position) {
        holder.menuName.setText(menuList.get(position).getpName());
        holder.menubcoin.setText(String.valueOf(menuList.get(position).getpPrice()) + " Bcoins");
        Glide.with(context).load(menuList.get(position).getiURL()).into(holder.menuImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDetail.class);
                intent.putExtra("pID", menuList.get(position).getpID());
                intent.putExtra("name", menuList.get(position).getpName());
                intent.putExtra("price", menuList.get(position).getpPrice());
                intent.putExtra("description", menuList.get(position).getpDescription());
                intent.putExtra("iID", menuList.get(position).getiID());
                intent.putExtra("image", menuList.get(position).getiURL());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.menuAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.CheckCart(new Cart(1, 1 , menuList.get(position).getpID() ,menuList.get(position).getpName(), menuList.get(position).getpPrice(), menuList.get(position).getiID(), menuList.get(position).getiURL(), sessionManagement.getSession() ));
                Toast.makeText(context, "Add to cart successfully!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(menuList != null) return menuList.size();
        return 0;
    }
    public static class MenuResViewHolder extends RecyclerView.ViewHolder {
        ImageView menuImage;
        TextView menuName, menubcoin;
        Button menuAddCart;

        public MenuResViewHolder(@NonNull View itemView) {
            super(itemView);
            menuImage = itemView.findViewById(R.id.iv_food);
            menuName = itemView.findViewById(R.id.tv_foodName);
            menubcoin = itemView.findViewById(R.id.tv_coin);
            menuAddCart = itemView.findViewById(R.id.btnAddCart);
        }
    }
}
