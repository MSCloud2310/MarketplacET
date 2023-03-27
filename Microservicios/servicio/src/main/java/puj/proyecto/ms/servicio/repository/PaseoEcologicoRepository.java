package puj.proyecto.ms.servicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.proyecto.ms.servicio.model.PaseoEcologico;

@Repository
public interface PaseoEcologicoRepository extends JpaRepository<PaseoEcologico, Long> {
    
}