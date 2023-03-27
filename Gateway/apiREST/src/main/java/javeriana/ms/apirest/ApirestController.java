package javeriana.ms.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

////




@RestController
public class ApirestController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @PostMapping("/login")
    public String login(@RequestBody String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://servicioAutenticacion/login", requestEntity, String.class);
        String response = responseEntity.getBody();
        return response;
    }

    @PostMapping("/register-cliente")
    public String registrarCliente(@RequestBody String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://servicioUsuarios/registrar-cliente", requestEntity, String.class);
        String response = responseEntity.getBody();
        return response;
    }
    
    @PostMapping("/register-proveedor")
    public String registrarProveedor(@RequestBody String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://servicioUsuarios/registrar-proveedor", requestEntity, String.class);
        String response = responseEntity.getBody();
        return response;
    }

    @GetMapping("/items")
    public String traerTodo() {
        String response = restTemplate.getForObject("http://servicioProductos/item", String.class);
        return response;
    }

    @GetMapping("/categoria")
    public String traerCategoria(@RequestParam int tipo) {
        String response = restTemplate.getForObject("http://servicioProductos/categoria", String.class, tipo);
        return response;
    }

    /*BUSCAR POR CADENA DE TEXTO */
    @GetMapping("/buqueda-items")
    public String traerCategoria(@RequestParam String cadena) {
        String response = restTemplate.getForObject("http://servicioProductos/categoria", String.class, cadena);
        return response;
    }

    @GetMapping("/item")
    public String traerUno(@RequestParam int item) {
        String response = restTemplate.getForObject("http://servicioProductos/item/"+item, String.class);
        return response;
    }

    @PutMapping("/item-pregunta")
    public String registrarPregunta(@RequestBody String requestBody) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, headers);
    ResponseEntity<String> responseEntity = restTemplate.exchange("http://servicioProductos/preguntar", HttpMethod.PUT, requestEntity, String.class);
    String response = responseEntity.getBody();
    return response;
    }

    @PostMapping("/orden")
    public String generarOrden(@RequestBody String requestBody) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, headers);
    ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://servicioOrdenes/carrito", requestEntity, String.class);
    String response = responseEntity.getBody();
    return response;
    }

    @GetMapping("/carrito")
    public String traerCarrito() {
        String response = restTemplate.getForObject("http://servicioProductos/carrito", String.class);
        return response;
    }

    @DeleteMapping("/carrito/{id}")
    public ResponseEntity<String> comprarProducto(@PathVariable int id) {
        restTemplate.delete("http://servicioOrdenes/carrito/{id}", id);
        return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.OK);
    }

}