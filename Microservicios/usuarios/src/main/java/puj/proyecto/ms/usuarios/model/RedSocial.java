package puj.proyecto.ms.usuarios.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "redSocial")
public class RedSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "redSocial_id")
    private Long id;

    private String nombre;
    private String url;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "proveedor_RedesSociales", joinColumns = @JoinColumn(name = "redSocial_id"), inverseJoinColumns = @JoinColumn(name = "proveedor_id"))
    private List<Proveedor> proveedores;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
