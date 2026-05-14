package programa;

import clases.GestorAcademia;
import datosPrueba.DatosPrueba;
import menu.Menu;

/**
 * Clase Programa
 *
 * Es la clase principal del proyecto, aqui esta el main y desde aqui se
 * arranca todo. La he dejado lo mas limpia posible, solo crea el objeto
 * academia, carga los datos de prueba y llama al menu. 
 * Toda la logica esta en las demas clases
 *
 * @author Daniel
 * @version 1.0
 */
public class Programa {

	/** 
	 * Dentro del main se crea un GestorAcademia vacio, 
	 * Luego se le cargan los datos iniciales para no tener que dar de alta todo a mano 
	 * cada vez que se ejecuta. 
	 * Luego lanza el menu principal que es el que interactua con el usuario
	 */
	public static void main(String[] args) {

		GestorAcademia academia = new GestorAcademia();

		// Carga datos iniciales (idiomas, alumnos y profesores)
		DatosPrueba.cargar(academia);
		
		System.out.println("─▌█──║─║╔═║─║─╔═╗─");
		System.out.println("─███─╠═╣╠═║─║─║─║─");
		System.out.println("─▐█▐─║─║╚═╚═╚═╚═╝─");
		System.out.println("─▐▐───────────────");
		System.out.println("─▐▐───────────────");
		
	
		// Arranca el menu principal
		Menu.menuPrincipal(academia);

	}

}
