package com.example.apimysql.DAO;


import com.example.apimysql.Interface.AccountInterface;
import com.example.apimysql.Interface.OrderInterface;
import com.example.apimysql.Model.Account;
import com.example.apimysql.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderDAO implements OrderInterface {
    @Autowired
    JdbcTemplate template;


    @Override
    public int addOrder(Order order) {
        String sql = "insert into `order` (aID,rID,oAmountTotal,oDateCreate,oNote,oCode,oStatus)values(?,?,?,?,?,?,0)";
        return template.update(sql, order.getaID(), order.getrID(),order.getoAmountTotal(), order.getoDateCreate(), order.getoNote(), order.getoCode());
    }

    @Override
    public List<Map<String, Object>> getOrders() {
        List<Map<String, Object>> query = template.queryForList("Select * FROM `order` ORDER BY `oID` DESC");
        return query;
    }
}
