package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.servicio.model.Alojamiento;
import puj.proyecto.ms.servicio.repository.AlojamientoRepository;

@Service
public class AlojamientoService {
    @Autowired
    private AlojamientoRepository alojamientoRepository;
    @Autowired
    private ServicioService servicioService;


    public List<Alojamiento> obtenerAlojamientos() {
        return (List<Alojamiento>) alojamientoRepository.findAll();
    }

    public Alojamiento obtenerAlojamientoId(Long id) {
        return alojamientoRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    //     return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public Alojamiento agregarAlojamiento(Alojamiento alojamiento) {
        Alojamiento alojaNew = new Alojamiento(alojamiento.getNombre(), alojamiento.getPrecio(), alojamiento.getDescripcion(), alojamiento.getDisponibilidad(), alojamiento.getStock(), alojamiento.getFoto(), alojamiento.getFecha_inicio(), alojamiento.getFecha_fin(), alojamiento.getCantidad_personas());
        servicioService.agregarServicio(alojaNew);

        return alojaNew;
    }

    public Alojamiento actualizarAlojamiento(Long id, Alojamiento newAlojamiento) {
        Alojamiento alojamiento = alojamientoRepository.findById(id).orElseThrow();

        alojamiento.setNombre(newAlojamiento.getNombre());
        alojamiento.setPrecio(newAlojamiento.getPrecio());
        alojamiento.setDescripcion(newAlojamiento.getDescripcion());
        alojamiento.setDisponibilidad(newAlojamiento.getDisponibilidad());
        alojamiento.setStock(newAlojamiento.getStock());
        alojamiento.setFoto(newAlojamiento.getFoto());

        alojamiento.setFecha_inicio(newAlojamiento.getFecha_inicio());
        alojamiento.setFecha_fin(newAlojamiento.getFecha_fin());
        alojamiento.setCantidad_personas(newAlojamiento.getCantidad_personas());

        return alojamientoRepository.save(alojamiento);
    }

    public String eliminarAlojamiento(Long id) {
        alojamientoRepository.deleteById(id);
        return "El alojamiento con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
