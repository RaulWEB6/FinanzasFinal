package tr.com.jowl.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tr.com.jowl.model.Factura;
import tr.com.jowl.service.IFacturaService;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

	@Autowired
	private IFacturaService fService;

	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "hola/hola";
	}

	@GetMapping("/detalle/{id}")
	public String detallesFactura(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirAttrs) {
		try {
			Optional<Factura> detalle = fService.listarId(id);
			if (!detalle.isPresent()) {
				model.addAttribute("mensaje", "Factura no existe");
				return "redirect:/facturas/bienvenido";
			} else {
				model.addAttribute("factura", detalle.get());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		model.addAttribute("valorBoton", "Guardar");
		model.addAttribute("factura", new Factura());
		return "/factura/factura";
	}
}
