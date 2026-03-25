package com.g.pos_software.exceptions;
import com.g.pos_software.payload.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Existing generic handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .status(false)
                        .message(ex.getMessage())
                        .build()
        );
    }

    // NEW: Specifically for 401 Unauthorized errors
    @ExceptionHandler(org.springframework.security.core.AuthenticationException.class)
    public ResponseEntity<ApiResponse<?>> handleAuthenticationException(AuthenticationException ex) {
        return ResponseEntity.status(401).body(
                ApiResponse.builder()
                        .status(false)
                        .message("Unauthorized: " + ex.getMessage()) // Or your custom message
                        .build()
        );
    }
}