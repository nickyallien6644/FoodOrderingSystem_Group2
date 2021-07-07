package com.example.apimysql.Controller;

import com.example.apimysql.Model.Account;
import com.example.apimysql.Service.ProductService;
import com.example.apimysql.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/info/{rID}")
    public List<Map<String, Object>> restaurantInfo(@PathVariable("rID") String rID) {
        return restaurantService.restaurantInfo(rID);
    }

}
