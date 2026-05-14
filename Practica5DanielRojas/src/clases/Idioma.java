package clases;

/**
 * Clase Idioma
 *
 * Representa un idioma que se imparte en la academia. 
 * 
 * La uso tanto para los alumnos (el idioma que estudian) como para los profesores (el idioma
 * que ensenan)
 *
 * Cada idioma tiene un nombre, un estado (activo o no, por si se deja de
 * ofrecer) y unas horas totales del curso
 *
 * @author Daniel
 * @version 1.0
 */
public class Idioma {

	private String nombre;
	private boolean estaActivo;
	private int horas;

	/**
	 * Constructor solo con el nombre
	 * Lo deje por si alguna vez necesito crear un idioma rapido sin los
	 * demas datos, aunque normalmente uso el constructor completo.
	 *
	 * @param nombre nombre del idioma
	 */
	// Constructor sin atributos
	public Idioma(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Constructor con todos los atributos
	 * Es el que se usa normalmente desde el GestorAcademia cuando damos
	 * de alta un idioma nuevo
	 *
	 * @param nombre nombre del idioma
	 * @param estaActivo true si el idioma se imparte actualmente
	 * @param horas horas totales del curso
	 */
	// Constructor con todos los atributos
	public Idioma(String nombre, boolean estaActivo, int horas) {
		this.nombre = nombre;
		this.estaActivo = estaActivo;
		this.horas = horas;
	}
	
	// Setter y Getter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isestaActivo() {
		return estaActivo;
	}

	public void setActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}
	
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	// toString
	@Override
	public String toString() {
		return "Idioma [nombre=" + nombre + ", estaActivo=" + estaActivo + ", horas=" + horas + "]";
	}
	
	// Metodos propios de la clase Idioma

	/**
	 * Desactiva el idioma poniendo el booleano estaActivo a false.
	 * Lo uso cuando un idioma se deja de impartir pero no se borra,
	 * asi se conserva en la lista pero no se ofrece a nuevos alumnos.
	 */
	public void desactivarIdioma () {
		this.estaActivo = false;
	}

	/**
	 * Activa el idioma poniendo el booleano estaActivo a true.
	 * Lo uso cuando se quiere volver a impartir un idioma que estaba
	 * desactivado.
	 */
	public void activarIdioma () {
		this.estaActivo = true;
	}
	
}
