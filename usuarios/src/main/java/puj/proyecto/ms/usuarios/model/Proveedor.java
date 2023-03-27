package puj.proyecto.ms.usuarios.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor extends Usuario {
    private Long telefono;
    private String pagina_web;
    private static String rol = "Proveedor";

    @JsonIgnore
    @OneToMany(mappedBy = "proveedor")
    private List<RedSocial> redes_sociales;

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public List<RedSocial> getRedes_sociales() {
        return redes_sociales;
    }

    public void setRedes_sociales(List<RedSocial> redes_sociales) {
        this.redes_sociales = redes_sociales;
    }

    public Proveedor(String nombre, String correo, String password, Integer edad, String foto, String descripcion,
            Long telefono, String pagina_web) {
        super(nombre, correo, password, edad, foto, descripcion, rol);
        this.telefono = telefono;
        this.pagina_web = pagina_web;
    }

    public Proveedor() {

    }
}