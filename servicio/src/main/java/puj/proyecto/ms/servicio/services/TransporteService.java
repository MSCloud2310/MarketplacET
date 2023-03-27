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
    @Autowired
    private TipoTransporteService tipoTransporteService;


    public List<Transporte> obtenerTransportes() {
        return (List<Transporte>) transporteRepository.findAll();
    }

    public Transporte obtenerTransporteId(Long id) {
        return transporteRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    //     return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public Transporte agregarTransporte(Transporte transporte, Long idTipoTransporte) {
        TipoTransporte tipo = tipoTransporteService.obtenerTipoTransporteId(idTipoTransporte);

        Transporte alojaNew = new Transporte(transporte.getNombre(), transporte.getPrecio(), transporte.getDescripcion(), transporte.getDisponibilidad(), transporte.getStock(), transporte.getFoto(), transporte.getOrigen(), transporte.getDestino(), transporte.getHora_inicio(), transporte.getHora_fin(), tipo);
        servicioService.agregarServicio(alojaNew);

        return alojaNew;
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
