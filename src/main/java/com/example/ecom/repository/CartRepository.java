package com.example.ecom.repository;

import com.example.ecom.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    @Modifying
    @Query(value = "delete from cart where user_id=:id",nativeQuery = true)
    public void deleteByUserId(@Param("id")Long id);

}
