package com.g.pos_software.mapper;

import com.g.pos_software.models.Category;
import com.g.pos_software.models.Product;
import com.g.pos_software.models.Store;
import com.g.pos_software.payload.dto.ProductDto;

public class ProductMapper {
    public static ProductDto toDto(Product product){
        return ProductDto.builder().id(product.getId())
                .name(product.getName())
                .sku(product.getSku())
                .description(product.getDescription())
                .mrp(product.getMrp())
                .category(CategoryMapper.toDto(product.getCategory()))
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .sellingPrice(product.getSellingPrice())
                .brand(product.getBrand())
                .storeId(product.getStore() != null ? product.getStore().getId() : null)
                .image(product.getImage())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
    public static  Product toEntity(ProductDto productDto, Store store, Category  category){
        return Product.builder()
                .name(productDto.getName())
                .category(category)
                .store(store)
                .sku(productDto.getSku())
                .description(productDto.getDescription())
                .mrp(productDto.getMrp())
                .sellingPrice(productDto.getSellingPrice())
                .brand(productDto.getBrand())
                .image(productDto.getImage())
                .store(store)
                .build();

    }

}
