package puj.proyecto.ms.usuarios.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario {
    private static String rol = "Cliente";

    private Long cedula;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "clientes")
    private List<MetodoPago> metodosPago;

    public Cliente() {

    }

    public Cliente(String nombre, String correo, String password, Integer edad, String foto, String descripcion,
            Long cedula) {
        super(nombre, correo, password, edad, foto, descripcion, rol);
        this.cedula = cedula;
    }

    public Cliente(Long cedula, List<MetodoPago> metodosPago) {
        this.cedula = cedula;
        this.metodosPago = metodosPago;
    }

    public Cliente(String nombre, String correo, String password, Integer edad, String foto, String descripcion,
            String rol, Long cedula, List<MetodoPago> metodosPago) {
        super(nombre, correo, password, edad, foto, descripcion, rol);
        this.cedula = cedula;
        this.metodosPago = metodosPago;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public List<MetodoPago> getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(List<MetodoPago> metodosPago) {
        this.metodosPago = metodosPago;
    }

}
