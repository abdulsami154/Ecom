package com.example.ecom.repository;

import com.example.ecom.domain.Product;
import com.example.ecom.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Modifying
    @Query(value = "select * from product where category_id=:id",nativeQuery = true)
    List<Product> findProductByCategoryId(@Param("id")Long id);

    @Modifying
    @Query(value = "select * from product where name LIKE %:value%",nativeQuery = true)
    List<Product> findProductSearchByName(@Param("value")String value);

    @Modifying
    @Query(value = "select * from product order by price asc limit 6",nativeQuery = true)
    List<Product> getAllProductsForHome();

    @Modifying
    @Query(value = "select * from product order by price asc limit 6",nativeQuery = true)
    List<Product> getAllProductsAscOrder();

    @Modifying
    @Query(value = "select * from product order by price desc limit 6",nativeQuery = true)
    List<Product> getAllProductsDescOrder();
}
