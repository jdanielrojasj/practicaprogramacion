package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Idioma;

public class IdiomaTest {

	Idioma idiomaTest;

	@BeforeEach
	void setUp() {
		idiomaTest = new Idioma("Ingles", true, 100);
	}

	@Test
	void testDatosBasicosIdioma() {
		assertEquals("Ingles", idiomaTest.getNombre());
		assertTrue(idiomaTest.isestaActivo());
		assertEquals(100, idiomaTest.getHoras());
	}

	@Test
	void testConstructorSoloNombre() {
		Idioma soloNombre = new Idioma("Aleman");
		assertEquals("Aleman", soloNombre.getNombre());
		assertFalse(soloNombre.isestaActivo());
		assertEquals(0, soloNombre.getHoras());
	}

	@Test
	void testDesactivarIdioma() {
		idiomaTest.desactivarIdioma();
		assertFalse(idiomaTest.isestaActivo());
	}

	@Test
	void testActivarIdioma() {
		idiomaTest.desactivarIdioma();
		assertFalse(idiomaTest.isestaActivo());
		idiomaTest.activarIdioma();
		assertTrue(idiomaTest.isestaActivo());
	}

	@Test
	void testSettersNombreYHoras() {
		idiomaTest.setNombre("Frances");
		idiomaTest.setHoras(80);
		assertEquals("Frances", idiomaTest.getNombre());
		assertEquals(80, idiomaTest.getHoras());
	}

	@Test
	void testSetActivo() {
		idiomaTest.setActivo(false);
		assertFalse(idiomaTest.isestaActivo());
		idiomaTest.setActivo(true);
		assertTrue(idiomaTest.isestaActivo());
	}
}
