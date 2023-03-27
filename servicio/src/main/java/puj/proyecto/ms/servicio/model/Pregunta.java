package puj.proyecto.ms.servicio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pregunta {
    @Id
    @GeneratedValue
    private Long id;

    private String contenido;
    private String respuesta;

    public Pregunta(String contenido, String respuesta) {
        this.contenido = contenido;
        this.respuesta = respuesta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
