package javeriana.ms.facturacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Servicio {
    private Long id;
    private String nombre;

    private String categoria;

    public Servicio() {
    }

    public Servicio(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Servicio [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + "]";
    }

}