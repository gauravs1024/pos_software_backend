package com.g.pos_software.mapper;

import com.g.pos_software.models.Category;
import com.g.pos_software.payload.dto.CategoryDto;
import com.g.pos_software.payload.dto.ProductDto;

public class CategoryMapper {
    public  static CategoryDto toDto(ProductDto productDto, Category category){
        return CategoryDto.builder()
                .name(category.getName())
                .storeId(category.getStore().getId()!=null?category.getStore().getId():null)
                .build();

    }



}
