package com.jpa.boot.spring.controller;

import com.jpa.boot.spring.entities.Category;
import com.jpa.boot.spring.services.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping
    public List<Category> allCategories(){
        return categoryService.getAll();
    }
}
