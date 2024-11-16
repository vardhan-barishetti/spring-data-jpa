package com.jpa.boot.spring.services;

import com.jpa.boot.spring.entities.Product;
import com.jpa.boot.spring.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import com.jpa.boot.spring.repositories.CategoryRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        System.out.println(productRepository);
        System.out.println(productRepository.getClass().getName());
    }


    public Product create(Product product){
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public List<Product> all(){
        List<Product> all = productRepository.findAll();
        return all;
    }

    public Product byId(int productId){
        return productRepository.findById(productId).get();
    }

    public void delete(int productId){
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
    }

    public List<Product> getProductByPrice(double price){
        List<Product> byPrice = productRepository.findByPrice(price);
        return byPrice;
    }
}
