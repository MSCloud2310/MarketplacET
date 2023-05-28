package puj.proyecto.ms.usuarios.model;

import jakarta.persistence.Entity;


@Entity
public class Cliente extends Usuario {
    private Long cedula;

    public Cliente() {

    }

    public Cliente(String nombre, String correo, String password, Integer edad, String foto, String descripcion,
            String rol, Long cedula) {
        super(nombre, correo, password, edad, foto, descripcion, rol);
        this.cedula = cedula;
    }

    public Cliente(Long cedula) {
        this.cedula = cedula;

    }


    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

}
