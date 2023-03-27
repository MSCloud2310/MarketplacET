package puj.proyecto.ms.servicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.proyecto.ms.servicio.model.Alimentacion;
import puj.proyecto.ms.servicio.model.Alojamiento;
import puj.proyecto.ms.servicio.model.PaseoEcologico;
import puj.proyecto.ms.servicio.model.Servicio;
import puj.proyecto.ms.servicio.model.Transporte;
import puj.proyecto.ms.servicio.services.ServicioService;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    Environment environment;

    @Autowired
    private ServicioService servicioService;  

    @Autowired
    private AlojamientoController alojamientoController;  

    @Autowired
    private PaseoEcologicoController paseoEcologicoController;  
    
    @Autowired
    private AlimentacionController alimentacionController;  

    @Autowired
    private TransporteController transporteController;  
    @GetMapping()
    public List<Servicio> obtenerServicios() {
        return servicioService.obtenerServicios();
    }

    @GetMapping("/{id}")
    public Servicio obtenerServicioId(@PathVariable Long id) {
        return servicioService.obtenerServicioId(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Servicio> obtenerServicioCategoria(@PathVariable String categoria) {
        return servicioService.obtenerServicioCategoria(categoria);
    }
    @GetMapping("/buscar/{cadena}")
    public List<Servicio> obtenerServicioTexto(@PathVariable String cadena) {
        return servicioService.obtenerServicioTexto(cadena);
    }

    @PostMapping("/agregar-alojamiento")
    public Servicio agregarAlojamiento(@RequestBody Alojamiento alojamiento) {
        return alojamientoController.agregarAlojamiento(alojamiento);
    }

    @PostMapping("/agregar-paseo-ecologico")
    public Servicio agregarPaseoEcologico(@RequestBody PaseoEcologico paseoEcologico) {
        return paseoEcologicoController.agregarPaseoEcologico(paseoEcologico);
    }

    @PostMapping("/agregar-alimentacion/tipo/{id}")
    public Servicio agregarAlimentacion(@RequestBody Alimentacion alimentacion,@PathVariable Long id ) {
        return alimentacionController.agregarAlimentacion(alimentacion, id);
    }

    @PostMapping("/agregar-transporte/tipo/{id}")
    public Servicio agregarTransporte(@RequestBody Transporte transporte,@PathVariable Long id) {
        return transporteController.agregarTransporte(transporte, id);
    }

    @PostMapping("/agregar/servicio")
    public Servicio agregarServicio(@RequestBody Servicio proveedor) {
        return servicioService.agregarServicio(proveedor);
    }

    // @PutMapping("/actualizar/servicio/{id}")
    // public Servicio actualizaServicio(@PathVariable Long id, @RequestBody Servicio newServicio) {
    //     Servicio servicio = servicioService.obtenerServicioId(id).orElseThrow();
        
    //     // servicio.setNombre(newServicio.getNombre());
    //     // servicio.setPrecio(newServicio.getPrecio());
    //     // servicio.setProveedor(newServicio.getProveedor());
    //     // servicio.setDescripcion(newServicio.getDescripcion());
    //     // servicio.setLugar(newServicio.getLugar());

    //     return servicioService.agregarServicio(servicio);
    // }

    @DeleteMapping("/eliminar/servicio/{id}")
    public void eliminarProveedor(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
    }
}