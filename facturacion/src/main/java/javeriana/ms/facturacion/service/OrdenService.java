package javeriana.ms.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.facturacion.model.Orden;
import javeriana.ms.facturacion.repository.OrdenRepository;

@Service
public class OrdenService {

    @Autowired
    OrdenRepository ordenRepository;

    public List<Orden> obtenerOrdenes() {
        return ordenRepository.findAll();
    }

    public Orden obtenerOrdenById(Long id) {
        return ordenRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    // return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public Orden crearOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    public Orden actualizarOrden(Long id, Orden newOrden) {
        Orden orden = ordenRepository.findById(id).orElseThrow();

        orden.setFecha(newOrden.getFecha());
        orden.setId_cliente(newOrden.getId_cliente());
        orden.setId_servicio(newOrden.getId_servicio());
        orden.setTotal(newOrden.getTotal());

        return ordenRepository.save(orden);
    }

    public String eliminarOrden(Long id) {
        ordenRepository.deleteById(id);
        return "La orden con " + id + " ha sido eliminada satisfactoriamente.";
    }

}
