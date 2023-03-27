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
    @Autowired
    private MetodoPagoService metodoPagoService;
    @Autowired
    private UsuarioService usuarioService;

    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Cliente obtenerClienteId(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public Cliente obtenerClienteName(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    public Cliente agregarClienteBasic(Cliente cliente) {
        Cliente cliNew = new Cliente(cliente.getNombre(), cliente.getCorreo(), cliente.getPassword(), cliente.getEdad(), cliente.getFoto(), cliente.getDescripcion()); 
        usuarioService.agregarUsuario(cliNew);

        return cliNew;
    }

    // public Cliente agregarClienteComplete(Cliente cliente, Long idMetodoPago) {
    //     MetodoPago pago = metodoPagoService.obtenerMetodoPagoId(idMetodoPago);

    //     if (pago == null)
    //         throw new RuntimeException("El pago con id " + idMetodoPago + " no existe en la BD");

    //     List<MetodoPago> metodos = new ArrayList<>();

    //     metodos.add(pago);
    //     Cliente clienteNew = clienteRepository.save(cliente);

    //     List<Cliente> clientes = new ArrayList<>();
    //     clientes.add(clienteNew);

    //     System.out.println(clienteNew);

    //     return clienteNew;
    // }

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
