package clases;

import java.time.LocalDate;

/**
 * Clase Alumno
 *
 * Hereda de Persona porque un Alumno es una persona, asi reutilizo los
 * atributos id, nombre y apellido sin tener que volver a declararlos
 *
 * Ademas de lo heredado, el Alumno tiene su sede (Madrid, Barcelona o
 * Zaragoza), un nivel (Basico, Intermedio o Avanzado), el idioma que
 * estudia y dos booleanos para saber si esta en curso o ya se graduo.
 *
 * @author Daniel
 * @version 1.0
 */
public class Alumno extends Persona {
	private String sede;   // Madrid, Barcelona, Zaragoza
	private String nivel;  // Basico, Intermedio, Avanzado
	private Idioma idioma;
	private boolean enCurso = true;
	private boolean graduado = false;


	/**
	 * Constructor de Alumno con todos los atributos
	 * Llama a super(...) para inicializar los atributos heredados de Persona
	 * (id, nombre y apellido) y luego asigna los propios de Alumno
	 * Los booleanos enCurso y graduado se inicializan por defecto (true y false)
	 * porque un alumno recien dado de alta siempre esta en curso
	 *
	 * @param id identificador unico del alumno
	 * @param nombre nombre del alumno
	 * @param apellido apellido del alumno
	 * @param sede sede donde estudia (Madrid, Barcelona o Zaragoza)
	 * @param nivel nivel del curso (Basico, Intermedio o Avanzado)
	 * @param idioma idioma que estudia el alumno
	 */
	public Alumno (int id, String nombre, String apellido, String sede, String nivel, Idioma idioma) {
		super (id,nombre,apellido);
		this.sede=sede;
		this.nivel=nivel;
		this.idioma=idioma;
	}

	// Setter y Getter
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
	
	/**
	 * Metodo propio de alumno que Gradua al alumno
	 * Pone enCurso a false porque ya termino y graduado a true porque aprobo
	 */
	public void graduarAlumno () {
		this.enCurso = false;
		this.graduado = true;
		System.out.println("Este alumno se ha graduado, ¡FELICIDADES!");
	}

	/**
	 * Expulsa al alumno.
	 * Tambien deja enCurso en false pero graduado en false porque no termino
	 * Es distinto a graduarAlumno aunque las dos saquen al alumno del curso.
	 */
	public void expulsarAlumno () {
		this.enCurso = false;
		this.graduado = false;
		System.out.println("Este alumno ha sido expulsado :( ");
	}

	// toString
	@Override
	public String toString() {
		// Uso idioma.getNombre() en vez de idioma para que solo salga el nombre
		// y no el toString completo de Idioma con todos sus atributos
		return "Alumno " + super.toString() + "[sede=" + sede + ", nivel=" + nivel + "]" + ", enCurso=" + enCurso
				+ ", graduado=" + graduado + ", idioma=" + idioma.getNombre();
	}

	/**
	 * Implementacion del metodo abstracto presentarse heredado de Persona
	 * En el caso del alumno muestra su nombre, la fecha actual y el idioma
	 * que esta estudiando. Uso LocalDate.now() para que coja la fecha del dia
	 */
	@Override
	public void presentarse() {
		LocalDate fechaHoy = LocalDate.now();
		System.out.println("Hola soy " + nombre + " y hoy "+ fechaHoy + " tengo clases de " + idioma.getNombre());

	}

}
