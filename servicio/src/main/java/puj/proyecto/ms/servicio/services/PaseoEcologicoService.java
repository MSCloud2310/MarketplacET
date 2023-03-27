package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.servicio.model.PaseoEcologico;
import puj.proyecto.ms.servicio.repository.PaseoEcologicoRepository;

@Service
public class PaseoEcologicoService {
    @Autowired
    private PaseoEcologicoRepository paseoEcologicoRepository;
    @Autowired
    private ServicioService servicioService;

    public List<PaseoEcologico> obtenerPaseosEcologicos() {
        return (List<PaseoEcologico>) paseoEcologicoRepository.findAll();
    }

    public PaseoEcologico obtenerPaseoEcologicoId(Long id) {
        return paseoEcologicoRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    //     return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public PaseoEcologico agregarPaseoEcologico(PaseoEcologico pasEco) {
        PaseoEcologico paseoNew = new PaseoEcologico(pasEco.getNombre(), pasEco.getPrecio(), pasEco.getDescripcion(), pasEco.getDisponibilidad(), pasEco.getStock(), pasEco.getFoto(), pasEco.getOrigen(), pasEco.getDestino(), pasEco.getFecha_salida(), pasEco.getFecha_llegada(), pasEco.getGuia_turistico(), pasEco.getRecomendaciones());
        servicioService.agregarServicio(paseoNew);

        return paseoNew;
      
    }

    public PaseoEcologico actualizarPaseoEcologico(Long id, PaseoEcologico newPaseoEcologico) {
        PaseoEcologico paseoEcologico = paseoEcologicoRepository.findById(id).orElseThrow();

        paseoEcologico.setDescripcion(newPaseoEcologico.getDescripcion());
        paseoEcologico.setDestino(newPaseoEcologico.getDestino());
        paseoEcologico.setDisponibilidad(newPaseoEcologico.getDisponibilidad());
        paseoEcologico.setFecha_llegada(newPaseoEcologico.getFecha_llegada());
        paseoEcologico.setFecha_salida(newPaseoEcologico.getFecha_salida());
        paseoEcologico.setFoto(newPaseoEcologico.getFoto());
        paseoEcologico.setGuia_turistico(newPaseoEcologico.getGuia_turistico());
        paseoEcologico.setNombre(newPaseoEcologico.getNombre());
        paseoEcologico.setOrigen(newPaseoEcologico.getOrigen());
        paseoEcologico.setPrecio(newPaseoEcologico.getPrecio());
        paseoEcologico.setRecomendaciones(newPaseoEcologico.getRecomendaciones());
        paseoEcologico.setStock(newPaseoEcologico.getStock());

        return paseoEcologicoRepository.save(paseoEcologico);
    }

    public String eliminarPaseoEcologico(Long id) {
        paseoEcologicoRepository.deleteById(id);
        return "El paseo ecológico con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
