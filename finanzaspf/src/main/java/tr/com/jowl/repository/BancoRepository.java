package tr.com.jowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tr.com.jowl.model.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

	@Query("select count(b.rucBanco) from Banco b where b.rucBanco =:rucBanco")
	public int validarRucBanco(@Param("rucBanco") String rucBanco);
}
