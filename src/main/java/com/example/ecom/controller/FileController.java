//package com.example.ecom.controller;
//
////import com.example.ecom.playload.FileResponse;
//import com.example.ecom.service.FileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/files")
//public class FileController {
//
//        @Autowired
//        FileService fileService;
//
//    @Value("${project.image}")
//    String path;
//
//    @PostMapping("/image")
//    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image")MultipartFile image){
//        String fileName= null;
//        try {
//            fileName = this.fileService.uploadImage(path,image);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(new FileResponse(null,"image is not uploaded due to error on server"), HttpStatus.OK);
//
//        }
//
//        return new ResponseEntity<>(new FileResponse(fileName,"image is successfully upload"), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
