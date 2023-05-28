package puj.proyecto.ms.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import puj.proyecto.ms.usuarios.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByNombreRol(String nombreRol);
}
