package programa;

import clases.GestorAcademia;
import datosPrueba.DatosPrueba;
import menu.Menu;

public class Programa {

	public static void main(String[] args) {

		GestorAcademia academia = new GestorAcademia();

		// Carga datos iniciales (idiomas, alumnos y profesores) 
		DatosPrueba.cargar(academia);

		// Arranca el menu principal
		Menu.menuPrincipal(academia);

	}

}
