package com.ak.ecommercebackend.service;

import com.ak.ecommercebackend.model.Category;
import com.ak.ecommercebackend.repo.CategoryRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    public Category updateCategory(Category category) {
        if (categoryRepo.existsById(category.getId())) {
            return categoryRepo.save(category);
        }
        throw new EntityNotFoundException("Category Not Found");
    }

    public void deleteCategory(Long id) {
        if (categoryRepo.existsById(id)) {
            categoryRepo.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("Category Not Found");
    }

    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

}
