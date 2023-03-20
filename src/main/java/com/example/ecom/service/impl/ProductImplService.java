package com.example.ecom.service.impl;

import com.example.ecom.domain.Category;
import com.example.ecom.domain.Product;
import com.example.ecom.domain.ProductImage;
import com.example.ecom.dto.ProductDTO;
import com.example.ecom.exception.RecordNotFoundException;
import com.example.ecom.repository.CategoryRepository;
import com.example.ecom.repository.ProductRepository;
import com.example.ecom.service.ImageService;
import com.example.ecom.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductImplService implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ImageService imageService;

    @Value("${upload.directory}")
    String uploadDirectory;
//    public ProductDTO save(ProductDTO productDTO) {
//        //image save - > url mil jaega
//        // url ko set krwaogy product image entity
//        // product image enity ko set krwaogy product me
//

    public List<ProductDTO> getProduct(){
        return productRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(Long id) {
        return productRepository.findProductByCategoryId(id).stream().map(c->toDto(c)).collect(Collectors.toList());

    }

    @Override
    public List<ProductDTO> searchAllProductByName(String value) {
        return productRepository.findProductSearchByName(value).stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsForHomePage() {
        return productRepository.getAllProductsForHome().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsAscOrder() {
        return productRepository.getAllProductsAscOrder().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsDescOrder() {
        return productRepository.getAllProductsDescOrder().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
       return productList.stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    public void delete(Long id) {
            Optional<Product> product=productRepository.findById(id);
            if (product.isPresent()){
                productRepository.deleteById(id);
            }else {
                throw new RecordNotFoundException("Product not found on this id= "+id);
            }
    }

    @Override
    public ProductDTO save(List<MultipartFile> file, ProductDTO productDTO) {
        List<ProductImage> imageUrls = new ArrayList<>();
        //pehle file save kreyga image ki , image ka url ayega woh product entity me set hoga
        // phr prodct dto se data nikal ky product entity me dalay ga
        //product dto se category id nikal ky find by category se object ajaega category ka
        //wo tm product me dalwa dogy agr category id se null aya to exception throw kr dena
        // or product save mat krwana
        // phr product entity ko save krey ga

        for(MultipartFile image: file){
            String imageUrl=imageService.saveImage(image);
            imageUrls.add(new ProductImage().builder().image(imageUrl).build());
        }
        Long categoryId=productDTO.getCategoryId();
        Optional<Category> category=categoryRepository.findById(categoryId);
        if (category.isPresent()){
            Product pro = toDo(productDTO);
            pro.setProductImages(imageUrls);
            pro.setCategory(category.get());
            Product product=productRepository.save(pro);

            return toDto(product);
        }
    return null;
    }


//    public List<Product> getProduct() {
//        return productRepository.findAll();
//    }

    public ProductDTO uploadById(Long id,ProductDTO productDto) {
        Optional<Product> productId = productRepository.findById(id);
        if (productId.isPresent()) {
            Product productUpdate = productRepository.findById(id).orElse(null);
            productUpdate.setName(productDto.getName());
            productUpdate.setPrice(productDto.getPrice());
//            productUpdate.setCreatedAt(LocalDate.now());
//            productUpdate.setCategory(productDto.getCategory());
            Product product= productRepository.save(productUpdate);
            return toDto(product);
        }
        throw new RuntimeException("Product not Found by id "+id);
    }



    public Product toDo(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .build();//modelMapper.map(productDTO, Product.class);
    }

    public ProductDTO toDto(Product product) {
        return modelMapper.map(product ,ProductDTO.class);
    }

//    public ProductDTO toDto(Product product) {
//        List<String> images = new ArrayList<>();
//        if(product.getProductImage() != null) {
//            images.add(product.getProductImage().getImage());
//        }
//        return ProductDTO.builder()
//                .id(product.getId())
//                .categoryId(product.getCategory().getId())
//                .price(product.getPrice())
//                //.createdAt(product.getCreatedAt())
//                .name(product.getName())
//                .images(images)
//                .build();
//    }
}
