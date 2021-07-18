package com.example.foodorderingsystem.Adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.foodorderingsystem.Activity.OrderHistoryDetailActivity;
import com.example.foodorderingsystem.Model.Order;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.Restaurant;
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryViewHolder> {
    Context context;
    List<Order> listOrders;
    List<Restaurant> resInfo;
    List<OrderDetail> listOrderDetails;
    List<OrderDetail> listCount;

    String rName;

    public OrderHistoryAdapter(Context context, List<Order> listOrders, List<Restaurant> resInfo, List<OrderDetail> listOrderDetails) {
        this.context = context;
        this.listOrders = listOrders;
        this.resInfo =  resInfo;
        this.listOrderDetails = listOrderDetails;
        listCount = new ArrayList<>();

    }
    @NonNull
    @NotNull
    @Override
    public OrderHistoryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_orderhistory, parent, false);
        return new OrderHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderHistoryViewHolder holder, int position) {
        listCount.clear();
        for(OrderDetail orderDetail : listOrderDetails){
            if(orderDetail.getoID() == listOrders.get(position).getoID()){
                listCount.add(orderDetail);
            }
        }
        holder.tv_amountitem.setText(String.valueOf(listCount.size()) + " items");

        for(Restaurant restaurant : resInfo){
            if(restaurant.getrID() == listOrders.get(position).getrID()){
                rName = restaurant.getrName();
                holder.tv_namestore.setText(rName);
                Glide.with(context).load(restaurant.getrImage()).into(holder.iv_store);
            }
        }

        holder.tv_price.setText(String.valueOf(listOrders.get(position).getoAmountTotal()) + " BCOINS");
        holder.tv_Date.setText(String.valueOf(listOrders.get(position).getoDateCreate()));
        int status = listOrders.get(position).getoStatus();
        if(status >= 1){
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.Xanh));
        }else holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.Cam));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(),OrderHistoryDetailActivity.class);
                intent.putExtra("oID",listOrders.get(position).getoID());
                intent.putExtra("rName", rName);
                intent.putExtra("oCode",listOrders.get(position).getoCode());
                intent.putExtra("oDateCreate", listOrders.get(position).getoDateCreate());
                intent.putExtra("oStatus", listOrders.get(position).getoStatus());
                intent.putExtra("oTotal",listOrders.get(position).getoAmountTotal());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(listOrders != null) return listOrders.size();
        return 0;
    }

    public static class OrderHistoryViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_store;
        TextView tv_namestore, tv_amountitem,tv_price,tv_Date;
        CardView cardView;
        public OrderHistoryViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            iv_store = itemView.findViewById(R.id.iv_store);
            tv_namestore = itemView.findViewById(R.id.txt_nametore);
            tv_amountitem = itemView.findViewById(R.id.tv_amountitem);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_Date = itemView.findViewById(R.id.txt_content);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
