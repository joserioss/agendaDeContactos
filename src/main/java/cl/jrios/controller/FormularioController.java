package cl.jrios.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.entity.Formulario;

@Controller
@RequestMapping("/contactManager")
public class FormularioController {

	private static final Logger logger = LoggerFactory.getLogger(FormularioController.class);

	List<Formulario> datos;

	public FormularioController() {
		datos = new ArrayList<>();
	}

//	Solucion para no mostrar los null al inicio de contactManager
	@RequestMapping(value = "/")
	public String inicio(ModelMap modelo, @ModelAttribute("formulario") Formulario formulario) {
		return "respuestaFormulario";
	} 
	
//	Se realiza al apretar el boton agregar	
	@RequestMapping(value = "/desafio")
	public String porHacer(ModelMap modelo, @ModelAttribute("formulario") Formulario formulario) {

		logger.info("FORM: " + formulario);

		if (formulario != null) {
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

//			String formularioCompleto = "Nombre: " + nombre + " " + apellidoPat + " " + apellidoMat + ", Direccion: "
//					+ direccion + ", telefono: " + telefono;

			datos.add(formulario);
			modelo.put("respuestasFormulario", datos);
		}

		return "respuestaFormulario";

	}
}
