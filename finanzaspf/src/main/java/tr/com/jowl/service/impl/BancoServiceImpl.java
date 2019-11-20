package tr.com.jowl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.jowl.model.Banco;
import tr.com.jowl.repository.BancoRepository;
import tr.com.jowl.service.IBancoService;

@Service
public class BancoServiceImpl implements IBancoService {

	@Autowired
	private BancoRepository bR;

	@Override
	@Transactional
	public Integer insertar(Banco banco) {
		int rpta = bR.validarRucBanco(banco.getRucBanco());
		if (rpta == 0) {
			bR.save(banco);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void modificar(Banco banco) {
		bR.save(banco);
	}

	@Override
	@Transactional
	public void eliminar(int idBanco) {
		bR.deleteById(idBanco);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Banco> listarId(int idBanco) {
		return bR.findById(idBanco);
	}

	@Override
	public List<Banco> listar() {
		return bR.findAll(Sort.by(Sort.Direction.ASC, "nombreBanco"));
	}

}
