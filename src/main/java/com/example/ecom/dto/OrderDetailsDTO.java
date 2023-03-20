package com.example.ecom.dto;

import com.example.ecom.domain.CartProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailsDTO {
    private Long id;
    @NotNull(message = "createdAt should not be Null")
    private LocalDate createdAt;
    private CartProduct cartProduct;
}
