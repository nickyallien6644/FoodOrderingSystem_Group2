package com.example.apimysql.Service;

import com.example.apimysql.DAO.OrderDAO;
import com.example.apimysql.DAO.PrivacyPolicyDAO;
import com.example.apimysql.Interface.AccountInterface;
import com.example.apimysql.Interface.OrderInterface;
import com.example.apimysql.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService implements OrderInterface {
    @Autowired
    OrderDAO orderDAO;


    @Override
    public int addOrder(Order order) {
        return orderDAO.addOrder(order);
    }

    @Override
    public List<Map<String, Object>> getOrders() {
        return orderDAO.getOrders();
    }
}
