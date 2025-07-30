package com.ak.ecommercebackend.controller;

import com.ak.ecommercebackend.model.Product;
import com.ak.ecommercebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @RequestMapping("/products/")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
}
