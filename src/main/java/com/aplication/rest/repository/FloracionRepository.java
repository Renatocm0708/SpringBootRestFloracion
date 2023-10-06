package com.aplication.rest.repository;

import com.aplication.rest.entity.Floracion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloracionRepository extends CrudRepository<Floracion, Long> {

    @Query("SELECT f FROM Floracion f WHERE f.option = ?1 AND f.idFloracion = ?2")
    List<Floracion> findByOpcionANDIdFloracion(String opcion, Integer idFloracion);


}
