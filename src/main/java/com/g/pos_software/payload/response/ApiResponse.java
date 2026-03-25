package com.g.pos_software.payload.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>{
    private boolean status;
    private String message;
    private T data;

}
