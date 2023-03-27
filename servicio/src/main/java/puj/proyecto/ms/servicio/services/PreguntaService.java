package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.servicio.model.Pregunta;
import puj.proyecto.ms.servicio.repository.PreguntaRepository;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    public List<Pregunta> obtenerPreguntas() {
        return (List<Pregunta>) preguntaRepository.findAll();
    }

    public Pregunta obtenerPreguntaId(Long id) {
        return preguntaRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    //     return paseoEcologicoRepository.findByNombre(nombre);cccccc
    // }

    public Pregunta agregarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public Pregunta actualizarPregunta(Long id, Pregunta newPregunta) {
        Pregunta pregunta = preguntaRepository.findById(id).orElseThrow();

        pregunta.setContenido(newPregunta.getContenido());
        pregunta.setRespuesta(newPregunta.getRespuesta());
       
        return preguntaRepository.save(pregunta);
    }

    public String eliminarPregunta(Long id) {
        preguntaRepository.deleteById(id);
        return "La pregunta con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
