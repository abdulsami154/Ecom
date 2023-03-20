package com.example.ecom.service;

import com.example.ecom.domain.OrderDetails;
import com.example.ecom.dto.OrderDetailsDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderDetailService {

    public OrderDetailsDTO save(OrderDetailsDTO orderDetailsDTO);

    public List<OrderDetailsDTO> getAllOrderDetails();

    public void deleteOrderById(Long id);

    public Optional<OrderDetails> getAllOrderDetailsById(Long id);
    public boolean existById(Long id);

    OrderDetailsDTO updateOrderDetail(OrderDetailsDTO orderDetailsDTO,Long id);
}
