package com.aplication.rest.services.impl;

import com.aplication.rest.entity.Floracion;
import com.aplication.rest.persistens.IFloracionDAO;
import com.aplication.rest.services.IServiceFloracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class IServiceFloracionImpl implements IServiceFloracion {

    @Autowired
    private IFloracionDAO floracionDAO;


    @Override
    public List<Floracion> findByOpcionANDIdFloracion(String opcion, Integer idFloracion) {
        return floracionDAO.findByOpcionANDIdFloracion(opcion,idFloracion);
    }

    @Override
    public Optional<Floracion> findById(Long id) {
        return floracionDAO.findById(id);
    }

    @Override
    public void save(Floracion floracion) {
        floracionDAO.save(floracion);
    }

    @Override
    public List<Floracion> getlistFloracion() {
        return floracionDAO.getlistFloracion();
    }


}
