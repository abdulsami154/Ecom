package com.example.ecom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(RecordNotFoundException ex) {
        ErrorMessage errorMessage=ErrorMessage.builder()
                .body(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        Map<String ,String> errors =new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->
                errors.put(error.getField(),
                        error.getDefaultMessage() ));
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
