package com.jpa.boot.spring.repositories;

import com.jpa.boot.spring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
