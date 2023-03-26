package puj.proyecto.ms.servicio.controllers;

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

import puj.proyecto.ms.servicio.model.Servicio;
import puj.proyecto.ms.servicio.repository.ServicioRepository;

@RestController
@RequestMapping()
public class ServicioController {

    @Autowired
    Environment environment;

    @Autowired
    private ServicioRepository servicioRepository;  
    
    @GetMapping("/servicio/{id}")
    public Servicio obtenerUsuario(@PathVariable Long id) {
        return servicioRepository.findById(id).orElseThrow();
    }
    
    @PostMapping("/agregar/servicio")
    public Servicio agregarProveedor(@RequestBody Servicio proveedor) {
        return servicioRepository.save(proveedor);
    }

    @PutMapping("/actualizar/servicio/{id}")
    public Servicio actualizaLibro(@PathVariable Long id, @RequestBody Servicio newServicio) {
        Servicio servicio = servicioRepository.findById(id).orElseThrow();
        
        // servicio.setNombre(newServicio.getNombre());
        // servicio.setPrecio(newServicio.getPrecio());
        // servicio.setProveedor(newServicio.getProveedor());
        // servicio.setDescripcion(newServicio.getDescripcion());
        // servicio.setLugar(newServicio.getLugar());

        return servicioRepository.save(servicio);
    }

    @DeleteMapping("/eliminar/servicio/{id}")
    public void eliminarProveedor(@PathVariable Long id) {
        servicioRepository.deleteById(id);
    }
}