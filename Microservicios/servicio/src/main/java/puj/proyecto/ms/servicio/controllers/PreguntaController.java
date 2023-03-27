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

import puj.proyecto.ms.servicio.model.Pregunta;
import puj.proyecto.ms.servicio.services.PreguntaService;

public class PreguntaController {
    @Autowired
    Environment environment;

    @Autowired
    private PreguntaService preguntaService;


    @GetMapping()
    public List<Pregunta> obtenerPreguntas() {
        return (List<Pregunta>) preguntaService.obtenerPreguntas();
    }

    @GetMapping("/{id}")
    public Pregunta obtenerPreguntaId(@PathVariable Long id) {
        return preguntaService.obtenerPreguntaId(id);
    }

    // http://localhost:8080/usuario/query/cliente?nombre=Mau
    // @GetMapping("/nombre/{nombre}")
    // public PaseoEcologico obtenerRedSocialNombre(@PathVariable String nombre) {
    //     return paseoEcologicoService.obtenerPaseoEcologicoNombre(nombre);
    // }

    @PostMapping()
    public Pregunta agregarPregunta(@RequestBody Pregunta pregunta) {
        return preguntaService.agregarPregunta(pregunta);
    }

    @PutMapping("/{id}")
    public Pregunta actualizarPregunta(@PathVariable Long id, @RequestBody Pregunta newPregunta) {
        return preguntaService.actualizarPregunta(id, newPregunta);
    }

    @DeleteMapping("/{id}")
    public String eliminarPregunta(@PathVariable Long id) {
        return preguntaService.eliminarPregunta(id);
    }
}
