package javeriana.ms.servicio.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component("ClienteEureka")
public class ClienteEureka {

    @Autowired
    private DiscoveryClient discoveryClient;

    public URI getUri(String nombreServicio) {
        List<ServiceInstance> list = discoveryClient.getInstances(nombreServicio);
        if (list != null && list.size() > 0) {
            return list.get(0).getUri();
        
        }
        return null;
    }

}