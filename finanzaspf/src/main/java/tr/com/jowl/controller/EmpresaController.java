package tr.com.jowl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import tr.com.jowl.model.Empresa;
import tr.com.jowl.service.IEmpresaService;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private IEmpresaService eService;

	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "hola/hola";
	}

	@GetMapping("/nuevo")
	public String nuevaEmpresa(Model model) {
		model.addAttribute("empresa", new Empresa());
		return "empresa/empresa";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() 
	{
		return "/nosotros";
	}

	@PostMapping("/guardar")
	public String guardarEmpresa(@Valid Empresa empresa, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "/empresa/empresa";
		} else {
			int rpta = eService.insertar(empresa);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe la empresa con ese RUC");
				return "/empresa/empresa";
			} else {
				model.addAttribute("mensaje", "Su empresa se registro correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listaEmpresas", eService.listar());
		return "/empresa/empresa";
	}

	@GetMapping("/listar")
	public String listarEmpresas(Model model) {
		try {
			model.addAttribute("empresa", new Empresa());
			model.addAttribute("listaEmpresas", eService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/empresa/listaEmpresa";
	}
}
