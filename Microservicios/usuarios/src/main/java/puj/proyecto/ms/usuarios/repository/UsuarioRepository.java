package puj.proyecto.ms.usuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.proyecto.ms.usuarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public abstract List<Usuario> findByRol(String nombre);
    public abstract Usuario findByNombreAndPassword(String nombre, String password);
}
