package com.ak.ecommercebackend.service;

import com.ak.ecommercebackend.model.Product;
import com.ak.ecommercebackend.repo.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public  Product getProductById(int id) {
        if(productRepo.findById(id).isPresent()) {
            return productRepo.findById(id).get();
        }

        throw new EntityNotFoundException("Product not found");
    }


    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Product product) {
        if (!productRepo.existsById(product.getProductId())) {
            throw new EntityNotFoundException("Product not found");
        }
        return productRepo.save(product);
    }

    public void deleteProduct(int productId) {
        if (!productRepo.existsById(productId)) {
            throw new EntityNotFoundException("Product not found");
        }
        productRepo.deleteById(productId);
    }

}
