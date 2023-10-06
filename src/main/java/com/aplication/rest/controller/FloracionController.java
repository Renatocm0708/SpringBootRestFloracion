package com.aplication.rest.controller;

import com.aplication.rest.controller.dto.FloracionDTO;
import com.aplication.rest.entity.Floracion;
import com.aplication.rest.services.IServiceFloracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api/floracion")
public class FloracionController {
    @Autowired
    private IServiceFloracion serviceFloracion;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Floracion> floracionOptional = serviceFloracion.findById(id);

        if(floracionOptional.isPresent()){
            Floracion floracion = floracionOptional.get();
            FloracionDTO floracionDTO = FloracionDTO.builder()
                    .id(floracion.getId())
                    .option(floracion.getOption())
                    .idFloracion(floracion.getIdFloracion())
                    .build();

            return ResponseEntity.ok(floracionDTO);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/find/{opcion}/{idFloracion}")
    public ResponseEntity<List<FloracionDTO>> findByOpcionAndIdFloracion(
            @PathVariable String opcion,
            @PathVariable Integer idFloracion
    ) {
        List<Floracion> floracionList = serviceFloracion.findByOpcionANDIdFloracion(opcion,idFloracion);

        if (!floracionList.isEmpty()) {
            List<FloracionDTO> floracionDTOs = new ArrayList<>();
            for (Floracion floracion : floracionList) {
                FloracionDTO floracionDTO = FloracionDTO.builder()
                        .id(floracion.getId())
                        .option(floracion.getOption())
                        .idFloracion(floracion.getIdFloracion())
                        .build();
                floracionDTOs.add(floracionDTO);
            }
            return ResponseEntity.ok(floracionDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FloracionDTO floracionDTO) throws URISyntaxException {
        if (floracionDTO.getOption().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        Floracion floracion = Floracion.builder()
                .option(floracionDTO.getOption())
                .idFloracion(floracionDTO.getIdFloracion())
                .build();

        serviceFloracion.save(floracion);

        return ResponseEntity.created(new URI("/api/floracion/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFloracion(@PathVariable Long id, @RequestBody FloracionDTO floracionDTO){
        Optional<Floracion> optionalFloracion = serviceFloracion.findById(id);

        if (optionalFloracion.isPresent()){
            Floracion floracion = optionalFloracion.get();
            floracion.setOption(floracionDTO.getOption());
            floracion.setIdFloracion(floracionDTO.getIdFloracion());
            serviceFloracion.save(floracion);

            return ResponseEntity.ok("registro actualizado");

        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<?> getlistFloracion(){
        return ResponseEntity.ok(serviceFloracion.getlistFloracion());
    }
}
