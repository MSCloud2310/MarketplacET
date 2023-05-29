package puj.proyecto.ms.servicio.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import puj.proyecto.ms.servicio.client.ClienteEureka;
import puj.proyecto.ms.servicio.model.Transporte;
import puj.proyecto.ms.servicio.repository.TransporteRepository;

@Service
public class TransporteService {
    @Autowired
    private TransporteRepository transporteRepository;
    @Autowired
    private ClienteEureka clienteEureka;

    public List<Transporte> obtenerTransportes() {
        return transporteRepository.findAll();
    }

    public Transporte obtenerTransporteId(Long id) {
        return transporteRepository.findById(id).orElseThrow();
    }

    public Transporte agregarTransporte(Transporte transporte) {
        RestTemplate restTemplate = new RestTemplate();
        URI usuariosURI = clienteEureka.getUri("USUARIOS");
        // System.out.println("URL SERVICIO: " +
        // servicioUri.resolve("/servicio/nombre?name=paseo%20esoco").toString());
        Long id_proveedor = transporte.getId_proveedor();
        Object cliente = restTemplate.getForObject(usuariosURI.resolve("usuario/proveedor/" + id_proveedor),
                Object.class);
        if (cliente == null) {
            System.out.println("Status: Proveedor no existe");
            return null;
        }
        return transporteRepository.save(transporte);
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
