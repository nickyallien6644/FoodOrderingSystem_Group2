package com.example.foodorderingsystem.Adapter;

import android.accounts.Account;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodorderingsystem.R;

import java.util.List;

public class AccountAdapter extends ArrayAdapter<Account> {
    private Context context;
    private List<Account> accounts;

    public AccountAdapter(@NonNull Context context, int resource, @NonNull List<Account> objects) {
        super(context, resource, objects);
        this.context = context;
        this.accounts = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //create rowview
        View rowView = layoutInflater.inflate(R.layout.activity_main, parent, false);


        return rowView;
    }
}
