package tr.com.jowl.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tr.com.jowl.model.Banco;
import tr.com.jowl.model.Factura;
import tr.com.jowl.model.Gastosfinal;
import tr.com.jowl.model.Gastosinicial;
import tr.com.jowl.service.IBancoService;
import tr.com.jowl.service.IEmpresaService;
import tr.com.jowl.service.IGastosfinalService;
import tr.com.jowl.service.IGastosinicialService;
import tr.com.jowl.service.IUploadFileService;
import tr.com.jowl.service.UserService;

@Controller
@RequestMapping("/bancos")
public class BancoController {

	@Autowired
	private IBancoService bService;

	@Autowired
	private IUploadFileService uploadFileService;

	@Autowired
	private IEmpresaService eService;

	@Autowired
	private UserService uService;

	@Autowired
	private IGastosfinalService gfService;
	
	@Autowired
	private IGastosinicialService giService;

	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "hola/hola";
	}

	@GetMapping("/nuevo")
	public String nuevoBanco(Model model) {
		model.addAttribute("banco", new Banco());
		return "banco/banco";
	}

	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource banco = null;

		try {
			banco = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + banco.getFilename() + "\"")
				.body(banco);
	}

	@PostMapping("/guardar")
	public String guardarBanco(@Valid Banco banco, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "/banco/banco";
		} else {
			if (!foto.isEmpty()) {

				if (banco.getIdBanco() > 0 && banco.getFoto() != null && banco.getFoto().length() > 0) {

					uploadFileService.delete(banco.getFoto());
				}

				String uniqueFilename = null;
				try {
					uniqueFilename = uploadFileService.copy(foto);
				} catch (IOException e) {
					e.printStackTrace();
				}

				flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");
				// addFlashAttribute:el atributo no se agrega al URI pero se almacena en la
				// sesión (dentro del servidor) y están disponibles hasta la primera lectura
				// después de la redirección.
				banco.setFoto(uniqueFilename);
			}
			int rpta = bService.insertar(banco);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe este banco");
				return "/banco/banco";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listaRecursos", bService.listar());
		return "/banco/listaBanco";
	}

	@GetMapping("/listar")
	public String listarBancos(Model model) {
		try {
			model.addAttribute("banco", new Banco());
			model.addAttribute("listaBancos", bService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/banco/listaBanco";
	}

	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Integer id, Map<String, Object> model, RedirectAttributes flash) {
		Optional<Banco> banco = bService.listarId(id);
		if (banco == null) {
			flash.addFlashAttribute("error", "La banco no existe en la base de datos");
			return "banco/listaBanco";
		}
		model.put("banco", banco.get());
		return "factura/factura";
	}

	@GetMapping("/detalle/{id}")
	public String detailsBanco(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirAttrs) {
		try {
			Optional<Banco> detalle = bService.listarId(id);
			if (!detalle.isPresent()) {
				model.addAttribute("info", "Banco no existe");
				return "redirect:/bancos/listar";
			} else {
				model.addAttribute("banco", detalle.get());
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		model.addAttribute("valorBoton", "Guardar");
		model.addAttribute("factura", new Factura());
		model.addAttribute("gastofinal", new Gastosfinal());
		model.addAttribute("gastoinicial", new Gastosinicial());
		model.addAttribute("listaEmpresas", eService.listar());
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("listaGastofinales", gfService.buscar(id));
		model.addAttribute("listaGastoiniciales", giService.buscar(id));
		return "/factura/factura";
	}

}
