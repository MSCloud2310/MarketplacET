package puj.proyecto.ms.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.usuarios.model.Cliente;
import puj.proyecto.ms.usuarios.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private UsuarioService usuarioService;
 

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClienteId(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public Cliente obtenerClienteName(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
    public Cliente obtenerClienteCedula(String cedula) {
        return clienteRepository.findByCedula(cedula);
    }

    public Cliente agregarCliente(Cliente cliente) {
        Cliente clienteAgregado = clienteRepository.save(cliente);

        return clienteAgregado;
    }
    

    public Cliente actualizarCliente(Long id, Cliente newCliente) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        
        cliente.setNombre(newCliente.getNombre());
        cliente.setCorreo(newCliente.getCorreo());
        cliente.setPassword(newCliente.getPassword());
        cliente.setEdad(newCliente.getEdad());
        cliente.setFoto(newCliente.getFoto());
        cliente.setDescripcion(newCliente.getDescripcion());
        cliente.setCedula(newCliente.getCedula());

        return clienteRepository.save(cliente);
    }

    public String eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
        return "El cliente con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
