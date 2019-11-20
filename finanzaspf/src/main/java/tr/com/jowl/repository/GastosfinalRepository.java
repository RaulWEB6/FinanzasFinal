package tr.com.jowl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tr.com.jowl.model.Gastosfinal;

@Repository
public interface GastosfinalRepository extends JpaRepository<Gastosfinal, Integer> {

	@Query("select count(e.nombreGastosfinal) from Gastosfinal e where e.nombreGastosfinal =:nombreGastosfinal")
	public int validarNombreGastosfinal(@Param("nombreGastosfinal") String nombreGastosfinal);

	@Query("from Gastosfinal g where g.bancoGastosfinal.idBanco = ?1")
	List<Gastosfinal> findByNombreBanco(int idBanco);
}
