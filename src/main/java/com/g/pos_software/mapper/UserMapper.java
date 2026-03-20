package com.g.pos_software.mapper;

import com.g.pos_software.models.User;
import com.g.pos_software.payload.dto.UserDto;

public class UserMapper {


    public static UserDto toDTO(User savedUser) {

        UserDto userDto=new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setFullName(savedUser.getFullName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setRole(savedUser.getRole());
        userDto.setCreateAt(savedUser.getCreateAt());
        userDto.setUpdatedAt(savedUser.getLastLogin());
        userDto.setLastLogin(savedUser.getLastLogin());
        userDto.setPhone(savedUser.getPhone());
        return  userDto;
    }
}
