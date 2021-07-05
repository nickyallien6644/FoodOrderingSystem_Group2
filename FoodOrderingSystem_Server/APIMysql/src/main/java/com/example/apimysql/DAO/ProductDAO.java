package com.example.apimysql.DAO;

import com.example.apimysql.Interface.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO implements ProductInterface {
    @Autowired
    JdbcTemplate template;

    @Override
    public List<Map<String, Object>> listProducts() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID");
        return query;
    }
//    SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID WHERE `pName` LIKE 'D%';

    @Override
    public List<Map<String, Object>> listProductSearch(String nameProduct) {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID WHERE `pName` LIKE '"+nameProduct+"%'");
        return query;
    }
}
