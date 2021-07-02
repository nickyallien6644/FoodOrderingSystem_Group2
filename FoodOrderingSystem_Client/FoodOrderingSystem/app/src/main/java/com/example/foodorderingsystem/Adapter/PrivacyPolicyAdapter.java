package com.example.foodorderingsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingsystem.Model.PrivacyPolicy;
import com.example.foodorderingsystem.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PrivacyPolicyAdapter extends RecyclerView.Adapter<PrivacyPolicyAdapter.PrivacyPolicyViewHolder> {

    private Context context;
    private List<PrivacyPolicy> privacyPolicyList;

    public PrivacyPolicyAdapter(Context context, List<PrivacyPolicy> privacyPolicyList) {
        this.context = context;
        this.privacyPolicyList = privacyPolicyList;
    }

    @NonNull
    @NotNull
    @Override
    public PrivacyPolicyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.privacy_recycler_item, parent, false);
        return new PrivacyPolicyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PrivacyPolicyViewHolder holder, int position) {
        holder.privacyPolicyTitle.setText(privacyPolicyList.get(position).getPrivacyTitle());
        holder.privacyPolicyContent.setText(privacyPolicyList.get(position).getPrivacyContent());
    }

    @Override
    public int getItemCount() {
        return privacyPolicyList.size();
    }

    public static class PrivacyPolicyViewHolder extends RecyclerView.ViewHolder {
         TextView privacyPolicyTitle, privacyPolicyContent;

        public PrivacyPolicyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            privacyPolicyTitle = itemView.findViewById(R.id.privacy_title);
            privacyPolicyContent = itemView.findViewById(R.id.privacy_content);
        }
    }
}
