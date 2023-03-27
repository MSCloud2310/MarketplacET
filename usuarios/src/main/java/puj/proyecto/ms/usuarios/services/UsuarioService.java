package puj.proyecto.ms.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.usuarios.model.Usuario;
import puj.proyecto.ms.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioId(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    public List<Usuario> findByRol(String nombre) {
        return usuarioRepository.findByRol(nombre);
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
}
