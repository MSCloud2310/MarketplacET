package puj.proyecto.ms.servicio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import puj.proyecto.ms.servicio.model.PaseoEcologico;

@Repository
public interface PaseoEcologicoRepository extends CrudRepository<PaseoEcologico, Long> {
    
}