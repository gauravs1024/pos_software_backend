package com.g.pos_software.payload.dto;

import com.g.pos_software.domain.StoreStatus;
import com.g.pos_software.models.StoreContact;
import lombok.Data;



import java.time.LocalDateTime;

@Data
public class StoreDto {
    private Long id;


    private String brand;


    private UserDto storeAdmin;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private  String description;
    private String storeType;

    private StoreStatus status;

    private StoreContact contact;
}
