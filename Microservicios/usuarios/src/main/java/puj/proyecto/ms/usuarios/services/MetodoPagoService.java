package puj.proyecto.ms.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.usuarios.model.MetodoPago;
import puj.proyecto.ms.usuarios.repository.MetodoPagoRepository;

@Service
public class MetodoPagoService {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> obtenerMetodosPago() {
        System.out.println(metodoPagoRepository.findAll());
        return (List<MetodoPago>) metodoPagoRepository.findAll();
    }

    public MetodoPago obtenerMetodoPagoId(Long id) {
        return metodoPagoRepository.findById(id).orElseThrow();
    }

    public MetodoPago obtenerMetodoPagoNombre(String nombre) {
        return metodoPagoRepository.findByNombre(nombre);
    }

    public MetodoPago agregarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public MetodoPago actualizarMetodoPago(Long id, MetodoPago newRedSocial) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id).orElseThrow();

        metodoPago.setNombre(newRedSocial.getNombre());

        return metodoPagoRepository.save(metodoPago);
    }

    public String eliminarMetodoPago(Long id) {
        metodoPagoRepository.deleteById(id);
        return "El método de pago con " + id + " ha sido eliminada satisfactoriamente.";
    }

}
