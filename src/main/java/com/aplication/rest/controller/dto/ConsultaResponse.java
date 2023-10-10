package com.aplication.rest.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaResponse {
    private String IdError;
    private String OMensaje;
    private Object data;

    public ConsultaResponse(String IdError, String OMensaje, Object data) {
        this.IdError = IdError;
        this.OMensaje = OMensaje;
        this.data = data;
    }
}
