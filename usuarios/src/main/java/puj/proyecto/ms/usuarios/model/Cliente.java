package puj.proyecto.ms.usuarios.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario {
    private static String rol = "Cliente";

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="clienteMetodoPago", joinColumns = @JoinColumn(name="id_cliente"), inverseJoinColumns = @JoinColumn(name="id_metodo_pago"))
    private  List<MetodoPago> metodosPago;

    public Cliente(String nombre, String correo, String password, Integer edad, String foto, String descripcion) {
        super(nombre, correo, password, edad, foto, descripcion, rol);
    }

    public Cliente() {
    }
}

