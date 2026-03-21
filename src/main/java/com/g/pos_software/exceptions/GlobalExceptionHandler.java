package com.g.pos_software.exceptions;
import com.g.pos_software.payload.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .status(false)
                        .message(ex.getMessage())
                        .data(null)
                        .build()
        );
    }
}
