package tr.com.jowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jowl.model.Gastosinicial;

@Repository
public interface GastosfinalRepository extends JpaRepository<Gastosinicial, Integer> {

}
