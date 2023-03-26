package puj.proyecto.ms.servicio.controllers;

import java.util.List;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.proyecto.ms.servicio.model.Alojamiento;
import puj.proyecto.ms.servicio.services.AlojamientoService;

@RestController
@RequestMapping("/alojamiento")
public class AlojamientoController {
    @Autowired
    Environment environment;

    @Autowired
    private AlojamientoService alojamientoService;


    @GetMapping()
    public List<Alojamiento> obtenerAlojamientos() {
        return (List<Alojamiento>) alojamientoService.obtenerAlojamientos();
    }

    @GetMapping("/{id}")
    public Alojamiento obtenerAlojamientoId(@PathVariable Long id) {
        return alojamientoService.obtenerAlojamientoId(id);
    }

    // http://localhost:8080/usuario/query/cliente?nombre=Mau
    // @GetMapping("/nombre/{nombre}")
    // public PaseoEcologico obtenerRedSocialNombre(@PathVariable String nombre) {
    //     return paseoEcologicoService.obtenerPaseoEcologicoNombre(nombre);
    // }

    @PostMapping()
    public Alojamiento agregarAlojamiento(@RequestBody Alojamiento alojamiento) {
        return alojamientoService.agregarAlojamiento(alojamiento);
    }

    @PutMapping("/{id}")
    public Alojamiento actualizarAlojamiento(@PathVariable Long id, @RequestBody Alojamiento newAlojamiento) {
        return alojamientoService.actualizarAlojamiento(id, newAlojamiento);
    }

    @DeleteMapping("/{id}")
    public String eliminarAlojamiento(@PathVariable Long id) {
        return alojamientoService.eliminarAlojamiento(id);
    }
}
