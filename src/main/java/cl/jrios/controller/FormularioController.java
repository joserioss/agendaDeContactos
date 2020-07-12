package cl.jrios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.jrios.entity.Formulario;
import cl.jrios.service.FormularioService;

@Controller
@RequestMapping("/contactManager")
public class FormularioController {

	private static final Logger logger = LoggerFactory.getLogger(FormularioController.class);

	@Autowired
	private FormularioService servicio;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String inicio(ModelMap modelo) {
		modelo.put("respuestasFormulario", servicio.obtenerTodos());
		return "respuestaFormulario";
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST)
	public String agregar(ModelMap modelo, @ModelAttribute("formulario") Formulario formulario) {

		servicio.agregar(formulario);

		logger.info("FORM: " + formulario);
		modelo.put("respuestasFormulario", servicio.obtenerTodos());

		return "respuestaFormulario";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String eliminar(ModelMap modelo, @RequestParam(name = "id", required = true) int id) {
		servicio.eliminar(id);
		modelo.put("respuestasFormulario", servicio.obtenerTodos());

		return "respuestaFormulario";
	}

}
