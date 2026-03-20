package com.g.pos_software.service;

import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.payload.dto.UserDto;
import com.g.pos_software.payload.request.AuthResponse;

public interface AuthService {

    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;
}
