package com.example.ecom.repository;

import com.example.ecom.domain.CartProduct;
import com.example.ecom.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct,Long> {
    @Modifying
    @Query(value = "select * from cart_product where cart_id=:id",nativeQuery = true)
    List<CartProduct> findAllCartByid(@Param("id")Long id);

//    @Modifying
//    @Query(value = "select product_id from cart_product where product_id=:id",nativeQuery = true)
//    public Optional<Product> findProductFromCartProductId(@Param("id") Long id);


}
