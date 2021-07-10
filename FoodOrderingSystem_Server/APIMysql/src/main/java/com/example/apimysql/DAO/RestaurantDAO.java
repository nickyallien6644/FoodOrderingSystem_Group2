package com.example.apimysql.DAO;

import com.example.apimysql.Interface.RestaurantInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class RestaurantDAO implements RestaurantInterface
{
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Map<String, Object>> getAllRestaurantInfo() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `restaurant`");
        return query;
    }

    @Override
    public List<Map<String, Object>> restaurantInfo(String rID) {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `restaurant` WHERE rID = "+rID+"");
        return query;
    }
}
