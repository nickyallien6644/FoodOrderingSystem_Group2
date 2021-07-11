package com.example.apimysql.DAO;


import com.example.apimysql.Interface.AccountInterface;
import com.example.apimysql.Interface.CartInterface;
import com.example.apimysql.Model.Account;
import com.example.apimysql.Model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CartDAO implements CartInterface {
    @Autowired
    JdbcTemplate template;

    @Override
    public int add(Cart cart) {
        String sql = "INSERT INTO `cart`(`pID`, `aID`, `cartQuantity`) VALUES (?,?,?)";
        return template.update(sql, cart.getpID(), cart.getaID(), cart.getCartQuantity());
    }
}
