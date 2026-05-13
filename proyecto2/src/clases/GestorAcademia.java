package clases;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorAcademia {
	
	// declaro ArrayList de cada clase
	ArrayList<Alumno> listaAlumnos;
	ArrayList<Profesor> listaProfesores;
	ArrayList<Idioma> listaIdiomas;
	
	// constructor
	public GestorAcademia () {
		listaAlumnos = new ArrayList<Alumno>();
		listaProfesores = new ArrayList<Profesor>();
		listaIdiomas = new ArrayList<Idioma>();
	}
	// __________________________________________
	//
	// 					IDIOMAS 
	// __________________________________________
	
	// altaIdioma: recibe los parametros y crea una nueva variable con ellos, luego lo añade al ArrayList listaIdiomas
	public void altaIdioma(String nombre, boolean estaActivo, int horas) {
			Idioma nuevoIdioma = new Idioma (nombre,estaActivo,horas);
			listaIdiomas.add(nuevoIdioma);
	}

	
	// listarIdiomas: Recorre el ArrayList e imprime las posiciones que no son null
	public void listarIdiomas() {
		for (Idioma idioma : listaIdiomas) {
			if (idioma != null) {
				System.out.println(idioma);
			}
		}
	}
	
	// listarIdiomas: Recorre el ArrayList e imprime los idiomas que estan activos
		public void listarIdiomasDisponibles() {
			for (Idioma idioma : listaIdiomas) {
				if (idioma != null && idioma.isestaActivo()) {
					System.out.println(idioma);
				}
			}
		}
	
	
	// buscarIdioma: Recibe el nombre del idioma y lo busca dentro de listaIdiomas con equalsIgnoreCase, si lo encuentra devuelve el idioma
	public Idioma buscarIdioma(String nombre) {
		for (Idioma idioma : listaIdiomas) {
			if (idioma != null && idioma.getNombre().equalsIgnoreCase(nombre)) {
				return idioma;
			}
		}
		return null;
	}
	
	
	// eliminarIdioma
			public void eliminarIdioma (String nombre) {
				boolean encontrado = false;
				Iterator<Idioma> iteradorIdiomas = listaIdiomas.iterator();
				while (iteradorIdiomas.hasNext()) {
					Idioma idioma = iteradorIdiomas.next();
					if (idioma.getNombre().equalsIgnoreCase(nombre)) {
						iteradorIdiomas.remove();
						// Si se elimia el idioma tambien se desactiva
						idioma.desactivarIdioma();
						System.out.println("Idioma "+nombre + " eliminado");
						listarIdiomas();
						encontrado = true;
						break;
					}
				}
				if (!encontrado) {
					System.out.println("No existe ningun idioma con nombre '" + nombre);
				}
			}

	// activarIdioma: busca el idioma por nombre y delega en el metodo propio de la clase Idioma
			public void activarIdioma (String nombre) {
				Idioma idioma = buscarIdioma(nombre);
				if (idioma == null) {
					System.out.println("No existe ningun idioma con nombre '" + nombre);
				} else {
					idioma.activarIdioma();
					System.out.println("Idioma " + nombre + " activado");
				}
			}

	// desactivarIdioma: busca el idioma por nombre y delega en el metodo propio de la clase Idioma
			public void desactivarIdioma (String nombre) {
				Idioma idioma = buscarIdioma(nombre);
				if (idioma == null) {
					System.out.println("No existe ningun idioma con nombre '" + nombre);
				} else {
					idioma.desactivarIdioma();
					System.out.println("Idioma " + nombre + " desactivado");
				}
			}
	
	// Metodo que permite mostrar el idioma con mas horas
			public Idioma idiomaConMasHoras() {
				// creo una variable que servira para comparar 
			    Idioma masHoras = listaIdiomas.get(0);
			    // Recorro el ArrrayList con un for y comparo uno por uno
			    for (int i = 1; i < listaIdiomas.size(); i++) {
			        if (listaIdiomas.get(i).getHoras() >= masHoras.getHoras()) {
			        	// Guardo el mayor
			        	masHoras = listaIdiomas.get(i);
			        }
			    }
			    	// Devuelvo el idioma con mas horas con todos sus datos
			    return masHoras;
			}
	
	// __________________________________________
	//
	// 					ALUMNOS 
	// __________________________________________
	
	// altaAlumno: recibe los parametros y crea una nueva variable con ellos, luego lo añade al ArrayList listaAlumnos
	public void altaAlumno (int id, String nombre, String apellido, String sede, String nivel, Idioma idioma)  {
		
			Alumno nuevoAlumno = new Alumno(id,nombre,apellido,sede,nivel,idioma);
			listaAlumnos.add(nuevoAlumno);
		
	}
	
	
	// listarAlumnos
		public void listarAlumnos() {
			for (Alumno alumno : listaAlumnos) {
				if (alumno != null) {
					System.out.println(alumno);
				}
			}
		}
		
	// buscarAlumno
		public Alumno buscarAlumno(int id) {
			for (Alumno alumno : listaAlumnos) {
				if (alumno != null && alumno.getId() == id) {
					return alumno;
				}
			}
			return null;
		}
		
	// eliminarAlumno
		public void eliminarAlumno (int id) {
			boolean encontrado = false;
			Iterator<Alumno> iteradorAlumnos = listaAlumnos.iterator();
			while (iteradorAlumnos.hasNext()) {
				Alumno alumno = iteradorAlumnos.next();
				if (alumno.getId() == id) {
					iteradorAlumnos.remove();
					System.out.println("Alumno eliminado");
					listarAlumnos();
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				System.out.println("No existe ningun alumno con id " + id);
			}
		}

	// modificarSedeAlumno: busca el alumno por id y le cambia la sede
		public void modificarSedeAlumno (int id, String nuevaSede) {
			Alumno alumno = buscarAlumno(id);
			if (alumno == null) {
				System.out.println("No existe ningun alumno con id " + id + ".");
			} else {
				alumno.setSede(nuevaSede);
				System.out.println("Sede del alumno " + id + " modificada a " + nuevaSede);
			}
		}

	// graduarAlumno: busca el alumno por id y GRADUA al Alumno
		public void graduarAlumno (int id) {
			Alumno alumno = buscarAlumno(id);
			if (alumno == null) {
				System.out.println("No existe ningun alumno con id " + id);
			} else {
				alumno.graduarAlumno();
			}
		}
	// expulsarAlumno: busca el alumno por id y EXPULSA al Alumno
		public void expulsarAlumno (int id) {
			Alumno alumno = buscarAlumno(id);
			if (alumno == null) {
				System.out.println("No existe ningun alumno con id " + id);
			} else {
				alumno.expulsarAlumno();
				
				System.out.println(alumno.getNombre() + " ya no pertenece a la Academia");
			}
		}
		
		// Metodo de Alumno Presentarse
				public void presentarAlumno (int id) {
					Alumno alumno = buscarAlumno(id);
					if (alumno == null) {
						System.out.println("No existe ningun alumno con id " + id);
					} else {
						alumno.presentarse();
					}
				}

	// __________________________________________
	//
	// 					PROFESORES
	// __________________________________________

	// altaProfesor: recibe los parametros y crea una nueva variable con ellos, luego lo añade al ArrayList listaProfesores
		public void altaProfesor (int id, String nombre, String apellido, boolean antiguedad, Idioma idioma) {
			Profesor nuevoProfesor = new Profesor(id, nombre, apellido, antiguedad, idioma);
			listaProfesores.add(nuevoProfesor);
		}

	// listarProfesores
		public void listarProfesores() {
			for (Profesor profesor : listaProfesores) {
				if (profesor != null) {
					System.out.println(profesor);
				}
			}
		}

	// buscarProfesor
		public Profesor buscarProfesor(int id) {
			for (Profesor profesor : listaProfesores) {
				if (profesor != null && profesor.getId() == id) {
					return profesor;
				}
			}
			return null;
		}

	// eliminarProfesor
		public void eliminarProfesor (int id) {
			boolean encontrado = false;
			Iterator<Profesor> iteradorProfesores = listaProfesores.iterator();
			while (iteradorProfesores.hasNext()) {
				Profesor profesor = iteradorProfesores.next();
				if (profesor.getId() == id) {
					iteradorProfesores.remove();
					System.out.println("Profesor eliminado");
					listarProfesores();
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				System.out.println("No existe ningun profesor con id " + id);
			}
		}

	// modificarSueldoProfesor: busca el profesor por id y le cambia el salario base
		public void modificarSueldoProfesor (int id, double nuevoSueldo) {
			Profesor profesor = buscarProfesor(id);
			if (profesor == null) {
				System.out.println("No existe ningun profesor con id " + id);
			} else {
				profesor.setSalarioBase(nuevoSueldo);
				System.out.println("Sueldo del profesor " + id + " modificado a " + nuevoSueldo);
			}
		}

}
