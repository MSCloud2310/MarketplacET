package puj.proyecto.ms.servicio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @Column(name = "id_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private Boolean disponibilidad;
    private Integer stock;
    private String foto;
    private String categoria;
    private String direccion;
    private String pais;
    private String ciudad;
    private String moneda;
    private Long proveedorId;
    private String latitud;
    private String longitud;
    private String lenguaje;
    private String clima;
    private String continente;

    public Servicio() {
    }

    public Servicio(String nombre, Double precio, String descripcion, Boolean disponibilidad, Integer stock,
            String foto, String categoria, String direccion, String pais, String ciudad, String moneda,
            Long proveedorId, String latitud, String longitud, String lenguaje, String clima, String continente) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.stock = stock;
        this.foto = foto;
        this.categoria = categoria;
        this.direccion = direccion;
        this.pais = pais;
        this.ciudad = ciudad;
        this.moneda = moneda;
        this.proveedorId = proveedorId;
        this.latitud = latitud;
        this.longitud = longitud;
        this.lenguaje = lenguaje;
        this.clima = clima;
        this.continente = continente;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public Long getId_proveedor() {
        return proveedorId;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.proveedorId = id_proveedor;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public String toString() {
        return "Servicio [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
                + ", disponibilidad=" + disponibilidad + ", stock=" + stock + ", foto=" + foto + ", categoria="
                + categoria + ", direccion=" + direccion + ", pais=" + pais + ", ciudad=" + ciudad + ", moneda="
                + moneda + ", proveedorId=" + proveedorId + ", latitud=" + latitud + ", longitud=" + longitud
                + ", lenguaje=" + lenguaje + ", clima=" + clima + ", continente=" + continente + "]";
    }
}