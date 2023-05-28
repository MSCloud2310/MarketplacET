package puj.proyecto.ms.usuarios.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String correo;
    @NotNull
    private String password;
    private Integer edad;
    private String foto;
    private String descripcion;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<Rol> roles;

    public Usuario() {

    }

    public Usuario(String nombre, String correo, String password, Integer edad, String foto,
            String descripcion) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.edad = edad;
        this.foto = foto;
        this.descripcion = descripcion;
        //this.rol = rol;
    }

    public Usuario(Long id, @NotNull String nombre, @NotNull String correo, @NotNull String password, Integer edad,
            String foto, String descripcion, List<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.edad = edad;
        this.foto = foto;
        this.descripcion = descripcion;
        //this.rol = rol;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // public String getRol() {
    //     return rol;
    // }

    // public void setRol(String rol) {
    //     this.rol = rol;
    // }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", correo=" + correo + ", edad=" + edad
                + ", descripcion=" + descripcion + "]";
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

}
