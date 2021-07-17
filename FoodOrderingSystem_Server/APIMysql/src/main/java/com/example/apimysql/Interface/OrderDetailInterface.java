package com.example.apimysql.Interface;

import com.example.apimysql.Model.Order;
import com.example.apimysql.Model.OrderDetail;

import java.util.List;
import java.util.Map;

public interface OrderDetailInterface {
    public int add(OrderDetail orderDetail);
    public List<Map<String, Object>> getOrdersDetail(String oID);
    public List<Map<String, Object>> getAllOrdersDetail();
}
