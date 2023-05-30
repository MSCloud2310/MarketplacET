package puj.proyecto.ms.servicio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pregunta {
    @Id
    @Column(name = "id_calificacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pregunta;
    private String respuesta;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private Servicio servicio;
    private Long id_usuario;
    
    public Pregunta(String pregunta, String respuesta, Servicio servicio, Long id_usuario) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.servicio = servicio;
        this.id_usuario = id_usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

}