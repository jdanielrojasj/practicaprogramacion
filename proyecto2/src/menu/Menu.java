package menu;

import java.util.Scanner;
import clases.Alumno;
import clases.Profesor;
import clases.Idioma;
import clases.GestorAcademia;

public class Menu {

	static Scanner input = new Scanner(System.in);

	// __________________________________________
	//
	// 				MENU PRINCIPAL
	// __________________________________________
	public static void menuPrincipal(GestorAcademia academia) {
		int opcion;
		do {
			System.out.println("* ===== ACADEMIA DE IDIOMAS ===== *");
			System.out.println("1. Idiomas");
			System.out.println("2. Alumnos");
			System.out.println("3. Profesores");
			System.out.println("0. Salir");
			System.out.println("____________________________________");
			opcion = input.nextInt();
			input.nextLine(); 

			switch (opcion) {
				case 1: menuIdiomas(academia);
					break;
				case 2: menuAlumnos(academia);
					break;
				case 3: menuProfesores(academia);
					break;
				case 0: System.out.println(" *** FIN DEL PROGRAMA *** ");
					break;
				default: System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}

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
						System.out.println("No existe el idioma '" + nombre );
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
				}
				case 0: break;
				default: System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}

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
					System.out.print("Sede (Zaragoza/Madrid/Barcelona: ");
					String sede = input.nextLine();
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
				case 0: break;
				default: System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}

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

}
