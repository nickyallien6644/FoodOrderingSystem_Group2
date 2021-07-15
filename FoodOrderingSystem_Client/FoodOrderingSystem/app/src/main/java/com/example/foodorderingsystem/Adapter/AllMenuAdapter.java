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
import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.Image;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;

import java.util.ArrayList;
import java.util.List;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.AllMenuViewHolder> {

    private Context context;
    private List<Product> allMenuList;
    private List<Cart> cartList;
    SessionManagement sessionManagement;

    public AllMenuAdapter(Context context, List<Product> allMenuList) {
        this.context = context;
        this.allMenuList = allMenuList;
        cartList = new ArrayList<>();
        sessionManagement = new SessionManagement(context);
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
            holder.allMenuPrice.setText(String.valueOf(allMenuList.get(position).getpPrice()) + " Bcoins");

        Glide.with(context).load(allMenuList.get(position).getiURL()).into(holder.allMenuImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDetail.class);
                intent.putExtra("pID", allMenuList.get(position).getpID());
                intent.putExtra("rID", allMenuList.get(position).getrID());
                intent.putExtra("name", allMenuList.get(position).getpName());
                intent.putExtra("price", allMenuList.get(position).getpPrice());
                intent.putExtra("description", allMenuList.get(position).getpDescription());
                intent.putExtra("iID", allMenuList.get(position).getiID());
                intent.putExtra("image", allMenuList.get(position).getiURL());
                context.startActivity(intent);
            }
        });
        holder.addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList = sessionManagement.getDataFromSharedPreferences();
                if(cartList == null){
                    sessionManagement.CheckCart(new Cart(1, 1 , allMenuList.get(position).getpID() ,allMenuList.get(position).getpName(), allMenuList.get(position).getpPrice(), allMenuList.get(position).getiID(), allMenuList.get(position).getiURL(), sessionManagement.getSession(),allMenuList.get(position).getrID()));
                    Toast.makeText(context, "Add to cart successful!", Toast.LENGTH_SHORT).show();
                }else{
                        if(cartList.get(0).getrID() == allMenuList.get(position).getrID()){
                            sessionManagement.CheckCart(new Cart(1, 1 , allMenuList.get(position).getpID() ,allMenuList.get(position).getpName(), allMenuList.get(position).getpPrice(), allMenuList.get(position).getiID(), allMenuList.get(position).getiURL(), sessionManagement.getSession(),allMenuList.get(position).getrID()));
                            Toast.makeText(context, "Add to cart successful!", Toast.LENGTH_SHORT).show();
                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());

                            builder.setMessage("Your product in different restaurant. Do you want to remove your cart and add new product ?")
                                    .setPositiveButton("Add to cart", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            sessionManagement.removeCart();
                                            sessionManagement.CheckCart(new Cart(1, 1 , allMenuList.get(position).getpID() ,allMenuList.get(position).getpName(), allMenuList.get(position).getpPrice(), allMenuList.get(position).getiID(), allMenuList.get(position).getiURL(), sessionManagement.getSession(),allMenuList.get(position).getrID()));
                                            Toast.makeText(context, "Add to cart successful!", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                        }
                                    })
                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.dismiss();
                                        }
                                    });
                            builder.create().show();

                        }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return allMenuList.size();
    }

    public static class AllMenuViewHolder extends RecyclerView.ViewHolder {
        ImageView allMenuImage;
        TextView allMenuName, allMenuPrice;
        Button addOne;

        public AllMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            addOne = itemView.findViewById(R.id.btnAddOne);
            allMenuImage = itemView.findViewById(R.id.all_menu_image);
            allMenuName = itemView.findViewById(R.id.all_menu_name);
            allMenuPrice = itemView.findViewById(R.id.all_menu_price);
        }
    }
}
