package com.jpa.boot.spring.services;

import com.jpa.boot.spring.entities.Product;
import com.jpa.boot.spring.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
}
