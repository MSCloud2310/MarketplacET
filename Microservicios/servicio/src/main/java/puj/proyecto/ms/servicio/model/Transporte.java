package puj.proyecto.ms.servicio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity

public class Transporte extends Servicio {
    private String origen;
    private String hora_inicio;
    private String hora_fin;

    @JsonProperty("tipo_transporte")
    @Enumerated(EnumType.STRING)
    private TipoTransporte tipoTransporte;


    public Transporte() {

    }

    public Transporte(String origen, String hora_inicio, String hora_fin,
            TipoTransporte tipoTransporte) {
        this.origen = origen;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.tipoTransporte = tipoTransporte;
    }

    public Transporte(String nombre, Double precio, String descripcion, Boolean disponibilidad, Integer stock,
            String foto, String categoria, String direccion, String pais, String ciudad, String latitud,
            String longitud, String lenguaje, String clima, String codigoPostal) {
        super(nombre, precio, descripcion, disponibilidad, stock, foto, categoria, direccion, pais, ciudad, latitud,
                longitud, lenguaje, clima, codigoPostal);
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

}
