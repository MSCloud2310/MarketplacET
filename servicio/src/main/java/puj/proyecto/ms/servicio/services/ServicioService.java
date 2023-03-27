package puj.proyecto.ms.servicio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.servicio.model.Servicio;
import puj.proyecto.ms.servicio.repository.ServicioRepository;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerServicios() {
        return (List<Servicio>) servicioRepository.findAll();
    }

    public Servicio obtenerServicioId(Long id) {
        return servicioRepository.findById(id).orElseThrow();
    }

    public List<Servicio> obtenerServicioCategoria(String categoria) {
        return servicioRepository.findByCategoria(categoria);
    }

    public List<Servicio> obtenerServicioTexto(String cadena) {
        //return servicioRepository.findAll().forEach(null);;
        List<Servicio> servicios = new ArrayList<>();
        for(Servicio s:servicioRepository.findAll()){
            if(s.getDescripcion().contains(cadena) || s.getNombre().contains(cadena) || s.getCategoria().contains(cadena)){
                servicios.add(s);
            }
        }
        return servicios;
    }

    public Servicio agregarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    // public Servicio actualizarServicio(Long id, Servicio newServicio) {
    //     Servicio usuario = servicioRepository.findById(id).orElseThrow();

        

    //     usuario.setNombre(newUsuario.getNombre());
    //     usuario.setCorreo(newUsuario.getCorreo());
    //     usuario.setPassword(newUsuario.getPassword());
    //     usuario.setEdad(newUsuario.getEdad());
    //     usuario.setFoto(newUsuario.getFoto());
    //     usuario.setDescripcion(newUsuario.getDescripcion());

    //     return servicioRepository.save(usuario);
    // }

    public String eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
        return "El cliente con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
