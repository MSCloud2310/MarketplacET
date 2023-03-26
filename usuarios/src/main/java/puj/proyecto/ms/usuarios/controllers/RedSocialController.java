package puj.proyecto.ms.usuarios.controllers;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.proyecto.ms.usuarios.model.RedSocial;
import puj.proyecto.ms.usuarios.repository.RedSocialRepository;
import puj.proyecto.ms.usuarios.services.RedSocialService;

@RestController
@RequestMapping("/red-social")
public class RedSocialController {
    
    @Autowired
    Environment environment;

    @Autowired
    private RedSocialService redSocialService;


    @GetMapping()
    public List<RedSocial> obtenerRedesSociales() {
        return (List<RedSocial>) redSocialService.obtenerRedesSociales();
    }

    @GetMapping("/{id}")
    public RedSocial obtenerRedSocialId(@PathVariable Long id) {
        return redSocialService.obtenerRedSocialId(id);
    }

    // http://localhost:8080/usuario/query/cliente?nombre=Mau
    @GetMapping("/nombre/{nombre}")
    public RedSocial obtenerRedSocialNombre(@PathVariable String nombre) {
        return redSocialService.obtenerRedSocialNombre(nombre);
    }

    @PostMapping()
    public RedSocial agregarRedSocial(@RequestBody RedSocial redSocial) {
        return redSocialService.agregarRedSocial(redSocial);
    }

    @PutMapping("/{id}")
    public RedSocial actualizarRedSocial(@PathVariable Long id, @RequestBody RedSocial newRedSocial) {
        return redSocialService.actualizarRedSocial(id, newRedSocial);
    }

    @DeleteMapping("/{id}")
    public String eliminarRedSocial(@PathVariable Long id) {
        return redSocialService.eliminarRedSocial(id);
    }
}