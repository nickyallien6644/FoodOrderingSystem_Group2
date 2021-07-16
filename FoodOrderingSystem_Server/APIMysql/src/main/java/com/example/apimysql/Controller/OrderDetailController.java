package com.example.apimysql.Controller;

import com.example.apimysql.Model.Order;
import com.example.apimysql.Model.OrderDetail;
import com.example.apimysql.Service.OrderDetailService;
import com.example.apimysql.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/add")
    public String addOrder(@RequestBody OrderDetail orderDetail) {
         int id =  orderDetailService.add(orderDetail);
        if(id==0) {
            return "Fail Add Order";
        }
        return "Add Order is success";
    }
}
