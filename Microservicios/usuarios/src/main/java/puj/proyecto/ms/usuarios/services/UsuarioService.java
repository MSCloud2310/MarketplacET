package puj.proyecto.ms.usuarios.services;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.usuarios.model.Usuario;
import puj.proyecto.ms.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioId(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    public List<Usuario> findByRol(String rol) {
        return usuarioRepository.findByRol(rol);
    }

    public Optional<Usuario> findByCorreo(String nombre) {
        return usuarioRepository.findByCorreo(nombre);
    }

    public Usuario agregarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarCliente(Long id, Usuario newUsuario) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setNombre(newUsuario.getNombre());
        usuario.setCorreo(newUsuario.getCorreo());
        usuario.setPassword(newUsuario.getPassword());
        usuario.setEdad(newUsuario.getEdad());
        usuario.setFoto(newUsuario.getFoto());
        usuario.setDescripcion(newUsuario.getDescripcion());

        return usuarioRepository.save(usuario);
    }

    public String eliminarCliente(Long id) {
        usuarioRepository.deleteById(id);
        return "El cliente con " + id + " ha sido eliminado satisfactoriamente.";
    }

    public String login(Usuario user) {
        try {
            Usuario userExits = usuarioRepository.findByIdAndPassword(user.getId(),
                    user.getPassword());
            return userExits.getRol();
        } catch (Exception e) {
            return "no existe";
        }
    }
}
