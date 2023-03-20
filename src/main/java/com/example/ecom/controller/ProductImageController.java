//package com.example.ecom.controller;
//
//import com.example.ecom.domain.Product;
//import com.example.ecom.dto.ProductDTO;
//import com.example.ecom.dto.ProductImageDTO;
//import com.example.ecom.service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api")
//public class ProductImageController {
//
//
////    @Autowired
////    FileService fileService;
//
//
//
//
//    @Autowired
//    ImageService imageService;
//
//    @PostMapping("/upload")
//    public ResponseEntity<ProductImageDTO> uploadPostImage(@RequestParam MultipartFile file,@RequestBody ProductDTO productDTO){
//      return imageService.saveImage(file,productDTO);
//
////        return null;
//    }
//
//    @GetMapping("/image/{fileName:.+}")
//    @ResponseBody
//    public ResponseEntity<InputStreamResource> getFile(@PathVariable String fileName) throws IOException {
//        Resource file = imageService.load(fileName);
//        return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_JPEG)
//                .body(new InputStreamResource(file.getInputStream()));
//    }}
