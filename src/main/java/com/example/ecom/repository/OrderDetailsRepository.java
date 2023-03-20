package com.example.ecom.repository;

import com.example.ecom.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
    @Modifying
    @Query(value = "Delete From order_details where id=:id",nativeQuery = true)
    public void deleteByOrderDetailId(@Param("id")Long id);
}
