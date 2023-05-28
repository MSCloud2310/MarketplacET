package javeriana.ms.facturacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javeriana.ms.facturacion.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    public abstract List<Orden> findByNumeroCedula(String cedula);

    // public abstract List<Orden> findByIdServicio(Long id);
}
