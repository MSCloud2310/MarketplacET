package puj.proyecto.ms.servicio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
@Entity

public class Transporte extends Servicio {
    private static String categoria = "Transporte";
    private String origen;
    private String destino;
    private String hora_inicio;
    private String hora_fin;

    @JsonIgnore
    @ManyToOne
    private TipoTransporte tipoTransporte;

    public Transporte(){
        
    }
 
    public Transporte(String origen, String destino, String hora_inicio, String hora_fin,
            TipoTransporte tipoTransporte) {
        this.origen = origen;
        this.destino = destino;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.tipoTransporte = tipoTransporte;
    }

    public Transporte(String nombre, Double precio, String descripcion, Boolean disponibilidad, Integer stock,
            String foto, String origen, String destino, String hora_inicio, String hora_fin,
            TipoTransporte tipoTransporte) {
        super(nombre, precio, descripcion, disponibilidad, stock, foto, categoria);
        this.origen = origen;
        this.destino = destino;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.tipoTransporte = tipoTransporte;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
