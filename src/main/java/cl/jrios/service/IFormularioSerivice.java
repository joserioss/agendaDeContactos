package cl.jrios.service;

import java.util.List;

import cl.jrios.entity.Formulario;

public interface IFormularioSerivice {

	public abstract List<Formulario> obtenerTodos();

	public abstract void agregar(Formulario formulario);

	public abstract void eliminar(int id);

}
