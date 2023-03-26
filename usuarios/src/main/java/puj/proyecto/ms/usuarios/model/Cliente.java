package puj.proyecto.ms.usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario {

    public Cliente(String nombre, String correo, String password, Integer edad, String foto, String descripcion) {
        super(nombre, correo, password, edad, foto, descripcion);
    }

    public Cliente() {
    }

}

