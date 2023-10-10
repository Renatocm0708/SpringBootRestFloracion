package com.aplication.rest.controller;

import com.aplication.rest.controller.dto.ErrorResponse;
import com.aplication.rest.controller.dto.FloracionDTO;
import com.aplication.rest.controller.dto.FloracionResponseDTO;
import com.aplication.rest.entity.Floracion;
import com.aplication.rest.services.IServiceFloracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
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


    @GetMapping("/consulta/{opcion}/{idFloracion}")
    public ResponseEntity<List<FloracionDTO>> consultaFloracionesPorOpcionYId(
            @PathVariable String opcion,
            @PathVariable Integer idFloracion
    ){
        List<Floracion> floracionListSP = serviceFloracion.consultaFloracionesPorOpcionYId(opcion, idFloracion);

        if (!floracionListSP.isEmpty()){
            List<FloracionDTO> FloracionDTO_SP = new ArrayList<>();
            for (Floracion floracion : floracionListSP){
                FloracionDTO floracionDTO_SP = FloracionDTO.builder()
                        .id(floracion.getId())
                        .option(floracion.getOption())
                        .idFloracion(floracion.getIdFloracion())
                        .build();
                FloracionDTO_SP.add(floracionDTO_SP);
            }
            return ResponseEntity.ok(FloracionDTO_SP);

        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/consulta")
    public ResponseEntity<?> consultaFloracionesPorOpcionYId(@RequestBody FloracionDTO floracionDTO) {
        try {
            String medio = floracionDTO.getMedio();
            String canal = floracionDTO.getCanal();
            String aplicacion = floracionDTO.getAplicacion();

            if ("1".equals(medio) && "01".equals(canal) && "001".equals(aplicacion)) {
                String option = floracionDTO.getOption();
                Integer idFloracion = floracionDTO.getIdFloracion();

                List<Floracion> floracionListSP = serviceFloracion.consultaFloracionesPorOpcionYId(option, idFloracion);

                if (!floracionListSP.isEmpty()) {
                    List<FloracionResponseDTO> FloracionDTO_SP = new ArrayList<>();
                    for (Floracion floracion : floracionListSP) {
                        FloracionResponseDTO floracionDTO_SP = new FloracionResponseDTO();
                        floracionDTO_SP.setId(floracion.getId());
                        floracionDTO_SP.setOption(floracion.getOption());
                        floracionDTO_SP.setIdFloracion(floracion.getIdFloracion());
                        FloracionDTO_SP.add(floracionDTO_SP);
                    }

                    return ResponseEntity.ok(FloracionDTO_SP);
                } else {
                    return ResponseEntity.notFound().build();
                }
            } else {
                ErrorResponse errorResponse = new ErrorResponse("001", "Canal medio aplicación incorrecto");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

}
