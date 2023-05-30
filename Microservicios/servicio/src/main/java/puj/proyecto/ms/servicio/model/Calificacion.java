package puj.proyecto.ms.servicio.model;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Calificacion {
    @Id
    @Column(name = "id_calificacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int estrellas;
    private String comentario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private Servicio servicio;
    private Long id_cliente;

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

}
