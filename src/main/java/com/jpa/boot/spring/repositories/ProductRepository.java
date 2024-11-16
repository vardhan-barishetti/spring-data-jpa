package com.jpa.boot.spring.repositories;

import com.jpa.boot.spring.entities.Product;
import com.jpa.boot.spring.entities.ProductWithCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //protocol
    List<Product> findByPrice(double price);

    List<Product> findByTitleAndPrice(String title, double price);

    int countByPrice(double price);

    boolean existsByTitle(String title);

    @Query(nativeQuery = true, value ="select * from product p")
    List<Product> getMyCustomQueryProducts();

    @Query(nativeQuery = true, value = "select * from jpa_products")
    List<Product> getMyCustomNativeQueryProducts();

    //custom method for like query
    //select * from product where title like '%in%';

    List<Product> findByTitleContaining(String keyword);

    List<Product> findByTitleContainsIgnoreCase(String keyword);

    //"%max%"
    List<Product> findByTitleLike(String keywordWithWild);

    List<Product> findByTitleStartsWith(String prefixTitle);

    List<Product> findByTitleNotContaining(String keyword);

    //method to join query and fetch the result
    @Query(name="select p from Product p join p.category where p.category.title=:catTitle")
    List<Product> getProductByCategoryTitle(@Param("catTitle") String title);

//    @Query("")
//    List<ProductWithCategory> getProductWithCategory();

}
