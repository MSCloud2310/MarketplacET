package puj.proyecto.ms.usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.proyecto.ms.usuarios.model.RedSocial;
import puj.proyecto.ms.usuarios.repository.RedSocialRepository;

@Service
public class RedSocialService {
    @Autowired
    private RedSocialRepository redSocialRepository;

    public List<RedSocial> obtenerRedesSociales() {
        return (List<RedSocial>) redSocialRepository.findAll();
    }

    public RedSocial obtenerRedSocialId(Long id) {
        return redSocialRepository.findById(id).orElseThrow();
    }

    public RedSocial obtenerRedSocialNombre(String nombre) {
        return redSocialRepository.findByNombre(nombre);
    }

    public RedSocial agregarRedSocial(RedSocial redSocial) {
        return redSocialRepository.save(redSocial);
    }

    public RedSocial actualizarRedSocial(Long id, RedSocial newRedSocial) {
        RedSocial redSocial = redSocialRepository.findById(id).orElseThrow();

        redSocial.setNombre(newRedSocial.getNombre());
        redSocial.setUrl(newRedSocial.getUrl());
        redSocial.setProveedor(newRedSocial.getProveedor());

        return redSocialRepository.save(redSocial);
    }

    public String eliminarRedSocial(Long id) {
        redSocialRepository.deleteById(id);
        return "La red social con " + id + " ha sido eliminada satisfactoriamente.";
    }
}
