package tr.com.jowl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.jowl.model.Gastosfinal;
import tr.com.jowl.repository.GastosfinalRepository;
import tr.com.jowl.service.IGastosfinalService;

@Service
public class GastosfinalServiceImpl implements IGastosfinalService {

	@Autowired
	private GastosfinalRepository gR;

	@Override
	@Transactional
	public Integer insertar(Gastosfinal gastosfinal) {
		int rpta = 0;
		if (rpta == 0) {
			gR.save(gastosfinal);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void eliminar(int idGastosfinal) {
		gR.deleteById(idGastosfinal);
	}

	@Override
	public List<Gastosfinal> listar() {
		return gR.findAll(Sort.by(Sort.Direction.ASC, "nombreGastosfinal"));
	}

}
