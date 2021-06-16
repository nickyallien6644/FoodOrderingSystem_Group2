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
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.R;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder> {
    private Context context;
    private List<Product> recommendedList;

    public RecommendedAdapter(Context context, List<Product> recommendedList) {
        this.context = context;
        this.recommendedList = recommendedList;
    }

    @NonNull
    @Override
    public RecommendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommended_recycler_items, parent, false);
        return new RecommendedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedAdapter.RecommendedViewHolder holder, int position) {
            holder.recommendedName.setText(recommendedList.get(position).getpName());
            holder.recommendedPrice.setText(String.valueOf(recommendedList.get(position).getpPrice()));
        Glide.with(context).load(recommendedList.get(position).getiURL()).into(holder.recommendedImage);

    }

    @Override
    public int getItemCount() {
        return recommendedList.size();
    }

    public static class RecommendedViewHolder extends RecyclerView.ViewHolder {
        ImageView recommendedImage;
        TextView recommendedName, recommendedPrice;

        public RecommendedViewHolder(@NonNull View itemView) {
            super(itemView);
            recommendedImage = itemView.findViewById(R.id.recommended_image);
            recommendedName = itemView.findViewById(R.id.recommended_name);
            recommendedPrice = itemView.findViewById(R.id.recommended_price);
        }
    }
}
