package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.servicio.model.Alimentacion;
import puj.proyecto.ms.servicio.model.TipoComida;
import puj.proyecto.ms.servicio.repository.AlimentacionRepository;

@Service
public class AlimentacionService {
    @Autowired
    private AlimentacionRepository alimentacionRepository;
    @Autowired
    private ServicioService servicioService;
    @Autowired
    private TipoComidaService tipoComidaService;


    public List<Alimentacion> obtenerAlimentacion() {
        return (List<Alimentacion>) alimentacionRepository.findAll();
    }

    public Alimentacion obtenerAlimentacionId(Long id) {
        return alimentacionRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    //     return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public Alimentacion agregarAlimentacion(Alimentacion alimentacion, Long idTipoComida) {
        TipoComida tipo = tipoComidaService.obtenerTipoComidaId(idTipoComida);

        Alimentacion alojaNew = new Alimentacion(alimentacion.getNombre(), alimentacion.getPrecio(), alimentacion.getDescripcion(), alimentacion.getDisponibilidad(), alimentacion.getStock(), alimentacion.getFoto(), tipo);
        servicioService.agregarServicio(alojaNew);

        return alojaNew;
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
