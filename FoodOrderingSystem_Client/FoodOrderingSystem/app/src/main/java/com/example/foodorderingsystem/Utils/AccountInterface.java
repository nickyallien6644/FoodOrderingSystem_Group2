package com.example.foodorderingsystem.Utils;

import android.accounts.Account;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AccountInterface {
    @GET("list")
    Call<List<Account>> getAccounts();
}
