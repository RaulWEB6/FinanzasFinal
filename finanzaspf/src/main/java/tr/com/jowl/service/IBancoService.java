package tr.com.jowl.service;

import java.util.List;
import java.util.Optional;

import tr.com.jowl.model.Banco;

public interface IBancoService {

	public Integer insertar(Banco banco);

	public void modificar(Banco banco);

	public void eliminar(int idBanco);

	Optional<Banco> listarId(int idBanco);
	
	List<Banco> listar();
}
