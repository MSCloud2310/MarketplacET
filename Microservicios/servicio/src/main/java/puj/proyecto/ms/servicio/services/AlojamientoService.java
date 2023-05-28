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

    public List<Alojamiento> obtenerAlojamientos() {
        return alojamientoRepository.findAll();
    }

    public Alojamiento obtenerAlojamientoId(Long id) {
        return alojamientoRepository.findById(id).orElseThrow();
    }

    public Alojamiento agregarAlojamiento(Alojamiento alojamiento) {
        return alojamientoRepository.save(alojamiento);
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
