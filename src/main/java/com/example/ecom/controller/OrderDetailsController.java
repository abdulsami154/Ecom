package com.example.ecom.controller;

import com.example.ecom.domain.OrderDetails;
import com.example.ecom.dto.OrderDetailsDTO;
import com.example.ecom.service.OrderDetailService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderDetailsController {
    @Autowired(required = false)
    OrderDetailService orderDetailService;

    @GetMapping("/orderDetails")
    public ResponseEntity<List<OrderDetailsDTO>> getAllDetails(){
        return ResponseEntity.ok(orderDetailService.getAllOrderDetails());
    }
    @PostMapping("/orderDetails")
    public ResponseEntity<OrderDetailsDTO> save(@Valid @RequestBody OrderDetailsDTO orderDetailsDTO){
        return ResponseEntity.ok(orderDetailService.save(orderDetailsDTO));
    }
    @DeleteMapping("/orderDetails/{id}")
    public void deleteOrderDetails(@PathVariable Long id){
        orderDetailService.deleteOrderById(id);

    }

    @PutMapping("/orderDetails/{id}")
    public ResponseEntity<OrderDetailsDTO> updateOrderDetails(@PathVariable Long id,@RequestBody OrderDetailsDTO orderDetailsDto){
        return ResponseEntity.ok(orderDetailService.updateOrderDetail(orderDetailsDto,id));
    }
}
//if (orderDetailService.existById(id)){
//        OrderDetails orderDetailsUpdated=orderDetailService.getAllOrderDetailsById(id).orElse(null);
//        orderDetailsUpdated.setCreatedAt(orderDetails.getCreatedAt());
//        orderDetailsUpdated.setCartProduct(orderDetails.getCartProduct());
//        return ResponseEntity.ok(orderDetailService.save(orderDetailsUpdated));
//        }else {
//        HashMap<String,String> message=new HashMap<>();
//        message.put("message",id+"product not Found");
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//        }
