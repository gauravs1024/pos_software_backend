package com.g.pos_software.payload.dto;

import com.g.pos_software.domain.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;


    private String fullName;


    private  String email;

    private String phone;
    private String password;

    private UserRole role;

    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;

}
