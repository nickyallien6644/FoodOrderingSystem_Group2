package com.example.foodorderingsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Model.Cart;
import com.example.foodorderingsystem.Model.OrderDetail;
import com.example.foodorderingsystem.Model.Product;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderDetailContentAdapter extends RecyclerView.Adapter<OrderDetailContentAdapter.OrderDetailContentViewHolder>{

    private Context context;
    private List<OrderDetail> listOrderDetails;
    private List<Product>listProducts;


    public OrderDetailContentAdapter(Context context, List<OrderDetail> listOrderDetails, List<Product> listProducts) {
        this.context = context;
        this.listOrderDetails = listOrderDetails;
        this.listProducts = listProducts;
    }

    @NonNull
    @NotNull
    @Override
    public OrderDetailContentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_orderhistorycontent,parent,false);
        return new OrderDetailContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderDetailContentViewHolder holder, int position) {
        for(Product product : listProducts){
            if(product.getpID() == listOrderDetails.get(position).getpID()){
                holder.tv_foodrow.setText(product.getpName().split(" ",2)[0]);
            }
        }
        holder.tv_amountrow.setText(String.valueOf(listOrderDetails.get(position).getoQuantity()));
        holder.tv_pricerow.setText(String.valueOf((int)listOrderDetails.get(position).getoPrice()));
        holder.tv_totalrow.setText(String.valueOf(listOrderDetails.get(position).getoSubTotal()));
    }

    @Override
    public int getItemCount() {
        if(listOrderDetails != null){
            return listOrderDetails.size();
        }
        return 0;
    }



    public class OrderDetailContentViewHolder extends RecyclerView.ViewHolder {
        TextView tv_foodrow,tv_amountrow, tv_pricerow, tv_totalrow;
        public OrderDetailContentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tv_foodrow = itemView.findViewById(R.id.tv_foodrow);
            tv_amountrow = itemView.findViewById(R.id.tv_amountrow);
            tv_pricerow = itemView.findViewById(R.id.tv_pricerow);
            tv_totalrow = itemView.findViewById(R.id.tv_totalrow);

        }
    }
}
