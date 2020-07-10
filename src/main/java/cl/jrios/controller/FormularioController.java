package cl.jrios.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.entity.FormularioDesafio;

@Controller
@RequestMapping("/contactManager")
public class FormularioController {

	private static final Logger logger = LoggerFactory.getLogger(FormularioController.class);

	List<String> datos;

	public FormularioController() {
		datos = new ArrayList<>();
	}

//	Solucion para no mostrar los null al inicio de contactManager
	@RequestMapping(value = "/")
	public String inicio(ModelMap modelo, @ModelAttribute("formulario") FormularioDesafio formulario) {
		return "respuestaFormulario";
	} 
	
//	Se realiza al apretar el boton agregar	
	@RequestMapping(value = "/desafio")
	public String porHacer(ModelMap modelo, @ModelAttribute("formulario") FormularioDesafio formulario) {

		logger.info("FORM: " + formulario);

		if (formulario != null) {
			String nombre = formulario.getNombre();
			String apellidoPat = formulario.getApellidoPaterno();
			String apellidoMat = formulario.getApellidoMaterno();
			String direccion = formulario.getDireccion();
			String telefono = formulario.getTelefono();

			String formularioCompleto = "Nombre: " + nombre + " " + apellidoPat + " " + apellidoMat + ", Direccion: "
					+ direccion + ", telefono: " + telefono;

			datos.add(formularioCompleto);
			modelo.put("respuestasFormulario", datos);
		}

		return "respuestaFormulario";

	}
}
