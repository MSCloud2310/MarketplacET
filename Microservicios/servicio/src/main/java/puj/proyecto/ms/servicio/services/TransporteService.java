package puj.proyecto.ms.servicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import puj.proyecto.ms.servicio.model.Transporte;
import puj.proyecto.ms.servicio.repository.TransporteRepository;

@Service
public class TransporteService {

    @Autowired
    Environment environment;

    @Autowired
    private TransporteRepository transporteRepository;

    public List<Transporte> obtenerTransportes() {
        return transporteRepository.findAll();
    }

    public Transporte obtenerTransporteId(Long id) {
        return transporteRepository.findById(id).orElseThrow();
    }

    public Transporte agregarTransporte(Transporte transporte) {
        RestTemplate restTemplate = new RestTemplate();
        Long id_proveedor = transporte.getId_proveedor();
        Object cliente = restTemplate.getForObject(environment.getProperty("urlProveedor") + id_proveedor,
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
