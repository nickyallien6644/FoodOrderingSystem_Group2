package com.example.apimysql.Controller;

import com.example.apimysql.Model.Account;
import com.example.apimysql.Model.Order;
import com.example.apimysql.Service.FrequentlyAskedQuestionService;
import com.example.apimysql.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order) {
        int id=orderService.addOrder(order);
        if(id==0) {
            return "Fail Add Order";
        }
        return "Add Order is success";
    }

    @GetMapping("/list")
    public List<Map<String, Object>> getOrders() {
        return orderService.getOrders();
    }
}
