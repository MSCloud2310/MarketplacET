package puj.proyecto.ms.servicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.proyecto.ms.servicio.model.Calificacion;
import puj.proyecto.ms.servicio.services.CalificacionService;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {

    @Autowired
    CalificacionService calificacionService;

   @GetMapping("/cliente/{id}")
    public List<Calificacion> obtenerCalificacionesCliente(@PathVariable Long id) {
        return calificacionService.obtenerCalificacionesCliente(id);
    } 

    @GetMapping("/servicio/{id}")
    public List<Calificacion> obtenerCalificacionesServicio(@PathVariable Long id) {
        return calificacionService.obtenerCalificacionesCliente(id);
    } 

    @PostMapping()
    public Calificacion calificarServicio(@RequestBody Calificacion calificacion) {
        return calificacionService.guardarCalificacion(calificacion);
    }

    @PutMapping("/servicio/{id}")
    public String calificarServicio(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        return calificacionService.actualizarCalificacion(id, calificacion);
    }
}