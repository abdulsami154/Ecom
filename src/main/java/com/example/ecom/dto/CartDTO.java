package com.example.ecom.dto;


import com.example.ecom.domain.CartProduct;
import com.example.ecom.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDTO {
    private Long id;
    @NotNull(message = "createdAt should not be Null")
    private LocalDate createdAt;

    private User createdBy;
    private List<CartProduct> cartProductsList;
}
