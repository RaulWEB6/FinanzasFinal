package tr.com.jowl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tr.com.jowl.model.Gastosinicial;

@Repository
public interface GastoinicialRepository extends JpaRepository<Gastosinicial, Integer>{

	@Query("from Gastosinicial g where g.bancoGastosinicial.idBanco = ?1")
	List<Gastosinicial> findByNombreBancoi(int idBanco);
}
