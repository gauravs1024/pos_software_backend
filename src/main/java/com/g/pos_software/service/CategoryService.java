package com.g.pos_software.service;

import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.payload.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto dto) throws Exception;
    List<CategoryDto> getCategoriesByStoreId(Long storeId);
    CategoryDto updateCategory(Long id, CategoryDto dto) throws Exception;
    void deleteCategory(Long id) throws Exception;
}
