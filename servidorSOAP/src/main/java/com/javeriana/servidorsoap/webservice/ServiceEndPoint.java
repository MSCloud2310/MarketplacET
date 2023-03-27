package com.javeriana.servidorsoap.webservice;

import com.javeriana.servidorsoap.repository.ServiceRepository;
import com.proyecto.ecoturist.servicio.GetServicioResponse;
import com.proyecto.ecoturist.servicio.GetServicioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
@Endpoint
public class ServiceEndPoint {
    private static final String NAMESPACE_URI = "http://www.proyecto.com/ecoturist/servicio";
    private ServiceRepository serviceRepository;

    @Autowired
    public ServiceEndPoint(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getServicioRequest")
    @ResponsePayload
    public GetServicioResponse getService(@RequestPayload GetServicioRequest
                                                 request) {
        GetServicioResponse response = new GetServicioResponse();
        response.setServicio(serviceRepository.findServiceById(request.getId()));
        System.out.println(request.getId());
        return response;
    }
}
