package puj.proyecto.ms.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.usuarios.model.Cliente;
import puj.proyecto.ms.usuarios.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Cliente obtenerClienteId(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public Cliente obtenerClienteName(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente newCliente) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();

        cliente.setNombre(newCliente.getNombre());
        cliente.setCorreo(newCliente.getCorreo());
        cliente.setPassword(newCliente.getPassword());
        cliente.setEdad(newCliente.getEdad());
        cliente.setFoto(newCliente.getFoto());
        cliente.setDescripcion(newCliente.getDescripcion());

        return clienteRepository.save(cliente);
    }

    public String eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
        return "El cliente con " + id + " ha sido eliminado satisfactoriamente.";
    }
}
