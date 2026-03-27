package com.g.pos_software.payload.dto;

import com.g.pos_software.models.Store;
import com.g.pos_software.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchDto {



    private Long id;
    private  String name;
    private  String address;
    private String phone;
    private String email;

    private List<String> workingDays;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    private StoreDto store;
    private Long storeId;


    private UserDto manager;

}
