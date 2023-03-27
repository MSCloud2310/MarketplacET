package puj.proyecto.ms.servicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.proyecto.ms.servicio.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Long> {
    public abstract List<Servicio> findByCategoria(String categoria);   
}