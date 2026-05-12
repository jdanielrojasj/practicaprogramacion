package clases;

public class Idioma {
	
	private String nombre;
	private boolean estaActivo;
	private int horas;
	
	// Constructor sin atributos
	public Idioma(String nombre) {
		this.nombre = nombre;
	}
	
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
	public void desactivarIdioma () {
		this.estaActivo = false;
	}
	
	public void activarIdioma () {
		this.estaActivo = true;
	}
	
}
