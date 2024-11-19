package com.jpa.boot.spring.controller;

import com.jpa.boot.spring.entities.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PageController {

    @RequestMapping("/home")
    public List<String> home(){
        List<String> names = List.of("ravi", "ankit", "sanjay");
        return names;
    }

    @GetMapping("/courses")
    public Map<String, String> getFees(){
        Map<String, String> courses = new HashMap<>();
        courses.put("Spring Boot", "10k");
        courses.put("Spring MVC", "11k");
        courses.put("Spring JPA", "12k");
        courses.put("Spring Core", "13k");

        return courses;
    }

    @RequestMapping("/category")
    public Category category(){
        Category category = new Category();
        category.setId(1000);
        category.setTitle("Trending work");
        return category;
    }

}
