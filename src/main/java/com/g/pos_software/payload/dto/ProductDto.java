package com.g.pos_software.payload.dto;

import com.g.pos_software.models.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String sku;
    private String description;
    private Double mrp;
    private Double sellingPrice;
//    private Long categoryId;
    private CategoryDto category;
    private String brand;
    private String image;
    private Long storeId;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;

}
