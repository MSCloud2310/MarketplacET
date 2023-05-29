// package puj.proyecto.ms.usuarios.model;

// import java.util.List;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
// import puj.proyecto.ms.usuarios.utils.Roles;

// @Entity
// public class Rol {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;

// @Enumerated(EnumType.STRING)
// private Roles nombreRol;

// @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
// private List<Usuario> usuarios;

// public Rol() {
// }

// public Rol(Roles nombreRol, List<Usuario> usuarios) {
// this.nombreRol = nombreRol;
// this.usuarios = usuarios;
// }

// public Long getId() {
// return id;
// }

// public void setId(Long id) {
// this.id = id;
// }

// public Roles getRol() {
// return nombreRol;
// }

// public void setRol(Roles rol) {
// this.nombreRol = rol;
// }

// public List<Usuario> getUsuarios() {
// return usuarios;
// }

// public void setUsuarios(List<Usuario> usuarios) {
// this.usuarios = usuarios;
// }

// }