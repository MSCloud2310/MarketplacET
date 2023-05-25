package javeriana.ms.facturacion.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @Column(name = "id_orden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    private Long idCliente;

    private Long idServicio;

    private Double total;

    // private List<Calificacion> calificaciones;

    public Orden() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId_cliente() {
        return idCliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.idCliente = id_cliente;
    }

    public Long getId_servicio() {
        return idServicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.idServicio = id_servicio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    // public List<Calificacion> getCalificaciones() {
    // return calificaciones;
    // }

    // public void setCalificaciones(List<Calificacion> calificaciones) {
    // this.calificaciones = calificaciones;
    // }

}
