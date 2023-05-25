package javeriana.ms.facturacion.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javeriana.ms.facturacion.client.ClienteEureka;
import javeriana.ms.facturacion.model.Orden;
import javeriana.ms.facturacion.service.OrdenService;

@RestController
@RequestMapping("/compras")
public class FacturacionController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ClienteEureka clienteEureka;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    // @Bean
    // public RestTemplate restTesmplate() {
    // return new RestTemplate();
    // }

    @Autowired
    Environment environment;

    @Autowired
    private OrdenService ordenService;

    @GetMapping()
    public List<Orden> obtenerOrdenes() {
        return ordenService.obtenerOrdenes();
    }

    @GetMapping("/{id}")
    public Orden obtenerOrdenById(@PathVariable Long id) {
        return ordenService.obtenerOrdenById(id);
    }

    @GetMapping("/cliente/{id}")
    public List<Orden> obtenerOrdenByCustomer(@PathVariable Long id) {
        return ordenService.obtenerOrdenByCustomer(id);
    }

    @GetMapping("/servicio/{id}")
    public List<Orden> obtenerOrdenByService(@PathVariable Long id) {
        return ordenService.obtenerOrdenByService(id);
    }

    @PostMapping()
    public Orden crearOrden(@RequestBody Orden orden) {
        URI usuariosURI = clienteEureka.getUri("USUARIOS");
        URI servicioUri = clienteEureka.getUri("SERVICIOS");
        // System.out.println("URL SERVICIO: "+servicioUri.toString());
        Long id_cliente = orden.getId_cliente();
        Long id_servicio = orden.getId_servicio();
        // System.out.println("URL POST:" + servicioUri.resolve("/servicio/" +
        // id_servicio).toString());
        if (Optional.empty() != restTemplate.getForObject(usuariosURI.resolve("/usuario/cliente/" + id_cliente),
                Object.class)
                && Optional.empty() != restTemplate.getForObject(servicioUri.resolve("/servicio/" + id_servicio),
                        Object.class)) {
            return ordenService.crearOrden(orden);

        }
        return null;
    }

    @PutMapping("/{id}")
    public Orden actualizarOrden(@PathVariable Long id,
            @RequestBody Orden newOrden) {
        URI usuariosURI = clienteEureka.getUri("USUARIOS");
        URI servicioUri = clienteEureka.getUri("SERVICIO");
        Long id_cliente = newOrden.getId_cliente();
        Long id_servicio = newOrden.getId_servicio();
        if (Optional.empty() == restTemplate.getForObject(usuariosURI.resolve("/usuario/cliente/" + id_cliente),
                Object.class)
                && Optional.empty() == restTemplate.getForObject(servicioUri.resolve("/servicio/" + id_servicio),
                        Object.class)) {
            return null;
        }
        return ordenService.actualizarOrden(id, newOrden);
    }

    @DeleteMapping("/{id}")
    public String eliminarOrden(@PathVariable Long id) {
        return ordenService.eliminarOrden(id);
    }

}