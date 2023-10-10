package com.aplication.rest.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String IdError;
    private String OMensaje;

    public ErrorResponse(String IdError, String OMensaje) {
        this.IdError = IdError;
        this.OMensaje = OMensaje;
    }
}
