package com.javeriana.servidorsoap.repository;


import java.util.HashMap;
import java.util.Map;

import com.proyecto.ecoturist.servicio.Servicio;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
@Component
public class ServiceRepository {
    private static final Map<Long, Servicio> services = new HashMap<>();
    @PostConstruct
    public void initData() {
        Servicio service = new Servicio();
        service.setId(1);   
        service.setNombre("Peliculas");
        services.put(service.getId(), service);
        Servicio service1 = new Servicio();
        service1.setId(2);
        service1.setNombre("Viajes");
        services.put(service1.getId(), service1);
    }
    public Servicio findServiceById(Long id) {
        return services.get(id);
    }
}
