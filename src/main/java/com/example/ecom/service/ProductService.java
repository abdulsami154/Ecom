package com.example.ecom.service;

import com.example.ecom.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProductService {


    public List<ProductDTO> getProduct();

    public void delete(Long id);

//    public ProductDTO save(String name, Long price, LocalDate createdAt, MultipartFile file);

    public ProductDTO save(List<MultipartFile> file, ProductDTO productDTO);

//    public boolean existsById(Long id) {
//    return productRepository.existsById(id);
//    }

//    public Optional<Product> getProductById(Long id) {
//    return productRepository.findById(id);
//    }
    public ProductDTO uploadById(Long id,ProductDTO productDto);

    public List<ProductDTO> getProductByCategoryId(Long id);

   public List<ProductDTO> searchAllProductByName(String value);

    List<ProductDTO> getAllProductsForHomePage();

    List<ProductDTO> getAllProductsAscOrder();

    List<ProductDTO> getAllProductsDescOrder();

    List<ProductDTO> getAllProducts();

}
