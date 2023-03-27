package puj.proyecto.ms.usuarios.controllers;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.proyecto.ms.usuarios.model.MetodoPago;
import puj.proyecto.ms.usuarios.services.MetodoPagoService;

@RestController
@RequestMapping("/metodo-pago")
public class MetodoPagoController {
    @Autowired
    Environment environment;
    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping()
    public List<MetodoPago> obtenerMetodosPago() {
        return (List<MetodoPago>) metodoPagoService.obtenerMetodosPago();
    }

    @GetMapping("/{id}")
    public MetodoPago obtenerMetodoPagoId(@PathVariable Long id) {
        return metodoPagoService.obtenerMetodoPagoId(id);
    }

    // http://localhost:8080/usuario/query/cliente?nombre=Mau
    @GetMapping("/nombre/{nombre}")
    public MetodoPago obtenerMetodoPagoNombre(@PathVariable String nombre) {
        return metodoPagoService.obtenerMetodoPagoNombre(nombre);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MetodoPago agregarMetodoPago(@RequestBody MetodoPago redSocial) {
        return metodoPagoService.agregarMetodoPago(redSocial);
    }

    @PutMapping("/{id}")
    public MetodoPago actualizarMetodoPago(@PathVariable Long id, @RequestBody MetodoPago newRedSocial) {
        return metodoPagoService.actualizarMetodoPago(id, newRedSocial);
    }

    @DeleteMapping("/{id}")
    public String eliminarMetodoPago(@PathVariable Long id) {
        return metodoPagoService.eliminarMetodoPago(id);
    }
}
