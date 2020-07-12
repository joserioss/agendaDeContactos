package cl.jrios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.jrios.entity.Formulario;

@Service
public class FormularioService implements IFormularioSerivice {

	List<Formulario> formularios;

	public FormularioService() {
		formularios = new ArrayList<>();
	}

	@Override
	public List<Formulario> obtenerTodos() {
		return formularios;
	}

	@Override
	public void agregar(Formulario formulario) {
		if (formulario != null) {
			int id = formularios.size();
			formulario.setId(id);

			formularios.add(formulario);
		}
	}

	@Override
	public void eliminar(int id) {
		formularios.remove(id);
		for (int i = 0; i < formularios.size(); i++) {
			formularios.get(i).setId(i);
		}
	}

}
