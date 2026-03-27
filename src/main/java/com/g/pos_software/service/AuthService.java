package com.g.pos_software.service;

import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.payload.dto.UserDto;
import com.g.pos_software.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse signup(UserDto userDto) throws Exception;
    AuthResponse login(UserDto userDto) throws UserException;
}
