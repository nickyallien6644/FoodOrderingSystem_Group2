package com.example.apimysql.Interface;

import com.example.apimysql.Model.Account;
import com.example.apimysql.Model.Product;

import java.util.List;
import java.util.Map;

public interface AccountInterface {
    public List<Map<String, Object>> listAccounts();

    public List<Map<String, Object>>listAccounts(int aID);

    public int add(Account account);

    public int updateConis(Account account);
}
