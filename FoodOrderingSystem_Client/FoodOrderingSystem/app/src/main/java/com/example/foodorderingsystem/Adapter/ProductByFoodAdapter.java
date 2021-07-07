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

public class ProductByFoodAdapter extends RecyclerView.Adapter<ProductByFoodAdapter.ProductByFoodViewHolder> {
    private Context context;
    private List<Product> productList;

    public ProductByFoodAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @NotNull
    @Override
    public ProductByFoodViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.productbyfood_recycler_items, parent, false);
        return new ProductByFoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductByFoodViewHolder holder, int position) {
        holder.productByFoodName.setText(productList.get(position).getpName());
        holder.productByFoodPrice.setText(String.valueOf(productList.get(position).getpPrice()) + " Bcoins");

        Glide.with(context).load(productList.get(position).getiURL()).into(holder.productByFoodImage);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, FoodDetail.class);
//                intent.putExtra("name", productList.get(position).getpName());
//                intent.putExtra("price", productList.get(position).getpPrice());
//                intent.putExtra("description", productList.get(position).getpDescription());
//                intent.putExtra("image", productList.get(position).getiURL());
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductByFoodViewHolder extends RecyclerView.ViewHolder {
        ImageView productByFoodImage;
        TextView productByFoodName, productByFoodPrice;

        public ProductByFoodViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            productByFoodImage = itemView.findViewById(R.id.productByFood_image);
            productByFoodName = itemView.findViewById(R.id.productByFood_name);
            productByFoodPrice = itemView.findViewById(R.id.productByFood_price);
        }
    }
}
