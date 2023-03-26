package puj.proyecto.ms.usuarios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "redes_sociales")
public class RedSocial {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String url;

    @JsonIgnore
    @ManyToOne
    private Proveedor proveedor;

    public RedSocial() {

    }

    public RedSocial(Long id, String nombre, String url, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.proveedor = proveedor;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}
