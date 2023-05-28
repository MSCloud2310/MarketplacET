package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;

import puj.proyecto.ms.servicio.model.Alimentacion;
import puj.proyecto.ms.servicio.model.TipoComida;
import puj.proyecto.ms.servicio.repository.AlimentacionRepository;

@Service
public class AlimentacionService {
    @Autowired
    private AlimentacionRepository alimentacionRepository;

    public List<Alimentacion> obtenerAlimentacion() {
        return alimentacionRepository.findAll();
    }

    public Alimentacion obtenerAlimentacionId(Long id) {
        return alimentacionRepository.findById(id).orElseThrow();
    }

    public Alimentacion agregarAlimentacion(Alimentacion alimentacion) {
        return alimentacionRepository.save(alimentacion);
    }

    public Alimentacion actualizarAlimentacion(Long id, Alimentacion newAlimentacion) {
        Alimentacion alimentacion = alimentacionRepository.findById(id).orElseThrow();

        alimentacion.setNombre(newAlimentacion.getNombre());
        alimentacion.setPrecio(newAlimentacion.getPrecio());
        alimentacion.setDescripcion(newAlimentacion.getDescripcion());
        alimentacion.setDisponibilidad(newAlimentacion.getDisponibilidad());
        alimentacion.setStock(newAlimentacion.getStock());
        alimentacion.setFoto(newAlimentacion.getFoto());

        return alimentacionRepository.save(alimentacion);
    }

    public String eliminarAlimentacion(Long id) {
        alimentacionRepository.deleteById(id);
        return "La alimentación con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
