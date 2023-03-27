package javeriana.ms.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.facturacion.model.Orden_Item;
import javeriana.ms.facturacion.repository.OrdenItemRepository;

@Service
public class OrdenItemService {

    @Autowired
    OrdenItemRepository ordenItemRepository;

    public List<Orden_Item> obtenerOrdenes() {
        return ordenItemRepository.findAll();
    }

    public Orden_Item obtenerOrdenById(Long id) {
        return ordenItemRepository.findById(id).orElseThrow();
    }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    // return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public Orden_Item crearOrden(Orden_Item orden) {
        return ordenItemRepository.save(orden);
    }

    public Orden_Item actualizarOrden(Long id, Orden_Item newOrden) {
        Orden_Item orden = ordenItemRepository.findById(id).orElseThrow();

        orden.setCantidad(newOrden.getCantidad());
        orden.setPrecio(newOrden.getPrecio());
        orden.setId_orden(newOrden.getId_orden());
        orden.setId_servicio(newOrden.getId_servicio());

        return ordenItemRepository.save(orden);
    }

    public String eliminarOrden(Long id) {
        ordenItemRepository.deleteById(id);
        return "La orden de compra con " + id + " ha sido eliminada satisfactoriamente.";
    }

}
