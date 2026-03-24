package com.g.pos_software.payload.dto;

import com.g.pos_software.models.Store;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CategoryDto {

    private Long id;
    private String name;
    private Long storeId;

}
