package com.example.ecom.dto;

import com.example.ecom.domain.Cart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    @NotBlank(message = "name should not be blank")
    private String name;
    @NotBlank(message = "email should not be blank")
    private String email;
    @NotNull(message = "createdAt should not be blank")
    private LocalDate createdAt;


    private Cart cart;
}
