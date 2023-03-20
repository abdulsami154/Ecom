package com.example.ecom.controller;

import com.example.ecom.domain.ProductImage;
import com.example.ecom.dto.ProductDTO;

import com.example.ecom.service.ImageService;
import com.example.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ImageService imageService;
    @PostMapping("/product")
    public ResponseEntity<ProductDTO> save(@RequestParam("file") List<MultipartFile> file,
                                           @Valid ProductDTO productDto){
        return ResponseEntity.ok(productService.save(file,productDto));
    }

//    @GetMapping("/product/image/{fileName:.+}")
//    public Resource getAllProductsWithImage(@PathVariable String filename){
//        return imageService.load(filename);
//    }
//    @GetMapping("product/image")
//    public List<ProductImage> getAllProductsWithImage(){
//        return imageService.getImage();
//    }

    @GetMapping("/product/all")
    public List<ProductDTO> getAllProductsWithImage(){
        return productService.getAllProducts();
    }

//get all product by category id
    @GetMapping("/product/{id}")
    public ResponseEntity<List<ProductDTO>> getAllProductsByCategory(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductByCategoryId(id));
    }

//search product by name
    @GetMapping("/product/search/{value}")
    public ResponseEntity<List<ProductDTO>> searchAllProductByName(@PathVariable String value){
        return ResponseEntity.ok(productService.searchAllProductByName(value));
    }
    // get home page product
    @GetMapping("/product/homeProducts")
    public ResponseEntity<List<ProductDTO>> getAllProductForHome(){
        return ResponseEntity.ok(productService.getAllProductsForHomePage());
    }
//get product ascending order
    @GetMapping("/product/asc")
    public ResponseEntity<List<ProductDTO>> getAllProductAscending(){
        return ResponseEntity.ok(productService.getAllProductsAscOrder());
    }

    //get product descending order
    @GetMapping("/product/desc")
    public ResponseEntity<List<ProductDTO>> getAllProductDescending(){
        return ResponseEntity.ok(productService.getAllProductsDescOrder());
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getProduct());
    }
    @DeleteMapping("/product/{id}")
    public void deleteTask(@PathVariable Long id){
        productService.delete(id);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateTask(@RequestBody ProductDTO productDto,@PathVariable Long id){
        return ResponseEntity.ok(productService.uploadById(id,productDto));
    }


    @GetMapping("/image/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getFile(@PathVariable String fileName) throws IOException {
        Resource file = imageService.load(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(file.getInputStream()));
    }

}
