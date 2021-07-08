package com.example.apimysql.Interface;

import java.util.List;
import java.util.Map;

public interface RestaurantInterface {
    public List<Map<String, Object>> getAllRestaurantInfo();
    public List<Map<String, Object>> restaurantInfo(String rID);
}
