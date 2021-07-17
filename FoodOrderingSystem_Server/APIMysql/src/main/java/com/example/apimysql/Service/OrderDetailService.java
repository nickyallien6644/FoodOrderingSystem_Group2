package com.example.apimysql.Service;

import com.example.apimysql.DAO.OrderDAO;
import com.example.apimysql.DAO.OrderDetailDAO;
import com.example.apimysql.Interface.OrderDetailInterface;
import com.example.apimysql.Interface.OrderInterface;
import com.example.apimysql.Model.Order;
import com.example.apimysql.Model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderDetailService implements OrderDetailInterface {
    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public int add(OrderDetail order) {
        return orderDetailDAO.add(order);
    }

    @Override
    public List<Map<String, Object>> getOrdersDetail(String oID) {
        return orderDetailDAO.getOrdersDetail(oID);
    }

    @Override
    public List<Map<String, Object>> getAllOrdersDetail() {
        return orderDetailDAO.getAllOrdersDetail();
    }


}
