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
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID LIMIT 10");
        return query;
    }

    @Override
    public List<Map<String, Object>> listAllProductForAllCategory() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID");
        return query;
    }
//    SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID WHERE `pName` LIKE 'D%';

    @Override
    public List<Map<String, Object>> listProductSearch(String nameProduct) {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID WHERE `pName` LIKE '"+nameProduct+"%'");
        return query;
    }

    @Override
    public List<Map<String, Object>> listProductSearchSeeAll(String nameProduct, String rID) {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN (select * from `product`WHERE rID = "+rID+") as p on i.pID = p.pID WHERE `pName` LIKE '%"+nameProduct+"%'");
        return query;
    }

    @Override
    public List<Map<String, Object>> listProductForRecommended() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID ORDER BY p.pID DESC LIMIT 8");
        return query;
    }

    @Override
    public List<Map<String, Object>> listAllProductForRecommended() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID ORDER BY p.pID DESC");
        return query;
    }

    @Override
    public List<Map<String, Object>> listCategory() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `category`");
        return query;
    }

    @Override
    public List<Map<String, Object>> listProductByFood() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID WHERE p.cID = 1");
        return query;
    }

    @Override
    public List<Map<String, Object>> listProductByDrink() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID WHERE p.cID = 2");
        return query;
    }

    @Override
    public List<Map<String, Object>> listProductByCake() {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN product as p on i.pID = p.pID WHERE p.cID = 3");
        return query;
    }

    @Override
    public List<Map<String, Object>> listProductsByRID(String rID) {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN (select * from `product`WHERE rID = "+rID+") as p on i.pID = p.pID WHERE 1 LIMIT 6");
        return query;
    }

    @Override
    public List<Map<String, Object>> listProductsByRIDSeeAll(String rID) {
        List<Map<String, Object>> query = template.queryForList("SELECT * FROM `image` as i INNER JOIN (select * from `product`WHERE rID = "+rID+") as p on i.pID = p.pID WHERE 1");
        return query;
    }
}
