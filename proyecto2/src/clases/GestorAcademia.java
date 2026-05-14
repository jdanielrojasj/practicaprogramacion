package clases;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase GestorAcademia.
 *
 * Es la clase principal donde gestiono toda la academia. Aqui guardo las
 * tres listas (idiomas, alumnos y profesores) y tengo todos los metodos
 * para dar de alta, listar, buscar, modificar y eliminar.
 *
 * He preferido tener una sola clase gestora en vez de una por cada tipo
 * porque asi tengo todo centralizado y desde el Menu solo trabajo con
 * un objeto academia.
 *
 * @author Dani
 * @version 1.0
 */
public class GestorAcademia {

	/**
	 * Idioma especial "Sin asignar" que uso para reasignar a los alumnos y
	 * profesores cuando se elimina un idioma de la academia. Es static final
	 * para que exista uno solo y todos los huerfanos apunten al mismo objeto.
	 * Lo creo con estaActivo=false y horas=0 porque no es un idioma real.
	 */
	public static final Idioma IDIOMA_SIN_ASIGNAR = new Idioma("Sin asignar", false, 0);

	// declaro ArrayList de cada clase
	ArrayList<Alumno> listaAlumnos;
	ArrayList<Profesor> listaProfesores;
	ArrayList<Idioma> listaIdiomas;
	// Lista de sedes como Strings. Las gestiono dinamicamente para poder
	// dar de alta y eliminar sedes en tiempo de ejecucion en vez de
	// tenerlas hardcodeadas en el menu.
	ArrayList<String> listaSedes;

	/**
	 * Constructor de GestorAcademia.
	 * Inicializa las tres listas vacias para poder ir anadiendo elementos
	 * despues. Si no las inicializo aqui daria NullPointerException al
	 * intentar hacer .add() sobre una lista null.
	 */
	// constructor
	public GestorAcademia () {
		listaAlumnos = new ArrayList<Alumno>();
		listaProfesores = new ArrayList<Profesor>();
		listaIdiomas = new ArrayList<Idioma>();
		listaSedes = new ArrayList<String>();
	}
	// __________________________________________
	//
	// 					IDIOMAS 
	// __________________________________________
	
	/**
	 * Da de alta un idioma nuevo en la academia.
	 * Crea un objeto Idioma con los datos que llegan por parametro y lo
	 * mete en el ArrayList listaIdiomas.
	 *
	 * @param nombre nombre del idioma
	 * @param estaActivo true si se imparte actualmente
	 * @param horas horas totales del curso
	 */
	// altaIdioma: recibe los parametros y crea una nueva variable con ellos, luego lo añade al ArrayList listaIdiomas
	public void altaIdioma(String nombre, boolean estaActivo, int horas) {
			Idioma nuevoIdioma = new Idioma (nombre,estaActivo,horas);
			listaIdiomas.add(nuevoIdioma);
	}

	
	/**
	 * Lista todos los idiomas de la academia.
	 * Recorro el ArrayList con un for-each e imprimo cada idioma que no sea
	 * null. Compruebo null por si acaso, aunque en teoria no deberia haber.
	 */
	// listarIdiomas: Recorre el ArrayList e imprime las posiciones que no son null
	public void listarIdiomas() {
		for (Idioma idioma : listaIdiomas) {
			if (idioma != null) {
				System.out.println(idioma);
			}
		}
	}

	/**
	 * Lista solo los idiomas que estan activos.
	 * Lo uso por ejemplo al dar de alta un alumno, para mostrarle solo los
	 * idiomas en los que se puede matricular. Filtro con isestaActivo().
	 */
	// listarIdiomas: Recorre el ArrayList e imprime los idiomas que estan activos
		public void listarIdiomasDisponibles() {
			for (Idioma idioma : listaIdiomas) {
				if (idioma != null && idioma.isestaActivo()) {
					System.out.println(idioma);
				}
			}
		}

	/**
	 * Busca un idioma por su nombre.
	 * Uso equalsIgnoreCase para que no diferencie entre mayusculas y
	 * minusculas (asi "Ingles" e "ingles" se consideran iguales).
	 * Si lo encuentra devuelve el objeto Idioma, si no devuelve null.
	 *
	 * @param nombre nombre del idioma a buscar
	 * @return el Idioma encontrado o null si no existe
	 */
	// buscarIdioma: Recibe el nombre del idioma y lo busca dentro de listaIdiomas con equalsIgnoreCase, si lo encuentra devuelve el idioma
	public Idioma buscarIdioma(String nombre) {
		for (Idioma idioma : listaIdiomas) {
			if (idioma != null && idioma.getNombre().equalsIgnoreCase(nombre)) {
				return idioma;
			}
		}
		return null;
	}
	
	
	/**
	 * Elimina un idioma del ArrayList por su nombre.
	 * Aqui uso Iterator en vez de un for-each porque si intentas borrar un
	 * elemento de la lista mientras la recorres con for-each te lanza
	 * ConcurrentModificationException. Con el Iterator y su .remove() se
	 * hace de forma segura.
	 * Tambien aprovecho para desactivar el idioma antes de quitarlo.
	 *
	 * @param nombre nombre del idioma que se quiere eliminar
	 */
	// eliminarIdioma
			public void eliminarIdioma (String nombre) {
				boolean encontrado = false;
				Iterator<Idioma> iteradorIdiomas = listaIdiomas.iterator();
				while (iteradorIdiomas.hasNext()) {
					Idioma idioma = iteradorIdiomas.next();
					if (idioma.getNombre().equalsIgnoreCase(nombre)) {
						iteradorIdiomas.remove();
						System.out.println("Idioma "+nombre + " eliminado");
						listarIdiomas();
						encontrado = true;
						break;
					}
				}
				if (!encontrado) {
					System.out.println("No existe ningun idioma con nombre '" + nombre);
					return;
				}
				// Igual que con eliminarSede, recorro alumnos y profesores
				// que tenian el idioma eliminado y les pongo IDIOMA_SIN_ASIGNAR
				// para que no queden apuntando a un idioma que ya no existe
				// en la academia.
				int alumnosAfectados = 0;
				for (Alumno alumno : listaAlumnos) {
					if (alumno.getIdioma() != null
							&& alumno.getIdioma().getNombre().equalsIgnoreCase(nombre)) {
						alumno.setIdioma(IDIOMA_SIN_ASIGNAR);
						alumnosAfectados++;
					}
				}
				int profesoresAfectados = 0;
				for (Profesor profesor : listaProfesores) {
					if (profesor.getIdioma() != null
							&& profesor.getIdioma().getNombre().equalsIgnoreCase(nombre)) {
						profesor.setIdioma(IDIOMA_SIN_ASIGNAR);
						profesoresAfectados++;
					}
				}
				if (alumnosAfectados > 0) {
					System.out.println(alumnosAfectados + " alumno(s) reasignado(s) a 'Sin asignar'");
				}
				if (profesoresAfectados > 0) {
					System.out.println(profesoresAfectados + " profesor(es) reasignado(s) a 'Sin asignar'");
				}
			}

	/**
	 * Activa un idioma buscandolo primero por nombre.
	 * En vez de cambiar yo aqui el booleano, delego en el metodo
	 * activarIdioma() de la clase Idioma. Asi cumplo con la encapsulacion:
	 * la clase Idioma es la que sabe como activarse a si misma.
	 *
	 * @param nombre nombre del idioma a activar
	 */
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

	/**
	 * Desactiva un idioma buscandolo primero por nombre.
	 * Mismo planteamiento que activarIdioma pero al reves: delego en el
	 * metodo desactivarIdioma() de la clase Idioma.
	 *
	 * @param nombre nombre del idioma a desactivar
	 */
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
	
	/**
	 * Devuelve el idioma con mas horas de curso de toda la lista.
	 * Cojo el primer idioma como referencia y voy comparando con un for.
	 * Si encuentro uno con igual o mas horas, lo guardo en masHoras.
	 * Asi al final me quedo con el que tiene mas horas.
	 *
	 * @return el Idioma con mayor numero de horas
	 */
	// Metodo que permite mostrar el idioma con mas horas
			public Idioma idiomaConMasHoras() {
				// Si no hay idiomas devuelvo null para evitar IndexOutOfBoundsException
				// al hacer get(0). Asi el Menu se encarga de avisar al usuario.
				if (listaIdiomas.isEmpty()) {
					return null;
				}
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
			
			/**
			 * Muestra solo el nombre de los idiomas activos en una sola linea.
			 * A diferencia de listarIdiomasDisponibles, este metodo imprime
			 * unicamente el nombre (no el toString completo) y lo uso en la
			 * cabecera del menu principal para que se vea limpio.
			 * Si la lista esta vacia, o si tiene idiomas pero todos estan
			 * desactivados, avisa con un mensaje. Para el segundo caso uso
			 * un booleano auxiliar hayIdiomaActivo.
			 */
			// Mostrar el nombre de los idiomas que estan disponibles
			public void mostrarNombresIdiomasDisponibles() {
			    if (listaIdiomas.isEmpty()) {
			        System.out.println("No hay idiomas disponibles");
			    } else {
			        boolean hayIdiomaActivo = false;
			        for (Idioma idioma : listaIdiomas) {
			            if (idioma.isestaActivo()) {
			                System.out.print(idioma.getNombre() + " " );
			                hayIdiomaActivo = true;
			            }
			        }
			        if (!hayIdiomaActivo) {
			            System.out.println("No hay idiomas disponibles");
			        }
			    }
			}
			
	// __________________________________________
	//
	// 					ALUMNOS 
	// __________________________________________
	
	/**
	 * Da de alta un alumno nuevo en la academia.
	 * Crea un objeto Alumno con los parametros recibidos y lo anade a
	 * listaAlumnos. El idioma viene ya como objeto (no como String) porque
	 * desde el Menu lo busco antes con buscarIdioma() para asegurarme de
	 * que existe.
	 *
	 * @param id identificador unico del alumno
	 * @param nombre nombre del alumno
	 * @param apellido apellido del alumno
	 * @param sede sede donde estudia
	 * @param nivel nivel del curso
	 * @param idioma idioma que va a estudiar
	 */
	// altaAlumno: recibe los parametros y crea una nueva variable con ellos, luego lo añade al ArrayList listaAlumnos
	public void altaAlumno (int id, String nombre, String apellido, String sede, String nivel, Idioma idioma)  {

			Alumno nuevoAlumno = new Alumno(id,nombre,apellido,sede,nivel,idioma);
			listaAlumnos.add(nuevoAlumno);

	}
	
	
	/**
	 * Lista por consola todos los alumnos de la academia.
	 * Igual que en listarIdiomas, recorro con for-each y compruebo null
	 * por seguridad antes de imprimir.
	 */
	// listarAlumnos
		public void listarAlumnos() {
			for (Alumno alumno : listaAlumnos) {
				if (alumno != null) {
					System.out.println(alumno);
				}
			}
		}
		
	/**
	 * Busca un alumno por su id.
	 * Como el id es un int uso == para comparar, no .equals() (eso es para
	 * objetos). Si lo encuentra devuelve el Alumno, si no, devuelve null.
	 *
	 * @param id id del alumno a buscar
	 * @return el Alumno encontrado o null si no existe
	 */
	// buscarAlumno
		public Alumno buscarAlumno(int id) {
			for (Alumno alumno : listaAlumnos) {
				if (alumno != null && alumno.getId() == id) {
					return alumno;
				}
			}
			return null;
		}
		
	/**
	 * Elimina un alumno del ArrayList buscandolo por id.
	 * Igual que en eliminarIdioma uso Iterator para no tener problemas con
	 * la modificacion concurrente al borrar mientras recorro. Uso una
	 * variable booleana "encontrado" para saber si lo borre o no y mostrar
	 * un mensaje distinto al final.
	 *
	 * @param id id del alumno a eliminar
	 */
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

	/**
	 * Modifica la sede de un alumno buscandolo por id.
	 * Primero lo busco con buscarAlumno() para no repetir el codigo del
	 * bucle. Si existe le cambio la sede con su setter, si no, aviso por
	 * consola.
	 *
	 * @param id id del alumno
	 * @param nuevaSede nueva sede a asignar
	 */
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

	/**
	 * Gradua al alumno con el id indicado.
	 * Lo busca y delega en el metodo graduarAlumno() de la clase Alumno,
	 * que es quien sabe que atributos tiene que cambiar (enCurso, graduado).
	 *
	 * @param id id del alumno a graduar
	 */
	// graduarAlumno: busca el alumno por id y GRADUA al Alumno
		public void graduarAlumno (int id) {
			Alumno alumno = buscarAlumno(id);
			if (alumno == null) {
				System.out.println("No existe ningun alumno con id " + id);
			} else {
				alumno.graduarAlumno();
			}
		}
	/**
	 * Expulsa al alumno con el id indicado.
	 * Igual que graduarAlumno pero llamando al metodo expulsarAlumno() del
	 * objeto Alumno. Despues muestra un mensaje recordando que ya no
	 * pertenece a la academia.
	 *
	 * @param id id del alumno a expulsar
	 */
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
		
		/**
		 * Llama al metodo presentarse() del alumno con el id indicado.
		 * Es un wrapper que hice para poder llamarlo comodamente desde
		 * el Menu sin tener que sacar primero el alumno con buscarAlumno().
		 *
		 * @param id id del alumno que se presenta
		 */
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

	/**
	 * Da de alta un profesor nuevo en la academia.
	 * Misma logica que altaAlumno: creo el objeto Profesor con los datos
	 * recibidos y lo anado a listaProfesores. El salarioBase queda en su
	 * valor por defecto (1000) hasta que se modifique con su setter.
	 *
	 * @param id identificador unico del profesor
	 * @param nombre nombre del profesor
	 * @param apellido apellido del profesor
	 * @param antiguedad true si tiene antiguedad y le toca bono
	 * @param idioma idioma que imparte
	 */
	// altaProfesor: recibe los parametros y crea una nueva variable con ellos, luego lo añade al ArrayList listaProfesores
		public void altaProfesor (int id, String nombre, String apellido, boolean antiguedad, Idioma idioma) {
			Profesor nuevoProfesor = new Profesor(id, nombre, apellido, antiguedad, idioma);
			listaProfesores.add(nuevoProfesor);
		}

	/**
	 * Lista por consola todos los profesores de la academia.
	 * Funciona igual que listarAlumnos y listarIdiomas.
	 */
	// listarProfesores
		public void listarProfesores() {
			for (Profesor profesor : listaProfesores) {
				if (profesor != null) {
					System.out.println(profesor);
				}
			}
		}

	/**
	 * Busca un profesor por su id.
	 * Misma logica que buscarAlumno pero recorriendo listaProfesores.
	 *
	 * @param id id del profesor a buscar
	 * @return el Profesor encontrado o null si no existe
	 */
	// buscarProfesor
		public Profesor buscarProfesor(int id) {
			for (Profesor profesor : listaProfesores) {
				if (profesor != null && profesor.getId() == id) {
					return profesor;
				}
			}
			return null;
		}

	/**
	 * Elimina un profesor del ArrayList por su id.
	 * Misma forma de hacerlo que eliminarAlumno e eliminarIdioma: Iterator
	 * para borrar de forma segura mientras se recorre la lista.
	 *
	 * @param id id del profesor a eliminar
	 */
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

	/**
	 * Modifica el sueldo base de un profesor buscandolo por id.
	 * Cambia solo salarioBase. El bono por antiguedad se calcula a parte
	 * con el metodo calcularSalario() de la propia clase Profesor.
	 *
	 * @param id id del profesor
	 * @param nuevoSueldo nuevo salario base a asignar
	 */
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

	// __________________________________________
	//
	// 					SEDES
	// __________________________________________

	/**
	 * Da de alta una sede nueva en la academia.
	 * Antes de anadirla compruebo con buscarSede() si ya existe para no
	 * tener sedes duplicadas. Uso equalsIgnoreCase dentro de buscarSede
	 * para no diferenciar mayusculas.
	 *
	 * @param nombre nombre de la sede a dar de alta
	 */
		public void altaSede (String nombre) {
			if (buscarSede(nombre) != null) {
				System.out.println("La sede " + nombre + " ya existe");
			} else {
				listaSedes.add(nombre);
			}
		}

	/**
	 * Busca una sede por su nombre.
	 * Devuelve el String si lo encuentra (util para confirmar que existe)
	 * o null si no esta en la lista. Comparo con equalsIgnoreCase para
	 * que "madrid" y "Madrid" se consideren la misma sede.
	 *
	 * @param nombre nombre de la sede a buscar
	 * @return el nombre de la sede encontrado o null si no existe
	 */
		public String buscarSede (String nombre) {
			for (String sede : listaSedes) {
				if (sede.equalsIgnoreCase(nombre)) {
					return sede;
				}
			}
			return null;
		}

	/**
	 * Elimina una sede del ArrayList por su nombre.
	 * Uso Iterator para borrar de forma segura mientras se recorre.
	 *
	 * Como en Alumno el atributo sede es un String (una copia, no una
	 * referencia), al borrar la sede de la lista los alumnos seguirian
	 * teniendo el nombre antiguo en su atributo. Para evitar esto, despues
	 * de quitar la sede recorro listaAlumnos y a los que tenian esa sede
	 * les pongo "Sin asignar". Asi al listarlos se ve claramente que se
	 * quedaron sin sede.
	 *
	 * @param nombre nombre de la sede a eliminar
	 */
		public void eliminarSede (String nombre) {
			boolean encontrado = false;
			Iterator<String> iteradorSedes = listaSedes.iterator();
			while (iteradorSedes.hasNext()) {
				String sede = iteradorSedes.next();
				if (sede.equalsIgnoreCase(nombre)) {
					iteradorSedes.remove();
					System.out.println("Sede " + nombre + " eliminada");
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				System.out.println("No existe ninguna sede con nombre " + nombre);
				return;
			}
			// Actualizo los alumnos que tenian esa sede para que no queden
			// con un nombre de sede que ya no existe.
			int afectados = 0;
			for (Alumno alumno : listaAlumnos) {
				if (alumno.getSede().equalsIgnoreCase(nombre)) {
					alumno.setSede("Sin asignar");
					afectados++;
				}
			}
			if (afectados > 0) {
				System.out.println(afectados + " alumno(s) quedaron como 'Sin asignar'");
			}
		}

	/**
	 * Muestra por consola las sedes disponibles.
	 * Si la lista esta vacia avisa con un mensaje, si no, las imprime
	 * una por linea. Lo uso desde el submenu de sedes para listarlas
	 * y al dar de alta un alumno para mostrar las opciones.
	 */
		public void mostrarSedesDisponibles () {
			if (listaSedes.isEmpty()) {
				System.out.println("No hay sedes disponibles");
			} else {
				for (String sede : listaSedes) {
					System.out.print(sede + " ");
				}
			}
		}
}
