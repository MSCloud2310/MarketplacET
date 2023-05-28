package puj.proyecto.ms.servicio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import puj.proyecto.ms.servicio.model.Servicio;
import puj.proyecto.ms.servicio.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerServicios() {
        return servicioRepository.findAll();
    }

    public Servicio obtenerServicioId(Long id) {
        return servicioRepository.findById(id).orElseThrow();
    }

    public List<Servicio> obtenerServicioCategoria(String categoria) {
        return servicioRepository.findByCategoria(categoria);
    }

    public Servicio obtenerServicioNombre(String nombre) {
        for (Servicio servicio : servicioRepository.findAll()) {
            if (servicio.getNombre().equals(nombre)) {
                return servicio;
            }
        }
        return null;
    }

    public List<Servicio> obtenerServicioTexto(String cadena) {
        List<Servicio> servicios = new ArrayList<>();
        for (Servicio s : servicioRepository.findAll()) {
            if (s.getDescripcion().contains(cadena) || s.getNombre().contains(cadena)
                    || s.getCategoria().contains(cadena)) {
                servicios.add(s);
            }
        }
        return servicios;
    }

    public Servicio agregarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio actualizarServicio(Long id, Servicio newServicio) {
        Servicio servicio = servicioRepository.findById(id).orElseThrow();

        servicio.setNombre(newServicio.getNombre());
        servicio.setCiudad(newServicio.getCiudad());
        servicio.setStock(newServicio.getStock());
        servicio.setCategoria(newServicio.getCategoria());
        servicio.setFoto(newServicio.getFoto());
        servicio.setDescripcion(newServicio.getDescripcion());

        return servicioRepository.save(servicio);
    }

    public String eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
        return "El cliente con " + id + " ha sido eliminado satisfactoriamente.";
    }
}