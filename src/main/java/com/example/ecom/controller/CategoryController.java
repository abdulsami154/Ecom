package com.example.ecom.controller;

import com.example.ecom.domain.Category;
import com.example.ecom.dto.CategoryDTO;
import com.example.ecom.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.save(categoryDTO));
    }
    @GetMapping("/category")
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id){
    categoryService.deleteCategory(id);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDto,@PathVariable Long id){
        return ResponseEntity.ok(categoryService.update(categoryDto,id));
        }
}
