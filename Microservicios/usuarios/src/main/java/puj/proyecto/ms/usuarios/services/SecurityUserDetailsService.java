// package puj.proyecto.ms.usuarios.services;

// import java.util.Optional;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import puj.proyecto.ms.usuarios.model.Usuario;
// import puj.proyecto.ms.usuarios.repository.UsuarioRepository;
// import puj.proyecto.ms.usuarios.security.SecurityUser;

// // @Service
// public class SecurityUserDetailsService implements UserDetailsService {

// private final UsuarioRepository usuarioRepository;

// public SecurityUserDetailsService(UsuarioRepository usuarioRepository) {
// this.usuarioRepository = usuarioRepository;
// }

// @Override
// public UserDetails loadUserByUsername(String correo) throws
// UsernameNotFoundException {

// System.out.println("desde userDetails servide");
// Optional<Usuario> user = this.usuarioRepository.findByCorreo("mau@riv.com");

// System.out.println(user.get().getNombre());

// if (user.isPresent()) {
// return new SecurityUser(user.get());
// }
// throw new UsernameNotFoundException("User not found");
// }
// }
