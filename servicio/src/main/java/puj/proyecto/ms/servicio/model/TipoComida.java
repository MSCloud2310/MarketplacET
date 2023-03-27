package puj.proyecto.ms.servicio.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipoComida {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoComida")
    private List<Alimentacion> alimentacion;

    public TipoComida(String nombre) {
        this.nombre = nombre;
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

    public List<Alimentacion> getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(List<Alimentacion> alimentacion) {
        this.alimentacion = alimentacion;
    }

    public TipoComida() {
    }

    
}
