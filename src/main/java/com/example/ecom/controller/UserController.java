package com.example.ecom.controller;

import com.example.ecom.domain.User;
import com.example.ecom.dto.UserDTO;
import com.example.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDto, @PathVariable Long id){
          return ResponseEntity.ok(userService.update(userDto,id));
    }

}
