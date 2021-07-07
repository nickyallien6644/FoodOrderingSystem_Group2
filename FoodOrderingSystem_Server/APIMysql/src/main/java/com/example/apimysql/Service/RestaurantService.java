package com.example.apimysql.Service;

import com.example.apimysql.DAO.ProductDAO;
import com.example.apimysql.DAO.RestaurantDAO;
import com.example.apimysql.Interface.ProductInterface;
import com.example.apimysql.Interface.RestaurantInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RestaurantService implements RestaurantInterface {
    @Autowired
    RestaurantDAO restaurantDAO;

    @Override
    public List<Map<String, Object>> restaurantInfo(String rID) {
        return restaurantDAO.restaurantInfo(rID);
    }
}
