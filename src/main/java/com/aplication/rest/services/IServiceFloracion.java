package com.aplication.rest.services;

import com.aplication.rest.entity.Floracion;

import java.util.List;
import java.util.Optional;

public interface IServiceFloracion {

    List<Floracion> findByOpcionANDIdFloracion(String opcion, Integer idFloracion);

    Optional<Floracion> findById(Long id);

    void save(Floracion floracion);

    List<Floracion> getlistFloracion();

    List<Floracion> consultaFloracionesPorOpcionYId(String opcion, Integer idFloracion);

}
