package com.example.apimysql.Controller;

import com.example.apimysql.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/listCategory")
    public List<Map<String, Object>> listCategory() {
        return productService.listCategory();
    }

    @GetMapping("/listProductByFood")
    public List<Map<String, Object>> listProductByFood() {
        return productService.listProductByFood();
    }

    @GetMapping("/listProductByDrink")
    public List<Map<String, Object>> listProductByDrink() {
        return productService.listProductByDrink();
    }

    @GetMapping("/listProductByCake")
    public List<Map<String, Object>> listProductByCake() {
        return productService.listProductByCake();
    }

    @GetMapping("/listProductByRID/{rID}")
    public List<Map<String, Object>> listProductsByRID(@PathVariable("rID")String rID) {
        return productService.listProductsByRID(rID);
    }

    @GetMapping("/listProductByRIDSeeAll/{rID}")
    public List<Map<String, Object>> listProductsByRIDSeeAll(@PathVariable("rID")String rID) {
        return productService.listProductsByRIDSeeAll(rID);
    }
}
