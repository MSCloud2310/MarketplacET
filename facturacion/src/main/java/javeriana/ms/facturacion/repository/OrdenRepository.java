package javeriana.ms.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javeriana.ms.facturacion.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

}
