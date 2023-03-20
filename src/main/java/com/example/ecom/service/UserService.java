package com.example.ecom.service;

import com.example.ecom.domain.User;
import com.example.ecom.dto.UserDTO;
import com.example.ecom.repository.CartRepository;
import com.example.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


public interface UserService {


    public UserDTO save(UserDTO userDto);

    public List<UserDTO> getAllUsers();

    @Transactional
    public void deleteUser(Long id);

//    public boolean existsById(Long id) {
//    return userRepository.existsById(id);
//    }

//    public Optional<User> getUserById(Long id) {
//        return userRepository.findById(id);
//    }

    public UserDTO update(UserDTO userDto, Long id);

}
