package com.example.ecom.service.impl;

import com.example.ecom.domain.Category;
import com.example.ecom.domain.OrderDetails;
import com.example.ecom.dto.OrderDetailsDTO;
import com.example.ecom.exception.RecordNotFoundException;
import com.example.ecom.repository.OrderDetailsRepository;
import com.example.ecom.service.OrderDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderDetailImplService implements OrderDetailService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsDTO save(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails=orderDetailsRepository.save(toDo(orderDetailsDTO));
        return toDto(orderDetails);
    }

    public List<OrderDetailsDTO> getAllOrderDetails() {
        return orderDetailsRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());

    }

    public void deleteOrderById(Long id) {
        Optional<OrderDetails> orderDetails=orderDetailsRepository.findById(id);
        if (orderDetails.isPresent()) {
            orderDetailsRepository.deleteByOrderDetailId(id);
        }else {
            throw new RecordNotFoundException("order detail not found on this id= "+id);
        }
    }

    public Optional<OrderDetails> getAllOrderDetailsById(Long id) {
        return orderDetailsRepository.findById(id);
    }

    public boolean existById(Long id) {
        return orderDetailsRepository.existsById(id);
    }

    @Override
    public OrderDetailsDTO updateOrderDetail(OrderDetailsDTO orderDetailsDTO, Long id) {
        Optional<OrderDetails> orderDetailId = orderDetailsRepository.findById(id);
        if (orderDetailId.isPresent()) {
            OrderDetails orderDetailsUpdated = orderDetailsRepository.findById(id).orElse(null);
            orderDetailsUpdated.setCreatedAt(orderDetailsDTO.getCreatedAt());
            orderDetailsUpdated.setCartProduct(orderDetailsDTO.getCartProduct());
            OrderDetails orderDetails = orderDetailsRepository.save(orderDetailsUpdated);
            return toDto(orderDetails);
        }

        throw new RuntimeException("Category not found on this id= "+id);
    }


    public OrderDetails toDo(OrderDetailsDTO orderDetailsDTO){
        return modelMapper.map(orderDetailsDTO,OrderDetails.class);
    }
    public OrderDetailsDTO toDto(OrderDetails orderDetails){
        return modelMapper.map(orderDetails ,OrderDetailsDTO.class);
    }
}
