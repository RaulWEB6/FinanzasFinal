package tr.com.jowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jowl.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
