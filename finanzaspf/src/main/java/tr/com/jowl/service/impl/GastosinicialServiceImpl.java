package tr.com.jowl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.jowl.model.Gastosinicial;
import tr.com.jowl.repository.GastoinicialRepository;
import tr.com.jowl.service.IGastosinicialService;

@Service
public class GastosinicialServiceImpl implements IGastosinicialService {

	@Autowired
	private GastoinicialRepository gR;

	@Override
	@Transactional
	public Integer insertar(Gastosinicial gastosinicial) {
		int rpta = 0;
		if (rpta == 0) {
			gR.save(gastosinicial);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void eliminar(int idGastosinicial) {
		gR.deleteById(idGastosinicial);
	}

	@Override
	public List<Gastosinicial> listar() {
		return gR.findAll(Sort.by(Sort.Direction.ASC, "nombreGastosinicial"));
	}

	@Override
	public List<Gastosinicial> buscar(int idBanco) {
		return gR.findByNombreBancoi(idBanco);
	}

}
