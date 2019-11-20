package tr.com.jowl.service;

import java.util.List;
import java.util.Optional;

import tr.com.jowl.model.Empresa;

public interface IEmpresaService {

	public Integer insertar(Empresa empresa);

	public void eliminar(int idEmpresa);

	Optional<Empresa> listarId(int idEmpresa);

	List<Empresa> listar();
}
