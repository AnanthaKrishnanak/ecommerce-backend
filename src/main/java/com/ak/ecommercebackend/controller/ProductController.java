package com.ak.ecommercebackend.controller;

import com.ak.ecommercebackend.dto.ProductDTO;
import com.ak.ecommercebackend.model.Product;
import com.ak.ecommercebackend.repo.CategoryRepo;
import com.ak.ecommercebackend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
@CrossOrigin()
public class ProductController {
    private ProductService service;
    private CategoryRepo categoryRepo;

    public ProductController(ProductService service, CategoryRepo categoryRepo) {
        this.service = service;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("{id}/")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = service.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid  ProductDTO product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(product));
    }

    @PutMapping
    public Product updateProduct(@RequestBody @Valid ProductDTO product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return ResponseEntity.ok().body("Product deleted");
    }
}
