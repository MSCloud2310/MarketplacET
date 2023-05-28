package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.servicio.model.TipoTransporte;
import puj.proyecto.ms.servicio.model.Transporte;
import puj.proyecto.ms.servicio.repository.TransporteRepository;

@Service
public class TransporteService {
    @Autowired
    private TransporteRepository transporteRepository;
    @Autowired
    private ServicioService servicioService;

    public List<Transporte> obtenerTransportes() {
        return transporteRepository.findAll();
    }

    public Transporte obtenerTransporteId(Long id) {
        return transporteRepository.findById(id).orElseThrow();
    }


    public Transporte agregarTransporte(Transporte transporte) {
        return transporteRepository.save(transporte);
    }

    public Transporte actualizarTransporte(Long id, Transporte newAlimentacion) {
        Transporte transporte = transporteRepository.findById(id).orElseThrow();

        transporte.setNombre(newAlimentacion.getNombre());
        transporte.setPrecio(newAlimentacion.getPrecio());
        transporte.setDescripcion(newAlimentacion.getDescripcion());
        transporte.setDisponibilidad(newAlimentacion.getDisponibilidad());
        transporte.setStock(newAlimentacion.getStock());
        transporte.setFoto(newAlimentacion.getFoto());

        return transporteRepository.save(transporte);
    }

    public String eliminarTransporte(Long id) {
        transporteRepository.deleteById(id);
        return "El transporte con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
