package tr.com.jowl.service;

import java.util.List;

import tr.com.jowl.model.Gastosfinal;

public interface IGastosfinalService {

	public Integer insertar(Gastosfinal gastosfinal);

	public void eliminar(int idGastosfinal);

	List<Gastosfinal> listar();
	
	List<Gastosfinal> buscar(int idBanco);
}
