package com.javeriana.servidorsoap.repository;

import com.proyecto.ecoturist.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
//@Component
//@Transactional
public class ServicioRepositoryImpl implements IServicioOperaciones {

    private IServicioRepository repository;

    public ServicioRepositoryImpl() {
    }

    @Autowired
    public ServicioRepositoryImpl(IServicioRepository servicioRepository) {
        this.repository = servicioRepository;
    }

    @Override
    public Servicio getServicioById(Long id) {
        return repository.findById(id).get();
    }
}
