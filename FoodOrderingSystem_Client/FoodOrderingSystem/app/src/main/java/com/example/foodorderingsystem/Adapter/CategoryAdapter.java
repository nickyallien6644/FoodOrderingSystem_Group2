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
import com.example.foodorderingsystem.Activity.ProductByCategory;
import com.example.foodorderingsystem.Common.Common;
import com.example.foodorderingsystem.Model.Category;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.ItemClickListener;


import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.PopularViewHolder> {

    private Context context;
    private List<Category> categoryList;
    int row_index = -1;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_recycler_items, parent, false);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.PopularViewHolder holder, int position) {
        holder.categoryName.setText(categoryList.get(position).getcName());

        Glide.with(context).load(categoryList.get(position).getcURL()).error(R.drawable.ic_launcher_foreground).into(holder.categoryImage);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Common.currentCategory = categoryList.get(position);
                notifyDataSetChanged();
                Intent intent = new Intent(context, ProductByCategory.class);
                intent.putExtra("position", position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView categoryImage;
        TextView categoryName;

        ItemClickListener itemClickListener;

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_name);
            categoryImage = itemView.findViewById(R.id.category_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());
        }
    }
}
