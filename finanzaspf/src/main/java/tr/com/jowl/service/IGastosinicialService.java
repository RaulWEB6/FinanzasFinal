package tr.com.jowl.service;

import java.util.List;

import tr.com.jowl.model.Gastosinicial;

public interface IGastosinicialService {

	public Integer insertar(Gastosinicial gastosinicial);

	public void eliminar(int idGastosinicial);

	List<Gastosinicial> listar();

	List<Gastosinicial> buscar(int idBanco);
}
