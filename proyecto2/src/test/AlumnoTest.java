package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import clases.Alumno;
import clases.Idioma;

public class AlumnoTest {
	
	static Alumno alumnoTest;
	static Idioma idiomaPrueba;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
        idiomaPrueba = new Idioma("Inglés", true, 120);
        alumnoTest = new Alumno(1, "Lucia", "Garcia", "Madrid", "Basico", idiomaPrueba);
    }
	
	@Test
	void testDatosBasicosAlumno () {
		assertEquals(1, alumnoTest.getId());
        assertEquals("Lucia", alumnoTest.getNombre());
        assertEquals("Garcia", alumnoTest.getApellido());
        assertEquals("Madrid", alumnoTest.getSede());
        assertEquals("Basico", alumnoTest.getNivel());
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
}