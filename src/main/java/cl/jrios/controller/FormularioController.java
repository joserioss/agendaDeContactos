package cl.jrios.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.jrios.entity.Formulario;

@Controller
@RequestMapping("/contactManager")
public class FormularioController {

	private static final Logger logger = LoggerFactory.getLogger(FormularioController.class);

	List<Formulario> datos;

	public FormularioController() {
		datos = new ArrayList<>();
	}

	public List<Formulario> obtenerTodos(){
		return datos;
	}
	
//	Solucion para no mostrar los null al inicio de contactManager
	@RequestMapping(value = {"/", ""})
	public String inicio(ModelMap modelo, @ModelAttribute("formulario") Formulario formulario) {
		return "respuestaFormulario";
	}

//	Se realiza al apretar el boton agregar	
	@RequestMapping(value = "/desafio")
	public String agregar(ModelMap modelo, @ModelAttribute("formulario") Formulario formulario) {

		logger.info("FORM: " + formulario);

		if (formulario != null) {
			int id = datos.size();
			formulario.setId(id);

			String nombre = formulario.getNombre();
			String apellidoPat = formulario.getApellidoPaterno();
			String apellidoMat = formulario.getApellidoMaterno();
			String direccion = formulario.getDireccion();
			String telefono = formulario.getTelefono();

			formulario.setNombre(nombre);
			formulario.setApellidoPaterno(apellidoPat);
			formulario.setApellidoMaterno(apellidoMat);
			formulario.setDireccion(direccion);
			formulario.setTelefono(telefono);

			datos.add(formulario);
			modelo.put("respuestasFormulario", obtenerTodos());
		}

		return "respuestaFormulario";

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String eliminar(ModelMap modelo, @RequestParam(name = "id", required = true) int id) {
		datos.remove(id);
		for (int i = 0; i < datos.size(); i++) {
			datos.get(i).setId(i);
		}
		modelo.put("respuestasFormulario", obtenerTodos());
		
		return "respuestaFormulario";
	}
	
}
