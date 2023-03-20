package com.example.ecom.service;

import com.example.ecom.domain.CartProduct;
import com.example.ecom.domain.Product;
import com.example.ecom.dto.CartProductDTO;
import com.example.ecom.repository.CartProductRepository;
import com.example.ecom.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface CartProductService {



    Logger logger = LoggerFactory.getLogger(CartProductService.class);

@Transactional
    public CartProductDTO save(CartProductDTO cartProductDto);

    public void deleteById(Long id);
    public List<CartProductDTO> getAllCartProduct();
//    public Optional<CartProduct> getAllCartProductById(Long id) {
//        return cartProductRepository.findById(id);
//    }

//    public boolean existById(Long id) {
//        return cartProductRepository.existsById(id);
//    }

    public CartProductDTO updateCartProduct(CartProductDTO cartProductDto, Long id);

    List<CartProductDTO> getAllCartProductById(Long id);
}
