package javeriana.ms.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javeriana.ms.facturacion.model.OrdenItem;
import javeriana.ms.facturacion.repository.OrdenItemRepository;

@Service
public class OrdenItemService {

    @Autowired
    OrdenItemRepository ordenItemRepository;

    public List<OrdenItem> obtenerOrdenes() {
        return ordenItemRepository.findAll();
    }

    public OrdenItem obtenerOrdenById(Long id) {
        return ordenItemRepository.findById(id).orElseThrow();
    }

    public OrdenItem crearOrden(OrdenItem orden) {
        return ordenItemRepository.save(orden);
    }

    public OrdenItem actualizarOrden(Long id, OrdenItem newOrden) {
        OrdenItem orden = ordenItemRepository.findById(id).orElseThrow();

        orden.setCantidad(newOrden.getCantidad());
        orden.setPrecio(newOrden.getPrecio());
        orden.setId_servicio(newOrden.getId_servicio());

        return ordenItemRepository.save(orden);
    }

    public String eliminarOrden(Long id) {
        ordenItemRepository.deleteById(id);
        return "La orden de compra con " + id + " ha sido eliminada satisfactoriamente.";
    }

}
