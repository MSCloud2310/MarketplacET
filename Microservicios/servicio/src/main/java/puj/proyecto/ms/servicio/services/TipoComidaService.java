package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.servicio.model.TipoComida;
import puj.proyecto.ms.servicio.repository.TipoComidaRepository;

@Service
public class TipoComidaService {
    @Autowired
    private TipoComidaRepository tipoComidaRepository;

    public List<TipoComida> obtenerTiposComida() {
        return (List<TipoComida>) tipoComidaRepository.findAll();
    }

    public TipoComida obtenerTipoComidaId(Long id) {
        return tipoComidaRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    //     return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public TipoComida agregarTipoComida(TipoComida tipoComida) {
        return tipoComidaRepository.save(tipoComida);
    }

    public TipoComida actualizarTipoComida(Long id, TipoComida newTipoComida) {
        TipoComida tipoComida = tipoComidaRepository.findById(id).orElseThrow();

        tipoComida.setNombre(newTipoComida.getNombre());
       
        return tipoComidaRepository.save(tipoComida);
    }

    public String eliminarTipoComida(Long id) {
        tipoComidaRepository.deleteById(id);
        return "El tipo de comida con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
