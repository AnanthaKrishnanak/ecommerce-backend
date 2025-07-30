package com.ak.ecommercebackend.service;

import com.ak.ecommercebackend.model.Product;
import com.ak.ecommercebackend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  private ProductRepo productRepo;

  @Autowired
  public void setProductRepo(ProductRepo productRepo) {
    this.productRepo = productRepo;
  }

  public List<Product> getAllProducts() {
   return  productRepo.findAll();
  }
}
