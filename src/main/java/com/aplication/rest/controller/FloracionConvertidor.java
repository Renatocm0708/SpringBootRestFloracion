package com.aplication.rest.controller;

import com.aplication.rest.controller.dto.FloracionResponseDTO;
import com.aplication.rest.entity.Floracion;

import java.util.ArrayList;
import java.util.List;

public class FloracionConvertidor
{
    public static List<FloracionResponseDTO> convertToFloracionResponseDTO(List<Floracion> floracionList) {
        List<FloracionResponseDTO> FloracionDTO_SP = new ArrayList<>();
        for (Floracion floracion : floracionList) {
            FloracionResponseDTO floracionDTO_SP = new FloracionResponseDTO();
            floracionDTO_SP.setId(floracion.getId());
            floracionDTO_SP.setOption(floracion.getOption());
            floracionDTO_SP.setIdFloracion(floracion.getIdFloracion());
            FloracionDTO_SP.add(floracionDTO_SP);
        }
        return FloracionDTO_SP;
    }
}
