package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.servicio.model.TipoTransporte;
import puj.proyecto.ms.servicio.repository.TipoTransporteRepository;

@Service
public class TipoTransporteService {
    @Autowired
    private TipoTransporteRepository tipoTransporteRepository;

    public List<TipoTransporte> obtenerTiposTransporte() {
        return (List<TipoTransporte>) tipoTransporteRepository.findAll();
    }

    public TipoTransporte obtenerTipoTransporteId(Long id) {
        return tipoTransporteRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    //     return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public TipoTransporte agregarTipoTransporte(TipoTransporte tipoTransporte) {
        return tipoTransporteRepository.save(tipoTransporte);
    }

    public TipoTransporte actualizarTipoTransporte(Long id, TipoTransporte newTipoTransporte) {
        TipoTransporte tipoTransporte = tipoTransporteRepository.findById(id).orElseThrow();

        tipoTransporte.setNombre(newTipoTransporte.getNombre());
       
        return tipoTransporteRepository.save(tipoTransporte);
    }

    public String eliminarTipoTransporte(Long id) {
        tipoTransporteRepository.deleteById(id);
        return "El tipoTransporteRepository de comida con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
