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
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductByCakeAdapter extends RecyclerView.Adapter<ProductByCakeAdapter.ProductByCakeViewHolder> {
    private Context context;
    private List<Product> productList;
    private List<Cart> cartList;
    private SessionManagement sessionManagement;

    public ProductByCakeAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        this.cartList = new ArrayList<>();
        sessionManagement = new SessionManagement(context);
    }

    @NonNull
    @NotNull
    @Override
    public ProductByCakeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.productbycategory_recycler_items, parent, false);
        return new ProductByCakeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductByCakeViewHolder holder, int position) {
        holder.productByCategoryName.setText(productList.get(position).getpName());
        holder.productByCategoryPrice.setText(String.valueOf(productList.get(position).getpPrice()) + " Bcoins");

        Glide.with(context).load(productList.get(position).getiURL()).into(holder.productByCategoryImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDetail.class);
                intent.putExtra("pID", productList.get(position).getpID());
                intent.putExtra("rID", productList.get(position).getrID());
                intent.putExtra("name", productList.get(position).getpName());
                intent.putExtra("price", productList.get(position).getpPrice());
                intent.putExtra("description", productList.get(position).getpDescription());
                intent.putExtra("iID", productList.get(position).getiID());
                intent.putExtra("image", productList.get(position).getiURL());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        holder.addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartList = sessionManagement.getDataFromSharedPreferences();
                if(cartList == null){
                    sessionManagement.CheckCart(new Cart(1, 1 , productList.get(position).getpID() ,productList.get(position).getpName(), productList.get(position).getpPrice(), productList.get(position).getiID(), productList.get(position).getiURL(), sessionManagement.getSession(),productList.get(position).getrID()));
                    Toast.makeText(context, "Add to cart successful!", Toast.LENGTH_SHORT).show();
                }else{
                        if(cartList.get(0).getrID() == productList.get(position).getrID()){
                            sessionManagement.CheckCart(new Cart(1, 1 , productList.get(position).getpID() ,productList.get(position).getpName(), productList.get(position).getpPrice(), productList.get(position).getiID(), productList.get(position).getiURL(), sessionManagement.getSession(),productList.get(position).getrID()));
                            Toast.makeText(context, "Add to cart successful!", Toast.LENGTH_SHORT).show();
                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());

                            builder.setMessage("Your product in different restaurant. Do you want to remove your cart and add new product ?")
                                    .setPositiveButton("Add to cart", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            sessionManagement.removeCart();
                                            sessionManagement.CheckCart(new Cart(1, 1 , productList.get(position).getpID() ,productList.get(position).getpName(), productList.get(position).getpPrice(), productList.get(position).getiID(), productList.get(position).getiURL(), sessionManagement.getSession(),productList.get(position).getrID()));
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
        return productList.size();
    }

    public static class ProductByCakeViewHolder extends RecyclerView.ViewHolder{
        ImageView productByCategoryImage;
        TextView productByCategoryName, productByCategoryPrice;
        Button addOne;

        public ProductByCakeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            addOne = itemView.findViewById(R.id.btnAddOneForCategory);
            productByCategoryImage = itemView.findViewById(R.id.productByCategory_image);
            productByCategoryName = itemView.findViewById(R.id.productByCategory_name);
            productByCategoryPrice = itemView.findViewById(R.id.productByCategory_price);
        }
    }
}
