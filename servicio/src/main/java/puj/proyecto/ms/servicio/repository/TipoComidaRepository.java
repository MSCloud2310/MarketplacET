package puj.proyecto.ms.servicio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import puj.proyecto.ms.servicio.model.TipoComida;

@Repository
public interface TipoComidaRepository extends CrudRepository<TipoComida, Long> {
    
}