package com.g.pos_software.controllers;

import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.mapper.UserMapper;
import com.g.pos_software.models.User;
import com.g.pos_software.payload.dto.UserDto;
import com.g.pos_software.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfile(
            @RequestHeader("Authorization") String jwt
    ) throws UserException {
        User user=userService.getUserFromJwtToken(jwt);
        return  ResponseEntity.ok(UserMapper.toDTO(user));

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserProfileById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws UserException {
        User user=userService.getUserById(id);
        return  ResponseEntity.ok(UserMapper.toDTO(user));

    }

}
