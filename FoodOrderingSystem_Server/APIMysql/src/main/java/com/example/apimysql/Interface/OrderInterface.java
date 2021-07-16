package com.example.apimysql.Interface;

import com.example.apimysql.Model.Account;
import com.example.apimysql.Model.Order;

import java.util.List;
import java.util.Map;

public interface OrderInterface {
    public int addOrder(Order order);
    public List<Map<String, Object>> getOrderID();
}
