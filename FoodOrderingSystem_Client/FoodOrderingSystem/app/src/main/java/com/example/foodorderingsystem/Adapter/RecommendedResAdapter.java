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

import java.util.List;

public class RecommendedResAdapter extends RecyclerView.Adapter<RecommendedResAdapter.RecommendedResViewHolder> {
    private Context context;
    private List<Product> recommendedList;

    public RecommendedResAdapter(Context context, List<Product> recommendedList) {
        this.context = context;
        this.recommendedList = recommendedList;
    }

    @NonNull
    @Override
    public RecommendedResViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommended_recycler_items, parent, false);
        return new RecommendedResViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedResAdapter.RecommendedResViewHolder holder, int position) {
            holder.recommendedName.setText(recommendedList.get(position).getpName());
            holder.recommendedPrice.setText(String.valueOf(recommendedList.get(position).getpPrice()) + " Bcoins");
        Glide.with(context).load(recommendedList.get(position).getiURL()).into(holder.recommendedImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FoodDetail.class);
                intent.putExtra("pID", recommendedList.get(position).getpID());
                intent.putExtra("rID", recommendedList.get(position).getrID());
                intent.putExtra("name", recommendedList.get(position).getpName());
                intent.putExtra("price", recommendedList.get(position).getpPrice());
                intent.putExtra("description", recommendedList.get(position).getpDescription());
                intent.putExtra("iID", recommendedList.get(position).getiID());
                intent.putExtra("image", recommendedList.get(position).getiURL());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recommendedList.size();
    }

    public static class RecommendedResViewHolder extends RecyclerView.ViewHolder {
        ImageView recommendedImage;
        TextView recommendedName, recommendedPrice;

        public RecommendedResViewHolder(@NonNull View itemView) {
            super(itemView);
            recommendedImage = itemView.findViewById(R.id.recommended_image);
            recommendedName = itemView.findViewById(R.id.recommended_name);
            recommendedPrice = itemView.findViewById(R.id.recommended_price);
        }
    }
}
