package tr.com.jowl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.jowl.model.Empresa;
import tr.com.jowl.repository.EmpresaRepository;
import tr.com.jowl.service.IEmpresaService;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

	@Autowired
	private EmpresaRepository eR;

	@Override
	@Transactional
	public Integer insertar(Empresa empresa) {
		int rpta = eR.validarRucEmpresa(empresa.getRucEmpresa());
		if (rpta == 0) {
			eR.save(empresa);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void eliminar(int idEmpresa) {
		eR.deleteById(idEmpresa);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empresa> listarId(int idEmpresa) {
		return eR.findById(idEmpresa);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empresa> listar() {
		return eR.findAll(Sort.by(Sort.Direction.ASC, "nombreEmpresa"));
	}

}
