package com.example.foodorderingsystem.Utils;

import com.example.foodorderingsystem.Model.Account;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AccountInterface {
    @GET("list")
    Call<List<Account>> getAccounts();
}
