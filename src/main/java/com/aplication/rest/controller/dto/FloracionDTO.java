package com.aplication.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FloracionDTO {

    private Long id;


    private String option;

    private Integer idFloracion;
}
