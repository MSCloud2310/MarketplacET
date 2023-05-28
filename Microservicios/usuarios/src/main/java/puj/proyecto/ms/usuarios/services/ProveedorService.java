package puj.proyecto.ms.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.usuarios.model.Proveedor;
import puj.proyecto.ms.usuarios.model.RedSocial;
import puj.proyecto.ms.usuarios.repository.ProveedorRepository;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private RedSocialService redSocialService;

    public List<Proveedor> obtenerProveedor() {
        return proveedorRepository.findAll();
    }

    public Proveedor obtenerProveedorId(Long id) {
        return proveedorRepository.findById(id).orElseThrow();
    }

    public Proveedor obtenerProveedorName(String nombre) {
        return proveedorRepository.findByNombre(nombre);
    }

    public Proveedor agregarProveedor(Proveedor proveedor) {
        for (RedSocial redSocial : proveedor.getRedes_sociales()) {
            redSocial.setProveedor(proveedor);
        }
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizarProveedor(Long id, Proveedor newProveedor) {
        Proveedor proveedor = proveedorRepository.findById(id).orElseThrow();

        if (newProveedor.getRedes_sociales() != null) {
            for (RedSocial redSocial : newProveedor.getRedes_sociales()) {
                redSocial.setProveedor(proveedor);
                redSocialService.agregarRedSocial(redSocial);
                for (RedSocial redSocialAct : proveedor.getRedes_sociales()) {
                    proveedor.getRedes_sociales().add(redSocialAct);
                }
            }
        }

        proveedor.setNombre(newProveedor.getNombre());
        proveedor.setCorreo(newProveedor.getCorreo());
        proveedor.setPassword(newProveedor.getPassword());
        proveedor.setEdad(newProveedor.getEdad());
        proveedor.setFoto(newProveedor.getFoto());
        proveedor.setDescripcion(newProveedor.getDescripcion());
        proveedor.setTelefono(newProveedor.getTelefono());
        proveedor.setPagina_web(newProveedor.getPagina_web());
        proveedor.setRedes_sociales(newProveedor.getRedes_sociales());

        return proveedorRepository.save(proveedor);
    }

    public String eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
        return "El proveedor con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
