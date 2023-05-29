package puj.proyecto.ms.servicio.model;

import jakarta.persistence.Entity;

@Entity
public class Alojamiento extends Servicio {
    private String fecha_inicio;
    private String fecha_fin;
    private Integer cantidad_personas;

    public Alojamiento() {

    }

    public Alojamiento(String fecha_inicio, String fecha_fin, Integer cantidad_personas) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.cantidad_personas = cantidad_personas;
    }

    public Alojamiento(String nombre, Double precio, String descripcion, Boolean disponibilidad, Integer stock,
            String foto, String categoria, String direccion, String pais, String ciudad, String moneda,
            Long proveedorId, String latitud, String longitud, String lenguaje, String clima, String continente) {
        super(nombre, precio, descripcion, disponibilidad, stock, foto, categoria, direccion, pais, ciudad, moneda,
                proveedorId, latitud, longitud, lenguaje, clima, continente);
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(Integer cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

}
