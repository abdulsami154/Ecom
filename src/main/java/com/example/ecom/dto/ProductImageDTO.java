package com.example.ecom.dto;

import com.example.ecom.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductImageDTO {
    private Long id;
    @NotBlank(message = "name should not be blank")
    private String image;
    private Product product;
}
