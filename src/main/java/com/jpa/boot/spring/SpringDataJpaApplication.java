package com.jpa.boot.spring;

import com.jpa.boot.spring.entities.Product;
import com.jpa.boot.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Application Starting");
//
//		Product product = new Product();
//		product.setTitle("SAMSUNG-TV");
//		product.setDescription("ALL COMPANIES TV");
//		product.setPrice(1000);
//		product.setLive(true);
//
//		Product p = productService.create(product);
//		System.out.println("Product" + p);
//		System.out.println(productService.byId(1));

	}
}
