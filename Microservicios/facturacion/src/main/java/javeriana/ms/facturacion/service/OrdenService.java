package javeriana.ms.facturacion.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javeriana.ms.facturacion.client.ClienteEureka;
import javeriana.ms.facturacion.model.Orden;
import javeriana.ms.facturacion.model.OrdenItem;
import javeriana.ms.facturacion.model.Servicio;
import javeriana.ms.facturacion.repository.OrdenRepository;

@Service
public class OrdenService {

    private static final String API_KEY = "68b394aa15886222c694fd3a56f664ff";
    private static final String WEATHER_URL_ONE = "http://api.openweathermap.org/data/2.5/weather?";
    private static final String WEATHER_URL_DAILY = "http://api.openweathermap.org/data/2.5/forecast/daily?";

    @Autowired
    private ClienteEureka clienteEureka;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    OrdenRepository ordenRepository;

    @Autowired
    OrdenItemService ordenItemService;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public List<Orden> obtenerOrdenes() {
        return ordenRepository.findAll();
    }

    public Orden obtenerOrdenById(Long id) {
        return ordenRepository.findById(id).orElseThrow();
    }

    public List<Orden> obtenerOrdenByCustomer(String cedula) {
        return ordenRepository.findByNumeroCedula(cedula);
    }

    public String obtenerClimaById(Long id) {
        Orden ordenTemp = ordenRepository.findById(id).orElseThrow();
        // if (servicioObtenido.getCategoria().equals("alojamiento")
        // || servicioObtenido.getCategoria().equals("transporte")) {

        // }
        // String city = servicioObtenido.getCiudad();
        // RestTemplate restTemplate = new RestTemplate();
        // String response = restTemplate.getForObject(
        // WEATHER_URL_DAILY + "q={city}&mode=json&appid=" + API_KEY +
        // "&units=metric&cnt={dias}",
        // String.class,
        // city, 5);
        // System.out.println("RESPONSE WEATHER: " + response);

        // JSONArray weather;

        // JSONObject root = new JSONObject(response);

        // JSONObject ciudad = root.getJSONObject("city");
        // JSONObject coord = ciudad.getJSONObject("coord");
        // servicioObtenido.setLatitud(String.valueOf(coord.getBigDecimal("lat")));
        // servicioObtenido.setLongitud(String.valueOf(coord.getBigDecimal("lon")));
        // JSONArray weatherObject = root.getJSONArray("list");
        // String clima_dias = "";
        // for (int i = 0; i < weatherObject.length(); i++) {
        // JSONObject elementInArray = weatherObject.getJSONObject(i);
        // weather = elementInArray.getJSONArray("weather");
        // clima_dias += "Día: " + i + " -> ";
        // for (int j = 0; j < weather.length(); j++) {
        // JSONObject element = weather.getJSONObject(j);
        // clima_dias += element.getString("description");
        // clima_dias += " ";
        // }

        // }
        // servicioObtenido.setClima(clima_dias);

        String report = "";

        return report;
    }
    // public List<Orden> obtenerOrdenByService(Long id) {
    // return ordenRepository.findByIdServicio(id);
    // }

    // public PaseoEcologico obtenerPaseoEcologicoName(String nombre) {
    // return paseoEcologicoRepository.findByNombre(nombre);
    // }

    public Orden crearOrden(Orden orden) throws UnsupportedEncodingException {
        Orden newOrden = null;
        // Aquí se debe verificar que
        URI usuariosURI = clienteEureka.getUri("USUARIOS");
        URI servicioUri = clienteEureka.getUri("SERVICIOS");
        // System.out.println("URL SERVICIO: " +
        // servicioUri.resolve("/servicio/nombre?name=paseo%20esoco").toString());
        String cedula_cliente = orden.getNumeroCedula();
        Object cliente = restTemplate.getForObject(usuariosURI.resolve("usuario/cliente/cedula/" + cedula_cliente),
                Object.class);
        if (cliente == null) {
            System.out.println("Status: Cliente no existe");
            return null;
        }
        for (Servicio servicio : orden.getListaServicios()) {
            String name = URLEncoder.encode(servicio.getNombre(), StandardCharsets.UTF_8.toString());
            URI uri = UriComponentsBuilder.fromUriString(servicioUri.resolve("/servicio/nombre").toString())
                    .queryParam("name", name)
                    .build(true)
                    .toUri();

            // Realizar la solicitud GET y obtener la respuesta en un objeto de tipo
            LinkedHashMap<String, Object> respuestaMap = restTemplate.getForObject(uri, LinkedHashMap.class);

            // System.out.println(servicioOptional.getNombre());
            if (null == respuestaMap) {
                System.out.println("Status: Producto no existe");
                return null;
            }

            newOrden = ordenRepository.save(orden);

            // Convertir el objeto LinkedHashMap a un objeto de la clase Servicio
            ObjectMapper objectMapper = new ObjectMapper();
            Servicio servicioObtenido = objectMapper.convertValue(respuestaMap, Servicio.class);

            OrdenItem newOrdenItem = new OrdenItem();
            newOrdenItem.setOrden(newOrden);
            newOrdenItem.setCantidad(orden.getCantidad());
            newOrdenItem.setPrecio(orden.getPrecio());
            newOrdenItem.setId_servicio(servicioObtenido.getId());

            ordenItemService.crearOrden(newOrdenItem);
        }

        return newOrden;
    }

    public Orden actualizarOrden(Long id, Orden newOrden) {
        Orden orden = ordenRepository.findById(id).orElseThrow();

        orden.setFecha_inicio(newOrden.getFecha_inicio());
        orden.setFecha_fin(newOrden.getFecha_fin());
        orden.setOrdenItems(newOrden.getOrdenItems());
        return ordenRepository.save(orden);
    }

    public String eliminarOrden(Long id) {
        ordenRepository.deleteById(id);
        return "La orden con " + id + " ha sido eliminada satisfactoriamente.";
    }

}
