package datosPrueba;

import clases.GestorAcademia;
import clases.Idioma;

public class DatosPrueba {

	// Carga idiomas, alumnos y profesores de prueba para arrancar el programa con datos
	public static void cargar(GestorAcademia academia) {
		// Sedes
		academia.altaSede("Madrid");
		academia.altaSede("Barcelona");
		academia.altaSede("Zaragoza");

		// Idiomas
		academia.altaIdioma("Ingles",true,100);
		academia.altaIdioma("Frances",true,80);
		academia.altaIdioma("Aleman",true,200);
		academia.altaIdioma("Italiano",false,60);
		academia.altaIdioma("Chino",true, 500);

		// Uso buscarIdioma pasandole el nombre como parametro para crear los Idiomas con los idiomas que ya di de alta
		Idioma ingles  = academia.buscarIdioma("Ingles");
		Idioma frances = academia.buscarIdioma("Frances");
		Idioma aleman  = academia.buscarIdioma("Aleman");
		Idioma italiano  = academia.buscarIdioma("Italiano");
		Idioma chino  = academia.buscarIdioma("Chino");

		// Alumnos
		academia.altaAlumno(1, "Lucia","Garcia","Madrid","Basico",ingles);
		academia.altaAlumno(2, "Mateo","Fernandez","Barcelona","Intermedio",frances);
		academia.altaAlumno(3, "Sofia","Lopez","Zaragoza","Avanzado",aleman);
		academia.altaAlumno(4, "Daniel","Martinez","Madrid","Intermedio",ingles);
		academia.altaAlumno(5, "Carla","Ruiz","Barcelona","Basico",frances);
		academia.altaAlumno(6, "Giacomo","Perro","Zaragoza","Basico",chino);
		academia.altaAlumno(7, "Giorgio","Panini","Madrid","Basico",italiano);

		// Profesores 
		academia.altaProfesor(101,"Ana","Sanchez",true,ingles);
		academia.altaProfesor(102,"Carlos","Perez",false,frances);
		academia.altaProfesor(103,"Elena","Gomez",true,aleman);
		academia.altaProfesor(104,"Javier","Diaz",false,ingles);
		academia.altaProfesor(105,"Marta","Navarro",true,frances);
		academia.altaProfesor(106,"Juan","Dominguez",true,chino);
	}
}
