package javeriana.ms.facturacion.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javeriana.ms.facturacion.model.Orden;
import javeriana.ms.facturacion.service.OrdenService;

@RestController
@RequestMapping("/orden")
public class FacturacionController {
    @Autowired
    Environment environment;

    @Autowired
    private OrdenService ordenService;

    @GetMapping()
    public List<Orden> obtenerOrdenes() {
        return ordenService.obtenerOrdenes();
    }

    @GetMapping("/{id}")
    public Orden obtenerOrdenById(@PathVariable Long id) {
        return ordenService.obtenerOrdenById(id);
    }

    @GetMapping("/{id}/clima")
    public String obtenerClimaById(@PathVariable Long id) {
        return ordenService.obtenerClimaById(id);
    }

    @GetMapping("/cliente/{cedula}")
    public List<Orden> obtenerOrdenByCustomer(@PathVariable String cedula) {
        return ordenService.obtenerOrdenByCustomer(cedula);
    }

    @PostMapping()
    public Orden crearOrden(@RequestBody Orden orden) throws UnsupportedEncodingException {
        return ordenService.crearOrden(orden);
    }

    @PutMapping("/{id}")
    public Orden actualizarOrden(@PathVariable Long id, @RequestBody Orden newOrden) {
        return ordenService.actualizarOrden(id, newOrden);
    }
    // return null;

    @DeleteMapping("/{id}")
    public String eliminarOrden(@PathVariable Long id) {
        return ordenService.eliminarOrden(id);
    }

}