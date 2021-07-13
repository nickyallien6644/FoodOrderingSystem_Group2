package com.example.apimysql.Service;

import com.example.apimysql.DAO.AccountDAO;
import com.example.apimysql.DAO.CartDAO;
import com.example.apimysql.Interface.AccountInterface;
import com.example.apimysql.Interface.CartInterface;
import com.example.apimysql.Model.Account;
import com.example.apimysql.Model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartService implements CartInterface {
    @Autowired
    CartDAO dao;

    @Override
    public int add(Cart cart) {
        return dao.add(cart);
    }

}
