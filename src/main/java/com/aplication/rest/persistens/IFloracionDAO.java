package com.aplication.rest.persistens;

import com.aplication.rest.entity.Floracion;

import java.util.List;
import java.util.Optional;

public interface IFloracionDAO {


    List<Floracion> getlistFloracion();

    List<Floracion> findByOpcionANDIdFloracion(String opcion, Integer idFloracion);

    Optional<Floracion> findById(Long id);

    void save(Floracion floracion);



}
