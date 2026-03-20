package com.g.pos_software.service.impl;
import com.g.pos_software.configuration.JwtProvider;
import com.g.pos_software.exceptions.UserException;
import com.g.pos_software.models.User;
import com.g.pos_software.repository.UserRepository;
import com.g.pos_software.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public User getUserFromJwtToken(String token) throws UserException {

        String email=jwtProvider.getEmailFromToken(token);
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new UserException("Invalid token");
        }
        return null;
    }

    @Override
    public User getCurrentUser() throws UserException {
        String email= SecurityContextHolder.getContext().getAuthentication().getName();
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new UserException("User not found");
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) throws UserException {
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new UserException("User not found");
        }
        return user;
    }

    @Override
    public User getUserById(Long id) throws UserException {
        User user=userRepository.findById(id).orElse(null);
        if(user==null){
            throw new UserException("User not found");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
