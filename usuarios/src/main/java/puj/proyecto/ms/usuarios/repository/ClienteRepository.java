package puj.proyecto.ms.usuarios.repository;

import org.springframework.stereotype.Repository;

import puj.proyecto.ms.usuarios.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    public abstract Cliente findByNombre(String nombre);
    
}
