package com.aplication.rest.controller.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FloracionResponseDTO {
    private Long id;

    private String option;

    private Integer idFloracion;
}
