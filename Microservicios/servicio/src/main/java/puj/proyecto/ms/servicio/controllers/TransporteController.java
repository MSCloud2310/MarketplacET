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

import puj.proyecto.ms.servicio.model.Transporte;
import puj.proyecto.ms.servicio.services.TransporteService;

@RestController
@RequestMapping("/transporte")
public class TransporteController {
    @Autowired
    Environment environment;

    @Autowired
    private TransporteService transporteService;


    @GetMapping()
    public List<Transporte> obtenerAlojamientos() {
        return (List<Transporte>) transporteService.obtenerTransportes();
    }

    @GetMapping("/{id}")
    public Transporte obtenerAlojamientoId(@PathVariable Long id) {
        return transporteService.obtenerTransporteId(id);
    }

    // http://localhost:8080/usuario/query/cliente?nombre=Mau
    // @GetMapping("/nombre/{nombre}")
    // public PaseoEcologico obtenerRedSocialNombre(@PathVariable String nombre) {
    //     return paseoEcologicoService.obtenerPaseoEcologicoNombre(nombre);
    // }

    @PostMapping("/tipo-transporte/{id}")
    public Transporte agregarTransporte(@RequestBody Transporte transporte, @PathVariable Long id) {
        return transporteService.agregarTransporte(transporte, id);
    }

    @PutMapping("/{id}")
    public Transporte actualizarAlojamiento(@PathVariable Long id, @RequestBody Transporte newTransporte) {
        return transporteService.actualizarTransporte(id, newTransporte);
    }

    @DeleteMapping("/{id}")
    public String eliminarAlojamiento(@PathVariable Long id) {
        return transporteService.eliminarTransporte(id);
    }
}

