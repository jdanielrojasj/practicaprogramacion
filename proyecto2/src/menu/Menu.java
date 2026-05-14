package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import clases.Alumno;
import clases.Profesor;
import clases.Idioma;
import clases.GestorAcademia;

/**
 * Clase Menu
 *
 * Aqui esta toda la interaccion por consola con el usuario. La he puesto
 * en una clase aparte para que el main quede limpio y para separar la logica de GestorAcademia
 * de la interfaz por consola
 *
 * Tiene un menu principal con tres submenus (idiomas, alumnos y
 * profesores). Cada submenu lleva sus opciones de alta, listar, buscar,
 * eliminar y modificar
 *
 * Todos los metodos son static porque no necesito crear un objeto Menu,
 * los llamo directamente desde Programa
 *
 * @author Daniel
 * @version 1.0
 */
public class Menu {

	/** Scanner estatico para leer datos por teclado en todos los menus */
	static Scanner input = new Scanner(System.in);

	/**
	 * Menu principal del programa
	 * Muestra las tres opciones (idiomas, alumnos, profesores) y derivan a
	 * su submenu correspondiente. Uso un do-while para que el menu se
	 * repita hasta que el usuario meta 0 para salir.
	 * El input.nextLine() despues de cada nextInt() lo pongo para limpiar el buffer
	 *
	 * @param academia objeto GestorAcademia con todos los datos cargados
	 */
	// __________________________________________
	//
	// 				MENU PRINCIPAL
	// __________________________________________
	public static void menuPrincipal(GestorAcademia academia) {
		// Inicializo opcion a -1 para que si el try/catch no le asigna valor
		// (porque el usuario tecleo mal), no quede sin inicializar.
		int opcion = -1;
		do {
			System.out.println("==============================================");
			System.out.println(" *========|| ACADEMIA DE IDIOMAS ||========*");
			System.out.println("==============================================");
			System.out.println("Bienvenido a la academia de idiomas Idio+");
			System.out.print("Nuestros idiomas disponibles son: ");
			academia.mostrarNombresIdiomasDisponibles();
			System.out.println();
			System.out.print("Tenemos sedes en: ");
			academia.mostrarSedesDisponibles();
			System.out.println();
			System.out.println("_________________________________________________");
			System.out.println("Gestion de Idiomas, Usuarios y Profesores");
			System.out.println("1. Idiomas");
			System.out.println("2. Alumnos");
			System.out.println("3. Profesores");
			System.out.println("4. Sedes");
			System.out.println("0. Salir");
			System.out.println("_________________________________________________");
			// Envuelvo la lectura en try/catch para que si el usuario teclea
			// texto en vez de un numero, el programa no se caiga con
			// InputMismatchException. En el catch limpio el buffer con
			// input.nextLine() porque si no, el caracter mal tecleado se queda
			// dentro del Scanner y entrariamos en un bucle infinito de
			// excepciones. Pongo opcion = -1 para que el switch caiga en el
			// default y el do-while vuelva a pedir el dato.
			try {
				opcion = input.nextInt();
				input.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("Tienes que escribir un numero (1,2,3,4 ó 0 para salir)");
				input.nextLine();
				opcion = -1;
			}

			switch (opcion) {
				case 1: menuIdiomas(academia);
					break;
				case 2: menuAlumnos(academia);
					break;
				case 3: menuProfesores(academia);
					break;
				case 4: menuSedes(academia);
					break;
				case 0: System.out.println(" *** FIN DEL PROGRAMA *** ");
				System.out.println("░░░░░░░░░░░░░░░░░░░░░░█████████░░░░░░░░░");
				System.out.println("░░███████░░░░░░░░░░███▒▒▒▒▒▒▒▒███░░░░░░░");
				System.out.println("░░█▒▒▒▒▒▒█░░░░░░░███▒▒▒▒▒▒▒▒▒▒▒▒▒███░░░░");
				System.out.println("░░░█▒▒▒▒▒▒█░░░░██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░");
				System.out.println("░░░░█▒▒▒▒▒█░░░██▒▒▒▒▒██▒▒▒▒▒▒██▒▒▒▒▒███░");
				System.out.println("░░░░░█▒▒▒█░░░█▒▒▒▒▒▒████▒▒▒▒████▒▒▒▒▒▒██");
				System.out.println("░░░█████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██");
				System.out.println("░░░█▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒██");
				System.out.println("░██▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒██▒▒▒▒▒▒▒▒▒▒██▒▒▒▒██");
				System.out.println("██▒▒▒███████████▒▒▒▒▒██▒▒▒▒▒▒▒▒██▒▒▒▒▒██");
				System.out.println("█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒████████▒▒▒▒▒▒▒██");
				System.out.println("██▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░");
				System.out.println("░█▒▒▒███████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██░░░");
				System.out.println("░██▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█░░░░░");
				System.out.println("░░████████████░░░█████████████████░░░░░░");
					break;
				default: System.out.println("Vuelve a intentarlo");
			}
		} while (opcion != 0);
	}

	/**
	 * Submenu de idiomas.
	 * Permite dar de alta, listar, buscar, eliminar, activar, desactivar
	 * y ver el idioma con mas horas. Cada opcion llama al metodo
	 * correspondiente del GestorAcademia.
	 *
	 * @param academia objeto GestorAcademia donde se operan los cambios
	 */
	// __________________________________________
	//
	// 				SUBMENU IDIOMAS
	// __________________________________________
	public static void menuIdiomas(GestorAcademia academia) {
		int opcion;
		do {
			System.out.println("--- IDIOMAS ---");
			System.out.println("1. Alta");
			System.out.println("2. Listar");
			System.out.println("3. Buscar");
			System.out.println("4. Eliminar");
			System.out.println("5. Activar");
			System.out.println("6. Desactivar");
			System.out.println("7. Idioma con mas horas");
			System.out.println("0. Volver");
			System.out.println("____________________________________");
			opcion = input.nextInt();
			input.nextLine(); 

			switch (opcion) {
				case 1: { // alta idioma
					System.out.print("Nombre del idioma: ");
					String nombre = input.nextLine();
					System.out.print("Esta activo (true/false): ");
					boolean activo = input.nextBoolean();
					System.out.print("Horas del curso: ");
					int horas = input.nextInt();
					input.nextLine(); 
					// Recibo por teclado el nombre, si esta activo o no y la cantidad de horas, luego se crea con altaIdioma y esos parametros
					academia.altaIdioma(nombre, activo, horas);
					break;
				}
				case 2: // listar idiomas
					academia.listarIdiomas();
					break;
				case 3: { // buscar idioma
					System.out.print("Nombre del idioma a buscar: ");
					String nombre = input.nextLine();
					Idioma idioma = academia.buscarIdioma(nombre);
					// Recibo por teclado el nombre del idioma y lo busco con el metodo buscarIdioma(nombre)
					if (idioma == null) {
						// Si es null muestra por pantalla que no existe el idioma ingresado por teclado
						System.out.println("No existe el idioma " + nombre );
					} else {
						// Si existe lo devuelve
						System.out.println(idioma);
					}
					break;
				}
				case 4: { // eliminar idioma
					System.out.print("Nombre del idioma a eliminar: ");
					String nombre = input.nextLine();
					// Recibo por teclado el nombre del idioma a eliminar
					academia.eliminarIdioma(nombre);
					// Metodo eliminarIdioma recibe como parametro el nombre introducido por teclado
					break;
				}
				case 5: { // activar idioma
					System.out.print("Nombre del idioma a activar: ");
					String nombre = input.nextLine();
					// Recibo por teclado el nombre del idioma a activar
					academia.activarIdioma(nombre);
					// activarIdioma recibe el nombre como parametro y lo activa
					break;
				}
				case 6: { // desactivar idioma
					System.out.print("Nombre del idioma a desactivar: ");
					String nombre = input.nextLine();
					// Recibo por teclado el nombre del idioma a desactivar
					academia.desactivarIdioma(nombre);
					// desactivarIdioma recibe el nombre como parametro y lo desactiva
					break;
				} case 7 :{ // Idioma con mas horas
					// Si la lista de idiomas esta vacia el metodo devuelve null,
					// asi que aviso al usuario en vez de imprimir "null"
					Idioma masHoras = academia.idiomaConMasHoras();
					if (masHoras == null) {
						System.out.println("No hay idiomas dados de alta.");
					} else {
						System.out.println(masHoras);
					}
					break;
				}
				case 0: break;
				default: System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}

	/**
	 * Submenu de alumnos
	 * Permite dar de alta, listar, buscar, eliminar, modificar la sede,
	 * graduar, expulsar y presentar al alumno por id.
	 * En el alta primero llamo a listarIdiomasDisponibles() para que el
	 * usuario sepa que idiomas puede asignar, y a buscarIdioma() para
	 * verificar que el idioma escrito existe antes de crear el alumno.
	 *
	 * @param academia objeto GestorAcademia donde se operan los cambios
	 */
	// __________________________________________
	//
	// 				SUBMENU ALUMNOS
	// __________________________________________
	public static void menuAlumnos(GestorAcademia academia) {
		int opcion;
		do {
			System.out.println("--- ALUMNOS ---");
			System.out.println("1. Alta");
			System.out.println("2. Listar");
			System.out.println("3. Buscar");
			System.out.println("4. Eliminar");
			System.out.println("5. Modificar sede");
			System.out.println("6. Graduar");
			System.out.println("7. Expulsar");
			System.out.println("8. Presentar alumno por ID");
			System.out.println("0. Volver");
			System.out.println("____________________________________");
			opcion = input.nextInt();
			input.nextLine();

			switch (opcion) {
				case 1: { // alta alumno
					System.out.print("Id: ");
					int id = input.nextInt();
					input.nextLine();
					System.out.print("Nombre: ");
					String nombre = input.nextLine();
					System.out.print("Apellido: ");
					String apellido = input.nextLine();
					System.out.println("Sedes disponibles:");
					academia.mostrarSedesDisponibles();
					System.out.print("Sede: ");
					String sede = input.nextLine();
					// Verifico que la sede tecleada exista en la lista.
					// Si no existe, cancelo el alta para no crear alumnos
					// con sedes que no estan dadas de alta.
					if (academia.buscarSede(sede) == null) {
						System.out.println("No existe la sede '" + sede + "'. Alta cancelada.");
						break;
					}
					System.out.print("Nivel (Basico/Intermedio/Avanzado): ");
					String nivel = input.nextLine();
					System.out.println("Idiomas disponibles:");
					academia.listarIdiomasDisponibles();
					System.out.print("Idioma a asignar: ");
					String nombreIdioma = input.nextLine();
					// Leo el idioma y verifico que exista uno con ese nombre
					Idioma idioma = academia.buscarIdioma(nombreIdioma);
					if (idioma == null) {
						// Si no existe lo muestra por consola
						System.out.println("No existe el idioma '" + nombreIdioma + "'. Alta cancelada.");
					} else {
						// Si existe el idioma lo añade usando el metodo altaAlumno con los parametros introducidos por teclado
						academia.altaAlumno(id, nombre, apellido, sede, nivel, idioma);
						System.out.println("Alumno dado de alta");
					}
					break;
				}
				case 2: // listar alumnos
					academia.listarAlumnos();
					break;
				case 3: { // buscar alumno
					System.out.print("Id del alumno a buscar: ");
					int id = input.nextInt();
					input.nextLine();
					Alumno alumno = academia.buscarAlumno(id);
					if (alumno == null) {
						System.out.println("No existe el alumno con id: " + id );
					} else {
						System.out.println(alumno);
					}
					break;
				}
				case 4: { // eliminar alumno
					System.out.print("Id del alumno a eliminar: ");
					int id = input.nextInt();
					input.nextLine();
					academia.eliminarAlumno(id);
					break;
				}
				case 5: { // modificar sede
					System.out.print("Id del alumno: ");
					int id = input.nextInt();
					input.nextLine();
					System.out.print("Nueva sede: ");
					String nuevaSede = input.nextLine();
					academia.modificarSedeAlumno(id, nuevaSede);
					break;
				}
				case 6: { // graduar alumno
					System.out.print("Id del alumno a graduar: ");
					int id = input.nextInt();
					input.nextLine();
					academia.graduarAlumno(id);
					break;
				}
				case 7: { // expulsar alumno
					System.out.print("Id del alumno a expulsar: ");
					int id = input.nextInt();
					input.nextLine();
					academia.expulsarAlumno(id);
					academia.eliminarAlumno(id);
					break;
				}
				case 8: { // presentarse
					System.out.print("Id del alumno a presentar: ");
					int id = input.nextInt();
					input.nextLine();
					academia.presentarAlumno(id);
					break;
				}
				case 0: 
					break;
				default: System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}

	/**
	 * Submenu de profesores.
	 * Permite dar de alta, listar, buscar, eliminar y modificar el sueldo.
	 * Funciona igual que menuAlumnos, pero llamando a los metodos de
	 * profesor del GestorAcademia.
	 *
	 * @param academia objeto GestorAcademia donde se operan los cambios
	 */
	// __________________________________________
	//
	// 				SUBMENU PROFESORES
	// __________________________________________
	public static void menuProfesores(GestorAcademia academia) {
		int opcion;
		do {
			System.out.println("--- PROFESORES ---");
			System.out.println("1. Alta");
			System.out.println("2. Listar");
			System.out.println("3. Buscar");
			System.out.println("4. Eliminar");
			System.out.println("5. Modificar sueldo");
			System.out.println("0. Volver");
			System.out.println("____________________________________");
			opcion = input.nextInt();
			input.nextLine(); // 

			switch (opcion) {
				case 1: { // alta profesor
					System.out.print("Id: ");
					int id = input.nextInt();
					input.nextLine();
					System.out.print("Nombre: ");
					String nombre = input.nextLine();
					System.out.print("Apellido: ");
					String apellido = input.nextLine();
					System.out.print("Tiene antiguedad (true/false): ");
					boolean antiguedad = input.nextBoolean();
					input.nextLine();
					System.out.println("Idiomas disponibles: ");
					academia.listarIdiomas();
					System.out.print("Idioma a asignar: ");
					String nombreIdioma = input.nextLine();
					Idioma idioma = academia.buscarIdioma(nombreIdioma);
					if (idioma == null) {
						System.out.println("No existe el idioma '" + nombreIdioma + "'. Alta cancelada");
					} else {
						academia.altaProfesor(id, nombre, apellido, antiguedad, idioma);
						System.out.println("Profesor dado de alta");
					}
					break;
				}
				case 2: // listar profesores
					academia.listarProfesores();
					break;
				case 3: { // buscar profesor
					System.out.print("Id del profesor a buscar: ");
					int id = input.nextInt();
					input.nextLine();
					Profesor profesor = academia.buscarProfesor(id);
					if (profesor == null) {
						System.out.println("No existe el profesor con id " + id + ".");
					} else {
						System.out.println(profesor);
					}
					break;
				}
				case 4: { // eliminar profesor
					System.out.print("Id del profesor a eliminar: ");
					int id = input.nextInt();
					input.nextLine();
					// Recibo el id del profesor a elminar por teclado y se lo paso como parametro al metodo eliminarProfesor
					academia.eliminarProfesor(id);
					break;
				}
				case 5: { // modificar sueldo
					System.out.print("Id del profesor: ");
					int id = input.nextInt();
					input.nextLine();
					System.out.print("Nuevo sueldo: ");
					double nuevoSueldo = input.nextDouble();
					input.nextLine();
					// Recibo el id y el nuevo sueldo por teclado y se lo paso al metodo modificarSueldoProfesor
					academia.modificarSueldoProfesor(id, nuevoSueldo);
					break;
				}
				case 0: break;
				default: System.out.println("Opcion no valida.");
			}
		} while (opcion != 0);
	}

	/**
	 * Submenu de sedes.
	 * Permite dar de alta, listar y eliminar sedes en tiempo de ejecucion.
	 * Las sedes son simples Strings dentro de un ArrayList<String> en
	 * GestorAcademia, asi me evito crear una clase Sede solo para esto.
	 *
	 * @param academia objeto GestorAcademia donde se operan los cambios
	 */
	// __________________________________________
	//
	// 				SUBMENU SEDES
	// __________________________________________
	public static void menuSedes(GestorAcademia academia) {
		int opcion;
		do {
			System.out.println("--- SEDES ---");
			System.out.println("1. Alta");
			System.out.println("2. Listar");
			System.out.println("3. Eliminar");
			System.out.println("0. Volver");
			System.out.println("____________________________________");
			opcion = input.nextInt();
			input.nextLine();

			switch (opcion) {
				case 1: { // alta sede
					System.out.print("Nombre de la nueva sede: ");
					String nombre = input.nextLine();
					academia.altaSede(nombre);
					break;
				}
				case 2: // listar sedes
					academia.mostrarSedesDisponibles();
					break;
				case 3: { // eliminar sede
					System.out.print("Nombre de la sede a eliminar: ");
					String nombre = input.nextLine();
					academia.eliminarSede(nombre);
					break;
				}
				case 0: break;
				default: System.out.println("Opcion no valida.");
			}
		} while (opcion != 0);
	}

}
