package com.example.apimysql.Controller;

import com.example.apimysql.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/listProducts")
    public List<Map<String, Object>> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/listProductSearch")
    public List<Map<String, Object>> listProductSearch(String nameProduct){
        return productService.listProductSearch(nameProduct);
    }

    @GetMapping("/listProductForRecommended")
    public List<Map<String, Object>> listProductForRecommended() {
        return productService.listProductForRecommended();
    }
}
