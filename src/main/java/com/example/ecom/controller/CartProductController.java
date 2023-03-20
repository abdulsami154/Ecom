package com.example.ecom.controller;

import com.example.ecom.domain.Cart;
import com.example.ecom.domain.CartProduct;
import com.example.ecom.dto.CartProductDTO;
import com.example.ecom.service.CartProductService;
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
public class CartProductController {
    @Autowired(required = false)
    CartProductService cartProductService;
    @GetMapping("/cartProduct")
    public List<CartProductDTO> getAllCartProduct(){
    return cartProductService.getAllCartProduct();
    }

    @GetMapping("/cartProduct/{id}")
    public ResponseEntity<List<CartProductDTO>> getAllCartProduct(@PathVariable Long id){
        return ResponseEntity.ok(cartProductService.getAllCartProductById(id));
    }

    @PostMapping("/cartProduct")
    public ResponseEntity<CartProductDTO> save(@Valid @RequestBody CartProductDTO cartProductDto){
        return ResponseEntity.ok(cartProductService.save(cartProductDto));
    }

    @DeleteMapping("/cartProduct/{id}")
    public void deleteCartProduct(@PathVariable Long id){
        cartProductService.deleteById(id);
    }

    @PutMapping("/cartProduct/{id}")
    public ResponseEntity<CartProductDTO> updateCartProduct(@Valid @PathVariable Long id, @RequestBody CartProductDTO cartProductDto){
            return ResponseEntity.ok(cartProductService.updateCartProduct(cartProductDto,id));
    }
}
