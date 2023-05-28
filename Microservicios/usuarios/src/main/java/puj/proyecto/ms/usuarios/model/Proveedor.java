package puj.proyecto.ms.usuarios.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor extends Usuario {
    private Long telefono;
    private String pagina_web;


    // @ManyToMany(cascade = CascadeType.ALL, mappedBy = "proveedores")
    // private List<RedSocial> redesSociales;
    @OneToMany(mappedBy = "proveedor", cascade=CascadeType.ALL)
    private List<RedSocial> redes_sociales = new ArrayList<>();


    public Proveedor() {

    }

    public Proveedor(String nombre, String correo, String password, Integer edad, String foto, String descripcion,
            String rol, Long telefono, String pagina_web, List<RedSocial> redes_sociales) {
        super(nombre, correo, password, edad, foto, descripcion, rol);
        this.telefono = telefono;
        this.pagina_web = pagina_web;
        this.redes_sociales = redes_sociales;
    }

    public Proveedor(String nombre, String correo, String password, Integer edad, String foto, String descripcion,
            String rol, Long telefono, String pagina_web) {
        super(nombre, correo, password, edad, foto, descripcion, rol);
        this.telefono = telefono;
        this.pagina_web = pagina_web;
    }

    public List<RedSocial> getRedes_sociales() {
        return redes_sociales;
    }

    public void setRedes_sociales(List<RedSocial> redes_sociales) {
        this.redes_sociales = redes_sociales;
    }

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

}