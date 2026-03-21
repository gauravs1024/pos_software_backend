package com.g.pos_software.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T>{
    private boolean status;
    private String message;
    private T data;

}
