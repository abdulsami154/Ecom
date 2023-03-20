package com.example.ecom.service;

import com.example.ecom.domain.Category;
import com.example.ecom.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

        public CategoryDTO save(CategoryDTO categoryDto);

    public List<CategoryDTO> getAllCategory();

    public void deleteCategory(Long id);

//    public Optional<Category> getAllCategoryById(Long id) {
//        return categoryRepository.findById(id);
//    }

        public CategoryDTO update(CategoryDTO categoryDto, Long id);
}
