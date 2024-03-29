package puj.proyecto.ms.usuarios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import puj.proyecto.ms.usuarios.model.Proveedor;
import puj.proyecto.ms.usuarios.model.Usuario;
import puj.proyecto.ms.usuarios.model.Cliente;
import puj.proyecto.ms.usuarios.services.ClienteService;
import puj.proyecto.ms.usuarios.services.ProveedorService;
import puj.proyecto.ms.usuarios.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    Environment environment;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping()
    public List<Usuario> obtenerUsuarios() {
        return (List<Usuario>) usuarioService.obtenerUsuarios();
    }

    @GetMapping("/rol")
    public List<Usuario> findByRol(@RequestParam String rol) {
        return (List<Usuario>) usuarioService.findByRol(rol);
    }

    @GetMapping("/correo")
    public Optional<Usuario> findByCorreo(@RequestParam String correo) {
        return usuarioService.findByCorreo(correo);
    }

    @GetMapping("/cliente")
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) clienteService.obtenerClientes();
    }

    @GetMapping("/proveedor")
    public List<Proveedor> obtenerProveedor() {
        return (List<Proveedor>) proveedorService.obtenerProveedor();
    }

    @GetMapping("/cliente/{id}")
    public Cliente obtenerClienteId(@PathVariable Long id) {
        return clienteService.obtenerClienteId(id);
    }

    @GetMapping("/proveedor/{id}")
    public Proveedor obtenerProveedorId(@PathVariable Long id) {
        return proveedorService.obtenerProveedorId(id);
    }

    // http://localhost:8080/usuario/query/cliente?nombre=Mau
    @GetMapping("/cliente/nombre/{nombre}")
    public Cliente obtenerClienteName(@PathVariable String nombre) {
        return clienteService.obtenerClienteName(nombre);
    }

    @GetMapping("/cliente/cedula/{cedula}")
    public Cliente obtenerClienteCedula(@PathVariable String cedula) {
        return clienteService.obtenerClienteCedula(cedula);
    }

    @GetMapping("/proveedor/nombre/{nombre}")
    public Proveedor obtenerProveedorName(@PathVariable String nombre) {
        return proveedorService.obtenerProveedorName(nombre);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Usuario user) {
        return usuarioService.login(user);
    }

    @PostMapping("/cliente")
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return clienteService.agregarCliente(cliente);
    }

    @PostMapping("/proveedor")
    public Proveedor agregarProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.agregarProveedor(proveedor);
    }

    @PutMapping("/cliente/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente newCliente) {
        return clienteService.actualizarCliente(id, newCliente);
    }

    @PutMapping("/proveedor/{id}")
    public Proveedor actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor newProveedor) {
        return proveedorService.actualizarProveedor(id, newProveedor);
    }

    @DeleteMapping("/cliente/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        return clienteService.eliminarCliente(id);

    }

    @DeleteMapping("/proveedor/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        return proveedorService.eliminarProveedor(id);
    }
}
