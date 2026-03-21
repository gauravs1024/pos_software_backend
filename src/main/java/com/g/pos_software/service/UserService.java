package com.g.pos_software.service;

import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.models.User;

import java.util.List;

public interface UserService {
    User getUserFromJwtToken(String token) throws UserException;
    User getCurrentUser() throws UserException;
    User getUserByEmail(String email) throws UserException;
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers(User user) throws UserException;
}
