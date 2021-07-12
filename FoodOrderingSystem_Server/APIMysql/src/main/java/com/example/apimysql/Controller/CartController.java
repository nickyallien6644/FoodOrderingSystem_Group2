package com.example.apimysql.Controller;

import com.example.apimysql.Model.Account;
import com.example.apimysql.Model.Cart;
import com.example.apimysql.Service.AccountService;
import com.example.apimysql.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService service;

    @PostMapping("/addCart")
    public String add(@RequestBody Cart cart) {
        int id = service.add(cart);
        if(id == 0) {
            return "Faile Add Cart";
        }
        return "Add cart is success";
    }

}
