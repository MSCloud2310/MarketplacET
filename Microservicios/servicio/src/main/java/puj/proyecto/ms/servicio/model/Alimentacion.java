package puj.proyecto.ms.servicio.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Alimentacion extends Servicio {
    @JsonProperty("tipo_comida")
    @Enumerated(EnumType.STRING)
    private TipoComida tipoComida;

    public Alimentacion() {
    }

    public Alimentacion(String descripcion, TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

    public Alimentacion(String nombre, Double precio, String descripcion, Boolean disponibilidad, Integer stock,
            String foto, String categoria, String direccion, String pais, String ciudad, String moneda,
            Long proveedorId, String latitud, String longitud, String lenguaje, String clima, String codigoPostal) {
        super(nombre, precio, descripcion, disponibilidad, stock, foto, categoria, direccion, pais, ciudad, moneda,
                proveedorId, latitud, longitud, lenguaje, clima, codigoPostal);
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

    public Alimentacion(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

}
