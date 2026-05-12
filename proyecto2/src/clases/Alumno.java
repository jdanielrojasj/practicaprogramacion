package clases;

public class Alumno extends Persona {
	private String sede;   // Madrid, Barcelona, Zaragoza
	private String nivel;  // Basico, Intermedio, Avanzado
	private Idioma idioma; 
	private boolean enCurso = true;
	private boolean graduado = false;
	
	// Constructor con todos los atributos, incluidos los heredados de la clase Persona
	public Alumno (int id, String nombre, String apellido, String sede, String nivel, Idioma idioma) {
		super (id,nombre,apellido);
		this.sede=sede;
		this.nivel=nivel;
		this.idioma=idioma;
	}

	// Getter y Setter
	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	public boolean isEnCurso() {
		return enCurso;
	}

	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}
	
	public void graduarAlumno () {
		this.enCurso = false;
		this.graduado = true;
		System.out.println("Este alumno se ha graduado, ¡FELICIDADES!");
	}

	// toString
	@Override
	public String toString() {
		return "Alumno " + super.toString() + "[sede=" + sede + ", nivel=" + nivel + "]" + ", enCurso=" + enCurso
				+ ", graduado=" + graduado + ", idioma=" + idioma;
	}

}
