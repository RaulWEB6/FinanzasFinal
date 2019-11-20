package tr.com.jowl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tr.com.jowl.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
	@Query("select count(e.rucEmpresa) from Empresa e where e.rucEmpresa =:rucEmpresa")
	public int validarRucEmpresa(@Param("rucEmpresa") String rucEmpresa);
}
