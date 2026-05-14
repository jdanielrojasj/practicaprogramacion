package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Alumno;
import clases.Idioma;

public class AlumnoTest {

	Alumno alumnoTest;
	Idioma idiomaPrueba;

	@BeforeEach
	void setUp() {
		idiomaPrueba = new Idioma("Ingles", true, 120);
		alumnoTest = new Alumno(1, "Lucia", "Garcia", "Madrid", "Basico", idiomaPrueba);
	}

	@Test
	void testDatosBasicosAlumno() {
		assertEquals(1, alumnoTest.getId());
		assertEquals("Lucia", alumnoTest.getNombre());
		assertEquals("Garcia", alumnoTest.getApellido());
		assertEquals("Madrid", alumnoTest.getSede());
		assertEquals("Basico", alumnoTest.getNivel());
		assertEquals(idiomaPrueba, alumnoTest.getIdioma());
	}

	@Test
	void testAlumnoEmpiezaEnCurso() {
		assertTrue(alumnoTest.isEnCurso());
		assertFalse(alumnoTest.isGraduado());
	}

	@Test
	void testGraduarAlumno() {
		alumnoTest.graduarAlumno();
		assertFalse(alumnoTest.isEnCurso());
		assertTrue(alumnoTest.isGraduado());
	}

	@Test
	void testExpulsarAlumno() {
		alumnoTest.expulsarAlumno();
		assertFalse(alumnoTest.isEnCurso());
		assertFalse(alumnoTest.isGraduado());
	}

	@Test
	void testCambiarSede() {
		alumnoTest.setSede("Barcelona");
		assertEquals("Barcelona", alumnoTest.getSede());
	}

	@Test
	void testCambiarIdioma() {
		Idioma frances = new Idioma("Frances", true, 80);
		alumnoTest.setIdioma(frances);
		assertEquals(frances, alumnoTest.getIdioma());
		assertEquals("Frances", alumnoTest.getIdioma().getNombre());
	}

	@Test
	void testSetterEnCursoYGraduado() {
		alumnoTest.setEnCurso(false);
		alumnoTest.setGraduado(true);
		assertFalse(alumnoTest.isEnCurso());
		assertTrue(alumnoTest.isGraduado());
	}
}
