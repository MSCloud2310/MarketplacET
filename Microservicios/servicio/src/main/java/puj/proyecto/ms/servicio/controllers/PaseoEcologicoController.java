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

import puj.proyecto.ms.servicio.model.PaseoEcologico;
import puj.proyecto.ms.servicio.services.PaseoEcologicoService;

@RestController
@RequestMapping("/paseo-ecologico")
public class PaseoEcologicoController {
    @Autowired
    Environment environment;

    @Autowired
    private PaseoEcologicoService paseoEcologicoService;


    @GetMapping()
    public List<PaseoEcologico> obtenerPaseosEcologicos() {
        return (List<PaseoEcologico>) paseoEcologicoService.obtenerPaseosEcologicos();
    }

    @GetMapping("/{id}")
    public PaseoEcologico obtenerPaseoEcologicoId(@PathVariable Long id) {
        return paseoEcologicoService.obtenerPaseoEcologicoId(id);
    }

    // http://localhost:8080/usuario/query/cliente?nombre=Mau
    // @GetMapping("/nombre/{nombre}")
    // public PaseoEcologico obtenerRedSocialNombre(@PathVariable String nombre) {
    //     return paseoEcologicoService.obtenerPaseoEcologicoNombre(nombre);
    // }

    @PostMapping()
    public PaseoEcologico agregarPaseoEcologico(@RequestBody PaseoEcologico paseoEcologico) {
        return paseoEcologicoService.agregarPaseoEcologico(paseoEcologico);
    }

    @PutMapping("/{id}")
    public PaseoEcologico actualizarPaseoEcologico(@PathVariable Long id, @RequestBody PaseoEcologico newPaseoEcologico) {
        return paseoEcologicoService.actualizarPaseoEcologico(id, newPaseoEcologico);
    }

    @DeleteMapping("/{id}")
    public String eliminarPaseoEcologico(@PathVariable Long id) {
        return paseoEcologicoService.eliminarPaseoEcologico(id);
    }
}
