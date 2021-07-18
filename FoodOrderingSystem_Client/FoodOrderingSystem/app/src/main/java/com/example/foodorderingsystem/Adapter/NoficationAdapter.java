package com.example.foodorderingsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderingsystem.Model.Notification;
import com.example.foodorderingsystem.Model.Restaurant;
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NoficationAdapter extends RecyclerView.Adapter<NoficationAdapter.NoficationViewHolder> {


    private Context context;
    private List<Notification>listNotification;
    private List<Restaurant>listRestaurant;
    private String rName;
    public NoficationAdapter(Context context, List<Restaurant>listRestaurant,List<Notification> listNotification) {
        this.context = context;
        this.listNotification = listNotification;
        this.listRestaurant = listRestaurant;
    }

    @NonNull
    @NotNull
    @Override
        public NoficationViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nofication,parent,false);
        return new NoficationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NoficationViewHolder holder, int position) {
        holder.tv_content.setText(String.valueOf(listNotification.get(position).getNoContent()));

        for(Restaurant restaurant : listRestaurant){
            if(restaurant.getrID() == listNotification.get(position).getrID()){
                holder.tv_namestore.setText(restaurant.getrName());
                Glide.with(context).load(restaurant.getrImage()).into(holder.iv_store);
            }
        }



        if(listNotification.get(position).getNoStatus() >= 1){
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.Xanh));
        }else holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.Cam));
    }

    @Override
    public int getItemCount() {
        if(listNotification != null){
            return listNotification.size();
        }
        return 0;
    }


    public static class NoficationViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_store;
        TextView tv_namestore, tv_content;
        CardView cardView;
        public NoficationViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView12);
            iv_store = itemView.findViewById(R.id.imge_store);
            tv_namestore = itemView.findViewById(R.id.txt_nametore);
            tv_content = itemView.findViewById(R.id.txt_content);
        }
    }


}



