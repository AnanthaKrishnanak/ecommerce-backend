package com.ak.ecommercebackend.service;

import com.ak.ecommercebackend.dto.ProductDTO;
import com.ak.ecommercebackend.model.Category;
import com.ak.ecommercebackend.model.Product;
import com.ak.ecommercebackend.repo.CategoryRepo;
import com.ak.ecommercebackend.repo.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;


    public ProductService(ProductRepo productRepo,  CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;

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


    public Product createProduct(ProductDTO dto) {
        return getProduct(dto);
    }

    public Product updateProduct(ProductDTO dto) {
        if (!productRepo.existsById(dto.getProductId())) {
            throw new EntityNotFoundException("Product not found");
        }

        return getProduct(dto);
    }

    private Product getProduct(ProductDTO dto) {
        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setProductImageUrl(dto.getProductImageUrl());
        product.setProductPrice(dto.getProductPrice());
        product.setProductStock(dto.getProductStock());
        product.setProductDescription(dto.getProductDescription());
        product.setInStock(dto.getInStock());
        product.setBrand(dto.getBrand());
        product.setRating(dto.getRating());
        product.setReviewCount(dto.getReviewCount());
        product.setProductCategory(category);
        return productRepo.save(product);
    }

    public void deleteProduct(int productId) {
        if (!productRepo.existsById(productId)) {
            throw new EntityNotFoundException("Product not found");
        }
        productRepo.deleteById(productId);
    }

}
