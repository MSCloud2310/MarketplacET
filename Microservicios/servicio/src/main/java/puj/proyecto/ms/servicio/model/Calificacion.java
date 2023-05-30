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

    private Long servicio;
    private Long cliente;

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

    public Long getServicio() {
        return servicio;
    }

    public void setServicio(Long servicio) {
        this.servicio = servicio;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Calificacion [id=" + id + ", estrellas=" + estrellas + ", comentario=" + comentario + ", servicio="
                + servicio + ", id_cliente=" + cliente + "]";
    }

}
