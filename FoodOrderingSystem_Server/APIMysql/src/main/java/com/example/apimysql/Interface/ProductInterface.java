package com.example.apimysql.Interface;

import com.example.apimysql.Model.Account;

import java.util.List;
import java.util.Map;

public interface ProductInterface {
    public List<Map<String, Object>> listProducts();
    public List<Map<String, Object>> listProductSearch(String nameProduct);
    public List<Map<String, Object>> listProductForRecommended();


}
