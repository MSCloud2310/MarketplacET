package javeriana.ms.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javeriana.ms.facturacion.model.Orden_Item;

@Repository
public interface OrdenItemRepository extends JpaRepository<Orden_Item, Long> {

}
