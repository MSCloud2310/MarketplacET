package puj.proyecto.ms.servicio.model;

import jakarta.persistence.Entity;

@Entity
public class PaseoEcologico extends Servicio {
    private static Integer codigo = 1;
    private String origen;
    private String destino;
    private String fecha_salida;
    private String fecha_llegada;
    private String guia_turistico;
    private String recomendaciones;

    public PaseoEcologico() {
    }

    public PaseoEcologico(String nombre, Double precio, String descripcion, Boolean disponibilidad,
            Integer stock, String foto, String origen, String destino, String fecha_salida, String fecha_llegada,
            String guia_turistico, String recomendaciones) {
        super(codigo, nombre, precio, descripcion, disponibilidad, stock, foto);
        this.origen = origen;
        this.destino = destino;
        this.fecha_salida = fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.guia_turistico = guia_turistico;
        this.recomendaciones = recomendaciones;
    }

    public PaseoEcologico(String origen, String destino, String fecha_salida, String fecha_llegada,
            String guia_turistico, String recomendaciones) {
        this.origen = origen;
        this.destino = destino;
        this.fecha_salida = fecha_salida;
        this.fecha_llegada = fecha_llegada;
        this.guia_turistico = guia_turistico;
        this.recomendaciones = recomendaciones;
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

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(String fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public String getGuia_turistico() {
        return guia_turistico;
    }

    public void setGuia_turistico(String guia_turistico) {
        this.guia_turistico = guia_turistico;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

}
