package com.example.apimysql.DAO;

import com.example.apimysql.Interface.OrderDetailInterface;
import com.example.apimysql.Interface.OrderInterface;
import com.example.apimysql.Model.Order;
import com.example.apimysql.Model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderDetailDAO implements OrderDetailInterface {
    @Autowired
    JdbcTemplate template;

    @Override
    public int add(OrderDetail orderDetail) {
        String sql = "insert into `orderdetail` (oID,pID,oQuantity,oPrice,oSubTotal)values(?,?,?,?,?)";
        return template.update(sql, orderDetail.getoID(), orderDetail.getpID(),orderDetail.getoQuantity(), orderDetail.getoPrice(), orderDetail.getoSubTotal());
    }
}
