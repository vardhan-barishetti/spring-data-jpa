package com.jpa.boot.spring.services;

import com.jpa.boot.spring.entities.Category;
import com.jpa.boot.spring.repositories.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {



    private EntityManager entityManager;

    private CategoryRepository repository;

    public CategoryService(EntityManager entityManager, CategoryRepository repository) {
        this.entityManager = entityManager;
        this.repository = repository;
    }

    public List<Category> getAll(){
        return repository.findAll();
    }
    public List<Category> getAllCategories(){

        //use criteria api to get all category data
        //getting criteria builder

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //getting criteria query
        CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);

        //root entity
        Root<Category> root = criteriaQuery.from(Category.class);

        criteriaQuery.select(root);

        //build and execute query
        List<Category> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        return resultList;
    }
}
