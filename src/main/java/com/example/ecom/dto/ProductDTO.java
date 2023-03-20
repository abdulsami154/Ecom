package com.example.ecom.dto;

import com.example.ecom.domain.CartProduct;
import com.example.ecom.domain.Category;
import com.example.ecom.domain.ProductImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
   // @NotBlank(message = "name should not be blank")
    private String name;
   // @NotNull(message = "price should not be Null")
    private Long price;
   // @NotNull(message = "category id should not be Null")
    private Long categoryId;
//    private List<String> images;
    private List<ProductImage> productImages;

}
