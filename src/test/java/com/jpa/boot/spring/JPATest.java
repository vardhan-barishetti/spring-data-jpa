package com.jpa.boot.spring;

import com.jpa.boot.spring.entities.Category;
import com.jpa.boot.spring.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JPATest {

    @Autowired
    private CategoryService categoryService;
    @Test
    public void criteriaTest(){
        List<Category> categories = categoryService.getAllCategories();
        categories.forEach(item-> System.out.println(item.getTitle()));
    }
}
