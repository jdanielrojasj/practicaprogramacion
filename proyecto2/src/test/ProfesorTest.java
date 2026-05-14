package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Idioma;
import clases.Profesor;

public class ProfesorTest {

	Profesor profesorTest;
	Idioma idiomaPrueba;

	@BeforeEach
	void setUp() {
		idiomaPrueba = new Idioma("Ingles", true, 100);
		profesorTest = new Profesor(101, "Ana", "Sanchez", false, idiomaPrueba);
	}

	@Test
	void testDatosBasicosProfesor() {
		assertEquals(101, profesorTest.getId());
		assertEquals("Ana", profesorTest.getNombre());
		assertEquals("Sanchez", profesorTest.getApellido());
		assertFalse(profesorTest.isAntiguedad());
		assertEquals(idiomaPrueba, profesorTest.getIdioma());
	}

	@Test
	void testSalarioBasePorDefecto() {
		assertEquals(1000.0, profesorTest.getSalarioBase());
	}

	@Test
	void testCalcularSalarioSinAntiguedad() {
		assertEquals(1000.0, profesorTest.calcularSalario());
	}

	@Test
	void testCalcularSalarioConAntiguedad() {
		profesorTest.setAntiguedad(true);
		assertEquals(1500.0, profesorTest.calcularSalario());
	}

	@Test
	void testCambiarSalarioBase() {
		profesorTest.setSalarioBase(2000.0);
		assertEquals(2000.0, profesorTest.getSalarioBase());
		assertEquals(2000.0, profesorTest.calcularSalario());
		profesorTest.setAntiguedad(true);
		assertEquals(2500.0, profesorTest.calcularSalario());
	}

	@Test
	void testCambiarIdioma() {
		Idioma frances = new Idioma("Frances", true, 80);
		profesorTest.setIdioma(frances);
		assertEquals(frances, profesorTest.getIdioma());
		assertEquals("Frances", profesorTest.getIdioma().getNombre());
	}
}
