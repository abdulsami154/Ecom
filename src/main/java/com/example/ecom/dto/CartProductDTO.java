package com.example.ecom.dto;

import com.example.ecom.domain.Cart;
import com.example.ecom.domain.OrderDetails;
import com.example.ecom.domain.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductDTO {
    private Long id;
    @NotNull(message = "amount should not be Null")
    private Double amount;
    @NotNull(message = "quantity should not be Null")
    private Long quantity;
    private Cart cart;
    private Product product;
    private OrderDetails orderDetails;
}
