package com.g.pos_software.payload.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor

public class ApiResponse<T>{
    private boolean status;
    private String message;
    private T data;

}
