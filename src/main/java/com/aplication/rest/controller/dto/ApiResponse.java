package com.aplication.rest.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private String idError;
    private String omensaje;
    private T data;
    public ApiResponse(String idError, String omensaje, T data) {
        this.idError = idError;
        this.omensaje = omensaje;
        this.data = data;
    }

}
