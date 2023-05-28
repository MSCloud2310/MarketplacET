package javeriana.ms.facturacion.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Orden {
    @Id
    @Column(name = "id_orden")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ordenNo;

    private String fecha;

    @JsonProperty("dias")
    private Integer numDias;

    @Transient
    private List<Servicio> listaServicios;

    @Transient
    private String nombreCliente;

    private String numeroCedula;

    @Transient
    private Integer cantidad;

    @Transient
    private BigDecimal precio;

    @JsonProperty("metodo_pago")
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orden")
    private List<OrdenItem> ordenItems;

    public Orden(String ordenNo, String fecha, List<OrdenItem> ordenItems) {
        this.ordenNo = ordenNo;
        this.fecha = fecha;
        this.ordenItems = ordenItems;
    }

    public Orden(String ordenNo, String fecha, List<Servicio> listaServicios, String nombreCliente,
            String numeroCedula) {
        this.ordenNo = ordenNo;
        this.fecha = fecha;
        this.listaServicios = listaServicios;
        this.nombreCliente = nombreCliente;
        this.numeroCedula = numeroCedula;
    }

    public Orden(String ordenNo, String fecha, List<Servicio> listaServicios, String nombreCliente, String numeroCedula,
            Integer cantidad, BigDecimal precio) {
        this.ordenNo = ordenNo;
        this.fecha = fecha;
        this.listaServicios = listaServicios;
        this.nombreCliente = nombreCliente;
        this.numeroCedula = numeroCedula;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Orden() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdenNo() {
        return ordenNo;
    }

    public void setOrdenNo(String ordenNo) {
        this.ordenNo = ordenNo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<OrdenItem> getOrdenItems() {
        return ordenItems;
    }

    public void setOrdenItems(List<OrdenItem> ordenItems) {
        this.ordenItems = ordenItems;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Integer getNumDias() {
        return numDias;
    }

    public void setNumDias(Integer numDias) {
        this.numDias = numDias;
    }

}
