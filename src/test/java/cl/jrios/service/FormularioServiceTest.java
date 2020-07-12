package cl.jrios.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.jrios.entity.Formulario;

@SpringBootTest
public class FormularioServiceTest {

	private static Formulario formulario;
	
	@Autowired
	private FormularioService servicio;
	
	@BeforeAll
	public static void previoAPrueba001(){
		formulario = new Formulario();
		formulario.setId(1);
		formulario.setNombre("Juan");
		formulario.setApellidoPaterno("Cardenas");
		formulario.setApellidoMaterno("Ramirez");
		formulario.setDireccion("caleta brava");
		formulario.setTelefono("98765123");
	}
	
	@Test
	@DisplayName(value = "prueba de ingreso de valores")
	public void prueba001(){
		servicio.agregar(formulario);
		assertEquals(1, servicio.obtenerTodos().size());
	}
	
	@Test
	@DisplayName(value = "prueba de lectura de apellido materno")
	public void prueba002(){
		assertEquals("Ramirez", formulario.getApellidoMaterno());
	}
	
}
