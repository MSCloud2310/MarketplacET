package puj.proyecto.ms.usuarios.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import puj.proyecto.ms.usuarios.model.Usuario;

public class SecurityUser implements UserDetails{

    private final Usuario user;
    
    public SecurityUser(Usuario user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(user.getRoles().get(0));
        return user.getRoles().stream().map(SecurityAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        System.out.println(user.getPassword());

        return user.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println(user.getCorreo());

        return user.getCorreo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
