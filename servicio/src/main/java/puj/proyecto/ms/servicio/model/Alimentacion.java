package puj.proyecto.ms.servicio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Alimentacion extends Servicio {
    private static String categoria = "Alimentacion";

    @JsonIgnore
    @ManyToOne
    private TipoComida tipoComida;


    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

    public Alimentacion( TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

    public Alimentacion(String nombre, Double precio, String descripcion, Boolean disponibilidad, Integer stock,
            String foto, TipoComida tipoComida) {
        super(nombre, precio, descripcion, disponibilidad, stock, foto, categoria);
        this.tipoComida = tipoComida;
    }    
    
    public Alimentacion(){
        
    }
}
