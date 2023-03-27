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

import puj.proyecto.ms.servicio.model.TipoComida;
import puj.proyecto.ms.servicio.services.TipoComidaService;

@RestController
@RequestMapping("/tipo-comida")
public class TipoComidaController {
    @Autowired
    Environment environment;

    @Autowired
    private TipoComidaService tipoComidaService;


    @GetMapping()
    public List<TipoComida> obtenerTiposComida() {
        return (List<TipoComida>) tipoComidaService.obtenerTiposComida();
    }

    @GetMapping("/{id}")
    public TipoComida obtenerTipoComidaId(@PathVariable Long id) {
        return tipoComidaService.obtenerTipoComidaId(id);
    }

    // http://localhost:8080/usuario/query/cliente?nombre=Mau
    // @GetMapping("/nombre/{nombre}")
    // public PaseoEcologico obtenerRedSocialNombre(@PathVariable String nombre) {
    //     return paseoEcologicoService.obtenerPaseoEcologicoNombre(nombre);
    // }

    @PostMapping()
    public TipoComida agregarTipoComida(@RequestBody TipoComida tipoComida) {
        return tipoComidaService.agregarTipoComida(tipoComida);
    }

    @PutMapping("/{id}")
    public TipoComida actualizarTipoComida(@PathVariable Long id, @RequestBody TipoComida newTipoComida) {
        return tipoComidaService.actualizarTipoComida(id, newTipoComida);
    }

    @DeleteMapping("/{id}")
    public String eliminarTipoComida(@PathVariable Long id) {
        return tipoComidaService.eliminarTipoComida(id);
    }
}
