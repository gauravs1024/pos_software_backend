package com.g.pos_software.payload.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.g.pos_software.domain.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;


    private String fullName;


    private  String email;

    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private UserRole role;
    private  Long storeId;

    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;

}
