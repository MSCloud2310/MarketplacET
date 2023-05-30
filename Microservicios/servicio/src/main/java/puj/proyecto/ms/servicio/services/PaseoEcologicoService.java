package puj.proyecto.ms.servicio.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import puj.proyecto.ms.servicio.client.ClienteEureka;
import puj.proyecto.ms.servicio.model.PaseoEcologico;
import puj.proyecto.ms.servicio.repository.PaseoEcologicoRepository;

@Service
public class PaseoEcologicoService {
    @Autowired
    private PaseoEcologicoRepository paseoEcologicoRepository;

    @Autowired
    private ClienteEureka clienteEureka;

    public List<PaseoEcologico> obtenerPaseosEcologicos() {
        return paseoEcologicoRepository.findAll();
    }

    public PaseoEcologico obtenerPaseoEcologicoId(Long id) {
        return paseoEcologicoRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    // return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public PaseoEcologico agregarPaseoEcologico(PaseoEcologico pasEco) {
        RestTemplate restTemplate = new RestTemplate();
        URI usuariosURI = clienteEureka.getUri("USUARIOS");
        // System.out.println("URL SERVICIO: " +
        // servicioUri.resolve("/servicio/nombre?name=paseo%20esoco").toString());
        Long id_proveedor = pasEco.getId_proveedor();
        Object cliente = restTemplate.getForObject(usuariosURI.resolve("usuario/proveedor/" + id_proveedor),
                Object.class);
        if (cliente == null) {
            System.out.println("Status: Proveedor no existe");
            return null;
        }
        return paseoEcologicoRepository.save(pasEco);
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
