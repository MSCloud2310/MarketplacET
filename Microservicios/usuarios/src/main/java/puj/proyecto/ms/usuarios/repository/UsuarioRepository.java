package puj.proyecto.ms.usuarios.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.proyecto.ms.usuarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public abstract Optional<Usuario> findByCorreo(String correo);

    public abstract List<Usuario> findByRol(String rol);

    public abstract Usuario findByNombreAndPassword(String nombre, String password);

    public abstract Usuario findByIdAndPassword (Long id, String password);
}
