package com.example.apimysql.Service;

import com.example.apimysql.DAO.OrderDAO;
import com.example.apimysql.DAO.OrderDetailDAO;
import com.example.apimysql.Interface.OrderDetailInterface;
import com.example.apimysql.Interface.OrderInterface;
import com.example.apimysql.Model.Order;
import com.example.apimysql.Model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements OrderDetailInterface {
    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public int add(OrderDetail order) {
        return orderDetailDAO.add(order);
    }
}
