package com.jpa.boot.spring;

import com.jpa.boot.spring.entities.Category;
import com.jpa.boot.spring.entities.Product;
import com.jpa.boot.spring.repositories.CategoryRepository;
import com.jpa.boot.spring.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Starting the test");
	}

	@Autowired
	private ProductRepository productRepository;

	@Test
	void testProductRepository(){
		System.out.println("Testing Product Repository");
		Product product = new Product();
		product.setTitle("APPLE-TV");
		product.setDescription("ALL COMPANIES TV");
		product.setPrice(11200);
		product.setLive(true);

		productRepository.save(product);
	}




	@Autowired
	private CategoryRepository categoryRepository;
	@Test
	void categoryRepository(){
		Category category = new Category();
		category.setId(2);
		category.setTitle("Trending");
		categoryRepository.save(category);
	}

	@Test
	void updateProductTest(){
		productRepository.findById(1).ifPresentOrElse(product -> {
			Category category = categoryRepository.findById(1).get();
			product.setCategory(category);
			productRepository.save(product);
		}, ()->{
			System.out.println("Product not found");
		});
	}

	@Test
	void joinQueryTest(){
		//category title : we have
		//fetch all products

		List<Product> trending = productRepository.getProductByCategoryTitle("trending");
		trending.forEach(System.out::println);
		System.out.println(trending);


	}

}
