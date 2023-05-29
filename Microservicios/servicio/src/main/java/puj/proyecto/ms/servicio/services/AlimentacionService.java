package puj.proyecto.ms.servicio.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import puj.proyecto.ms.servicio.client.ClienteEureka;
import puj.proyecto.ms.servicio.model.Alimentacion;
import puj.proyecto.ms.servicio.repository.AlimentacionRepository;

@Service
public class AlimentacionService {
    @Autowired
    private AlimentacionRepository alimentacionRepository;

    @Autowired
    private ClienteEureka clienteEureka;

    public List<Alimentacion> obtenerAlimentacion() {
        return alimentacionRepository.findAll();
    }

    public Alimentacion obtenerAlimentacionId(Long id) {
        return alimentacionRepository.findById(id).orElseThrow();
    }

    public Alimentacion agregarAlimentacion(Alimentacion alimentacion) {
        RestTemplate restTemplate = new RestTemplate();
        URI usuariosURI = clienteEureka.getUri("USUARIOS");
        // System.out.println("URL SERVICIO: " +
        // servicioUri.resolve("/servicio/nombre?name=paseo%20esoco").toString());
        Long id_proveedor = alimentacion.getId_proveedor();
        Object cliente = restTemplate.getForObject(usuariosURI.resolve("/usuario/proveedor/" + id_proveedor),
                Object.class);
        if (cliente == null) {
            System.out.println("Status: Proveedor no existe");
            return null;
        }
        return alimentacionRepository.save(alimentacion);
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
