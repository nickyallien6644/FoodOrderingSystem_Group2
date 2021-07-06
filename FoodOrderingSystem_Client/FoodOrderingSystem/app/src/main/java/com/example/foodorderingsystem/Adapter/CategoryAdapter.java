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
import com.example.foodorderingsystem.Model.Category;
import com.example.foodorderingsystem.R;


import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.PopularViewHolder> {

    private Context context;
    private List<Category> categoryList;

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
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, FoodDetail.class);
//                intent.putExtra("name", popularList.get(position).getpName());
//                intent.putExtra("price", popularList.get(position).getpPrice());
//                intent.putExtra("description", popularList.get(position).getpDescription());
//                intent.putExtra("image", popularList.get(position).getiURL());
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryName;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_name);
            categoryImage = itemView.findViewById(R.id.category_image);
        }
    }
}
