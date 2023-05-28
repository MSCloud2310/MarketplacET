package puj.proyecto.ms.usuarios.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "red_social")
public class RedSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String url;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private Proveedor proveedor;

    // @ManyToMany(cascade = CascadeType.ALL)
    // @JsonBackReference
    // @JoinTable(name = "proveedor_RedesSociales", joinColumns = @JoinColumn(name =
    // "redSocial_id"), inverseJoinColumns = @JoinColumn(name = "proveedor_id"))
    // private List<Proveedor> proveedores;

    public RedSocial() {
    }

    public RedSocial(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
