package com.example.ecom.service.impl;

import com.example.ecom.domain.CartProduct;
import com.example.ecom.domain.Category;
import com.example.ecom.dto.CartProductDTO;
import com.example.ecom.dto.CategoryDTO;
import com.example.ecom.exception.RecordNotFoundException;
import com.example.ecom.repository.CartProductRepository;
import com.example.ecom.repository.ProductRepository;
import com.example.ecom.service.CartProductService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CartProductImplService implements CartProductService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CartProductRepository cartProductRepository;

    public List<CartProductDTO> getAllCartProduct() {
        return cartProductRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public CartProductDTO updateCartProduct(CartProductDTO cartProductDto, Long id) {
        Optional<CartProduct> cartProduct1 = cartProductRepository.findById(id);
        if(cartProduct1.isPresent()){
            cartProduct1.get().setProduct(cartProductDto.getProduct());
            cartProduct1.get().setCart(cartProductDto.getCart());
            cartProduct1.get().setAmount(cartProductDto.getAmount());
            cartProduct1.get().setQuantity(cartProductDto.getQuantity());
            CartProduct cartProduct = cartProductRepository.save(cartProduct1.get());
            return toDto(cartProduct);
        }
        throw new RecordNotFoundException(String.format("Cart-Product doesn't exist on this id ==> %d",id));

    }

    @Override
    public List<CartProductDTO> getAllCartProductById(Long id) {
        return cartProductRepository.findAllCartByid(id).stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    Logger logger = LoggerFactory.getLogger(CartProductService.class);

    @Transactional
    public CartProductDTO save(CartProductDTO cartProductDto) {

        CartProduct cartProduct=cartProductRepository.save(toDo(cartProductDto));

        return toDto(cartProduct);
    }


    public void deleteById(Long id) {
        Optional<CartProduct> cartProduct=cartProductRepository.findById(id);
        if (cartProduct.isPresent()){
        cartProductRepository.deleteById(id);
        }else {
         throw new RecordNotFoundException("Cart Product not found on this id= "+id);
        }
    }

    public CartProduct toDo(CartProductDTO cartProductDTO){
        return modelMapper.map(cartProductDTO,CartProduct.class);
    }
    public CartProductDTO toDto(CartProduct CartProduct){
        return modelMapper.map(CartProduct ,CartProductDTO.class);
    }

}
//        Long id=cartProduct.getProduct().getId();
//        Optional<Product> productId=productRepository.findById(id);
//        List<CartProduct> _cartProductRepository=cartProductRepository.findAll();
//    logger.info(String.valueOf(_cartProductRepository));