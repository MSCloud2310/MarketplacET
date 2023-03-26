package puj.proyecto.ms.usuarios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import puj.proyecto.ms.usuarios.model.MetodoPago;

@Repository
public interface MetodoPagoRepository extends CrudRepository<MetodoPago, Long>{

    public abstract MetodoPago findByNombre(String nombre);
}
