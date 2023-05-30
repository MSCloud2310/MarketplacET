package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.servicio.model.Calificacion;
import puj.proyecto.ms.servicio.repository.CalificacionRepository;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> obtenerCalificacionesCliente(Long id) {
        return calificacionRepository.findAll();
    }

    public List<Calificacion> obtenerCalificacionesServicio(Long id) {
        return calificacionRepository.findByCliente(id);
    }

    public Calificacion obtenerCalificacion(Long id) {
        return calificacionRepository.findById(id).orElseThrow();
    }

    public Calificacion guardarCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    public String actualizarCalificacion(Long id, Calificacion calificacion) {
        if (calificacionRepository.existsById(id)) {
            Calificacion newCalificacion = calificacionRepository.findById(id).orElseThrow();
            newCalificacion.setComentario(calificacion.getComentario());
            newCalificacion.setEstrellas(calificacion.getEstrellas());

            return "Calificacion actualizada:\n"+calificacionRepository.save(newCalificacion).toString();
        }
        return "Calificacion no existe";
    }

    public void eliminarCalificacion(Long id) {
        calificacionRepository.deleteById(id);
    }
}
