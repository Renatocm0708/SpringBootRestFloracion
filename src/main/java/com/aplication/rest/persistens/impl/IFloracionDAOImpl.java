package com.aplication.rest.persistens.impl;

import com.aplication.rest.entity.Floracion;
import com.aplication.rest.persistens.IFloracionDAO;
import com.aplication.rest.repository.FloracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IFloracionDAOImpl implements IFloracionDAO {

    @Autowired
    private FloracionRepository floracionRepository;


    @Override
    public List<Floracion> getlistFloracion() {
        return (List<Floracion>) floracionRepository.getlistFloracion();
    }

    @Override
    public List<Floracion> findByOpcionANDIdFloracion(String opcion, Integer idFloracion) {
        return floracionRepository.findByOpcionANDIdFloracion(opcion,idFloracion);
    }

    @Override
    public Optional<Floracion> findById(Long id) {
        return floracionRepository.findById(id);
    }

    @Override
    public void save(Floracion floracion) {
        floracionRepository.save(floracion);
    }

    @Override
    public List<Floracion> consultaFloracionesPorOpcionYId(String opcion, Integer idFloracion) {
        return floracionRepository.consultaFloracionesPorOpcionYId(opcion,idFloracion);
    }


}
