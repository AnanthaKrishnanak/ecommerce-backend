package com.ak.ecommercebackend.controller;

import com.ak.ecommercebackend.model.Category;
import com.ak.ecommercebackend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/category/")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categoryList = categoryService.getAllCategory();
        return ResponseEntity.ok().body(categoryList);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody @Valid Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok().body(createdCategory);
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody @Valid Category category) {
        Category updatedCategory = categoryService.updateCategory(category);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @DeleteMapping
    @RequestMapping("{id}/")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().body("Category Deleted");
    }

}
