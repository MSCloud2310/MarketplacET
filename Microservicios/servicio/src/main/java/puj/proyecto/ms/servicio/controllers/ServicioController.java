package puj.proyecto.ms.servicio.controllers;

import java.text.ParseException;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
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
import org.springframework.web.client.RestTemplate;

import puj.proyecto.ms.servicio.model.Alimentacion;
import puj.proyecto.ms.servicio.model.Alojamiento;
import puj.proyecto.ms.servicio.model.PaseoEcologico;
import puj.proyecto.ms.servicio.model.Servicio;
import puj.proyecto.ms.servicio.model.Transporte;
import puj.proyecto.ms.servicio.services.AlimentacionService;
import puj.proyecto.ms.servicio.services.AlojamientoService;
import puj.proyecto.ms.servicio.services.PaseoEcologicoService;
import puj.proyecto.ms.servicio.services.ServicioService;
import puj.proyecto.ms.servicio.services.TransporteService;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    private static final String API_KEY = "68b394aa15886222c694fd3a56f664ff";
    private static final String WEATHER_URL_ONE = "http://api.openweathermap.org/data/2.5/weather?";
    private static final String WEATHER_URL_DAILY = "http://api.openweathermap.org/data/2.5/forecast/daily?";
    @Autowired
    Environment environment;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private AlojamientoService alojamientoService;

    @Autowired
    private PaseoEcologicoService paseoEcologicoService;

    @Autowired
    private AlimentacionService alimentacionService;

    @Autowired
    private TransporteService transporteService;

    @GetMapping()
    public List<Servicio> obtenerServicios() {
        return servicioService.obtenerServicios();
    }

    @GetMapping("/{id}")
    public Servicio obtenerServicioId(@PathVariable Long id) {
        return servicioService.obtenerServicioId(id);
    }

    // http://localhost:9999/servicio/nombre?nombre=
    @GetMapping("/nombre")
    public Servicio obtenerServicioNombre(@RequestParam String name) {
        System.out.println("REQUEST: " + name);
        return servicioService.obtenerServicioNombre(name);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Servicio> obtenerServicioCategoria(@PathVariable String categoria) {
        return servicioService.obtenerServicioCategoria(categoria);
    }

    @GetMapping("/buscar/{cadena}")
    public List<Servicio> obtenerServicioTexto(@PathVariable String cadena) {
        return servicioService.obtenerServicioTexto(cadena);
    }

    // http://localhost:8080/servicio/stock/nombre?nombre=alojamiento
    @GetMapping("stock/nombre/{nombre}")
    public Integer obtenerStockServicio(@PathVariable String nombre) {
        Servicio servicioTemp = servicioService.obtenerServicioNombre(nombre);
        if (servicioTemp != null) {
            return servicioTemp.getStock();
        }
        return -1;
    }

    @PostMapping("/agregar-alojamiento")
    public Servicio agregarAlojamiento(@RequestBody Alojamiento alojamiento) throws ParseException {
        // String uri = "https://restcountries.com/v3.1/name/" + alojamiento.getPais();
        // System.out.println("URIII; " + uri);
        // RestTemplate restTemplate = new RestTemplate();
        // String response = restTemplate.getForObject(uri, String.class);
        // System.out.println("REST COUNTRIES: " + response);
        // http://api.openweathermap.org/data/2.5/weather?q=Lima&APPID=68b394aa15886222c694fd3a56f664ff
        // http://api.openweathermap.org/data/2.5/forecast/daily?q=Medellin&mode=json&appid=68b394aa15886222c694fd3a56f664ff&units=metric&cnt=5
        String city = alojamiento.getCiudad();
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(
                WEATHER_URL_DAILY + "q={city}&mode=json&appid=" + API_KEY + "&units=metric&cnt={dias}", String.class,
                city, 5);
        System.out.println("RESPONSE WEATHER: " + response);

        JSONArray weather;

        JSONObject root = new JSONObject(response);

        JSONObject ciudad = root.getJSONObject("city");
        JSONObject coord = ciudad.getJSONObject("coord");
        alojamiento.setLatitud(String.valueOf(coord.getBigDecimal("lat")));
        alojamiento.setLongitud(String.valueOf(coord.getBigDecimal("lon")));
        JSONArray weatherObject = root.getJSONArray("list");
        String clima_dias = "";
        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            weather = elementInArray.getJSONArray("weather");
            clima_dias += "Día: " + i + " -> ";
            for (int j = 0; j < weather.length(); j++) {
                JSONObject element = weather.getJSONObject(j);
                clima_dias += element.getString("description");
                clima_dias += "   ";
            }

        }
        alojamiento.setClima(clima_dias);
        return alojamientoService.agregarAlojamiento(alojamiento);
    }

    @PostMapping("/agregar-paseo-ecologico")
    public Servicio agregarPaseoEcologico(@RequestBody PaseoEcologico paseoEcologico) {
        String city = paseoEcologico.getCiudad();
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(WEATHER_URL_ONE + "q={city}&APPID=" + API_KEY, String.class, city);
        System.out.println("REST COUNTRIES: " + response);
        
        String description = null;

        JSONObject root = new JSONObject(response);

        JSONObject coord = root.getJSONObject("coord");
        paseoEcologico.setLatitud(String.valueOf(coord.getBigDecimal("lat")));
        paseoEcologico.setLongitud(String.valueOf(coord.getBigDecimal("lon")));
        JSONArray weatherObject = root.getJSONArray("weather");

        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("description");
        }

        paseoEcologico.setClima(description);
        return paseoEcologicoService.agregarPaseoEcologico(paseoEcologico);
    }

    @PostMapping("/agregar-alimentacion/tipo/{id}")
    public Servicio agregarAlimentacion(@RequestBody Alimentacion alimentacion) {
        String city = alimentacion.getCiudad();
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(WEATHER_URL_ONE + "q={city}&APPID=" + API_KEY, String.class, city);
        System.out.println("REST COUNTRIES: " + response);
        // JSONArray jsonArray = new JSONObject(response).getJSONArray("weather");
        String description = null;

        // List<Example> weatherList = new ArrayList<>();

        JSONObject root = new JSONObject(response);

        JSONObject coord = root.getJSONObject("coord");
        alimentacion.setLatitud(String.valueOf(coord.getBigDecimal("lat")));
        alimentacion.setLongitud(String.valueOf(coord.getBigDecimal("lon")));
        JSONArray weatherObject = root.getJSONArray("weather");

        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("description");
        }

        alimentacion.setClima(description);
        return alimentacionService.agregarAlimentacion(alimentacion);
    }

    @PostMapping("/agregar-transporte/tipo/{id}")
    public Servicio agregarTransporte(@RequestBody Transporte transporte) {
        // String uri = "https://restcountries.com/v3.1/name/{nombre}";
        // RestTemplate restTemplate = new RestTemplate();
        // String nombre = transporte.getPais();
        // String response = restTemplate.getForObject(uri, String.class, nombre);
        // System.out.println("REST COUNTRIES: " + response);
        String city = transporte.getCiudad();
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(WEATHER_URL_ONE + "q={city}&APPID=" + API_KEY, String.class, city);
        System.out.println("REST COUNTRIES: " + response);

        String description = null;

        JSONObject root = new JSONObject(response);

        JSONObject coord = root.getJSONObject("coord");
        transporte.setLatitud(String.valueOf(coord.getBigDecimal("lat")));
        transporte.setLongitud(String.valueOf(coord.getBigDecimal("lon")));
        JSONArray weatherObject = root.getJSONArray("weather");

        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("description");
        }

        transporte.setClima(description);
        return transporteService.agregarTransporte(transporte);
    }

    @PostMapping("/agregar/servicio")
    public Servicio agregarServicio(@RequestBody Servicio servicio) {
        String uri = "https://restcountries.com/v3.1/name/{nombre}";
        RestTemplate restTemplate = new RestTemplate();
        String nombre = servicio.getPais();
        String response = restTemplate.getForObject(uri, String.class, nombre);
        System.out.println("REST COUNTRIES: " + response);
        return servicioService.agregarServicio(servicio);
    }

    @PutMapping("/actualizar/servicio/{id}")
    public Servicio actualizaServicio(@PathVariable Long id, @RequestBody Servicio newServicio) {
        Servicio servicio = servicioService.obtenerServicioId(id);
        return servicioService.agregarServicio(servicio);
    }

    @DeleteMapping("/eliminar/servicio/{id}")
    public void eliminarProveedor(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
    }
}