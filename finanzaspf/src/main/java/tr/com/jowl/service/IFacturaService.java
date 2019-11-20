package tr.com.jowl.service;

import java.util.List;
import java.util.Optional;

import tr.com.jowl.model.Factura;

public interface IFacturaService {

	public Integer insertar(Factura factura);

	public void modificar(Factura factura);

	List<Factura> listar();

	Optional<Factura> listarId(int idFactura);
}
