package com.example.apimysql.Controller;

import com.example.apimysql.Model.Order;
import com.example.apimysql.Model.OrderDetail;
import com.example.apimysql.Service.OrderDetailService;
import com.example.apimysql.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/list/{oID}")
    public List<Map<String, Object>> getOrdersDetail (@PathVariable("oID") String oID) {
        return orderDetailService.getOrdersDetail(oID);
    }

    @GetMapping("/list")
    public List<Map<String, Object>> getAllOrdersDetail() {
        return orderDetailService.getAllOrdersDetail();
    }
}
