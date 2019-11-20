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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tr.com.jowl.model.Empresa;
import tr.com.jowl.model.Factura;
import tr.com.jowl.model.Gastosfinal;
import tr.com.jowl.service.IEmpresaService;
import tr.com.jowl.service.IGastosfinalService;
import tr.com.jowl.service.UserService;

@Controller
@RequestMapping("/gastosfinales")
public class GastosfinalController {

	@Autowired
	private IGastosfinalService gfService;

	@Autowired
	private IEmpresaService eService;

	@Autowired
	private UserService uService;

	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "hola/hola";
	}

	@PostMapping("/guardar")
	public String guardarGastofinal(@Valid Gastosfinal gastosfinal, BindingResult result, Model model,
			SessionStatus status, RedirectAttributes redirAttrs) throws Exception {
		if (result.hasErrors()) {
			return "/factura/factura";
		} else {
			int rpta = gfService.insertar(gastosfinal);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/factura/factura";
			} else {
				model.addAttribute("mensaje", "Su Gasto adicional se registro correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("valorBoton", "Guardar");
		model.addAttribute("listaGastofinales", gfService.listar());
		model.addAttribute("factura", new Factura());
		model.addAttribute("gastofinal", new Gastosfinal());
		model.addAttribute("listaEmpresas", eService.listar());
		model.addAttribute("listaUsuarios", uService.listar());
		return "/factura/factura";
	}

	@GetMapping("/listar")
	public String listarGastofinal(Model model) {
		try {
			model.addAttribute("Gastofinal", new Empresa());
			model.addAttribute("listaGastofinales", gfService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/factura/factura";
	}

}
