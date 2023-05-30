package puj.proyecto.ms.servicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.proyecto.ms.servicio.model.Calificacion;
import puj.proyecto.ms.servicio.model.Servicio;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion,Long> {

    public abstract List<Calificacion> findByCliente(Long id_cliente);

    public abstract List<Calificacion> findByServicio(Long servicio);
    
}
