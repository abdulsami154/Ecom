package com.example.ecom.service.impl;

import com.example.ecom.domain.Cart;
import com.example.ecom.domain.User;
import com.example.ecom.dto.CartDTO;
import com.example.ecom.dto.UserDTO;
import com.example.ecom.exception.RecordNotFoundException;
import com.example.ecom.repository.CartRepository;
import com.example.ecom.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CartImplService implements CartService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CartRepository cartRepository;


    public List<CartDTO> getAllCart() {
        return cartRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    public CartDTO save(CartDTO cartDto) {
        Cart cart= cartRepository.save(toDo(cartDto));
        return toDto(cart);
    }

    public void delete(Long id) {
        Optional<Cart> cart=cartRepository.findById(id);
        if (cart.isPresent()) {
            cartRepository.deleteById(id);
        }else {
            throw new RecordNotFoundException("Record not found in this id= "+id);
        }
    }

    public CartDTO update(CartDTO cartDto, Long id) {
        Optional<Cart> cartId=cartRepository.findById(id);
        if (cartId.isPresent()){
            Cart cartUpdated = cartRepository.findById(id).orElse(null);
            cartUpdated.setCreatedAt(cartDto.getCreatedAt());
            cartUpdated.setCreatedBy(cartDto.getCreatedBy());
            Cart cart=cartRepository.save(cartUpdated);
            return toDto(cart);
        }
        throw new RuntimeException("Cart not found on this id= "+id);
    }
    public Cart toDo(CartDTO CartDto) {
        return modelMapper.map(CartDto, Cart.class);
    }

    public CartDTO toDto(Cart cart) {
        return modelMapper.map(cart, CartDTO.class);
    }
}
