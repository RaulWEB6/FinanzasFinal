package tr.com.jowl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.jowl.model.Factura;
import tr.com.jowl.repository.FacturaRepository;
import tr.com.jowl.service.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private FacturaRepository fR;

	@Override
	@Transactional
	public Integer insertar(Factura factura) {
		int rpta = 0;
		if (rpta == 0) {
			fR.save(factura);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void modificar(Factura factura) {
		fR.save(factura);
	}

	@Override
	public List<Factura> listar() {
		return fR.findAll(Sort.by(Sort.Direction.ASC, "idFactura"));
	}

	@Override
	public Optional<Factura> listarId(int idFactura) {
		return fR.findById(idFactura);
	}

}
