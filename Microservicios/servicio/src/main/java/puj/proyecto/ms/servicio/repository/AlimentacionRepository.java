package puj.proyecto.ms.servicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.proyecto.ms.servicio.model.Alimentacion;

@Repository
public interface AlimentacionRepository extends JpaRepository<Alimentacion, Long> {
    
}