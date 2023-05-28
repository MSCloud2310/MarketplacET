package puj.proyecto.ms.servicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.proyecto.ms.servicio.model.Alimentacion;
import puj.proyecto.ms.servicio.services.AlimentacionService;

@RestController
@RequestMapping("/alimentacion")
public class AlimentacionController {
    @Autowired
    Environment environment;

    @Autowired
    private AlimentacionService alimentacionService;

    @GetMapping()
    public List<Alimentacion> obtenerAlimentacion() {
        return alimentacionService.obtenerAlimentacion();
    }

    @GetMapping("/{id}")
    public Alimentacion obtenerAlimentacionId(@PathVariable Long id) {
        return alimentacionService.obtenerAlimentacionId(id);
    }

    @PostMapping("/tipo-comida/{id}")
    public Alimentacion agregarAlimentacion(@RequestBody Alimentacion alimentacion) {
        return alimentacionService.agregarAlimentacion(alimentacion);
    }

    @PutMapping("/{id}")
    public Alimentacion actualizarAlojamiento(@PathVariable Long id, @RequestBody Alimentacion newAlimentacion) {
        return alimentacionService.actualizarAlimentacion(id, newAlimentacion);
    }

    @DeleteMapping("/{id}")
    public String eliminarAlimentacion(@PathVariable Long id) {
        return alimentacionService.eliminarAlimentacion(id);
    }
}
