package com.javeriana.servidorsoap.repository;

import com.proyecto.ecoturist.servicio.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IServicioRepository extends CrudRepository<Servicio, Long> {

}
