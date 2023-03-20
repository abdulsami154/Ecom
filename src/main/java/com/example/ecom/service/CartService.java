package com.example.ecom.service;

import com.example.ecom.domain.Cart;
import com.example.ecom.dto.CartDTO;


import java.util.List;
import java.util.Optional;


public interface CartService {


    public List<CartDTO> getAllCart();

    public CartDTO save(CartDTO cartDto);

    public void delete(Long id);

//    public boolean existById(Long id) {
//        return cartRepository.existsById(id);
//    }

//    public Optional<Cart> getAllCartById(Long id) {
//        return cartRepository.findById(id);
//    }

    public CartDTO update(CartDTO cartDto, Long id);
}
