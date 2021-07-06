package com.example.apimysql.Service;

import com.example.apimysql.DAO.ProductDAO;
import com.example.apimysql.Interface.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService implements ProductInterface {
    @Autowired
    ProductDAO productDAO;

    @Override
    public List<Map<String, Object>> listProducts() {
        return productDAO.listProducts();
    }

    @Override
    public List<Map<String, Object>> listProductSearch(String nameProduct) {
        return productDAO.listProductSearch(nameProduct);
    }

    @Override
    public List<Map<String, Object>> listProductForRecommended() {
        return productDAO.listProductForRecommended();
    }

    @Override
    public List<Map<String, Object>> listCategory() {
        return productDAO.listCategory();
    }
}
