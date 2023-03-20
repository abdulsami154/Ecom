package com.example.ecom.controller;


import com.example.ecom.domain.Cart;
import com.example.ecom.dto.CartDTO;
import com.example.ecom.repository.CartRepository;

import com.example.ecom.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartService cartService;
    @GetMapping("/cart")
    public ResponseEntity<List<CartDTO>> getAllCart(){
        return ResponseEntity.ok(cartService.getAllCart());
    }
    @PostMapping("/cart")
        public ResponseEntity<CartDTO> save(@Valid @RequestBody CartDTO cartDto){
        return ResponseEntity.ok(cartService.save(cartDto));
    }
    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.delete(id);
    }
    @PutMapping("/cart/{id}")
    public ResponseEntity<CartDTO> updateCart(@Valid @RequestBody CartDTO cartDto,@PathVariable Long id) {
            return ResponseEntity.ok(cartService.update(cartDto, id));
        }
}
