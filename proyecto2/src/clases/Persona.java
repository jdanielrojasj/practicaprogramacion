package clases;

/**
 * Clase abstracta Persona.
 *
 * La hago abstracta porque no quiero que se puedan crear objetos Persona
 * directamente, sino solo a traves de las clases hijas (Alumno y Profesor).
 * Aqui guardo los atributos que comparten todas las personas de la academia:
 * id, nombre y apellido
 *
 * @author Daniel
 * @version 1.0
 */
public abstract class Persona {
	//Atributos protected porque seran heredados por las clases hijas
		protected int id;
		protected String nombre;
		protected String apellido;

		/**
		 * Metodo abstracto presentarse
		 * Cada clase hija (Alumno y Profesor) tendra que implementarlo a su manera
		 * porque un alumno no se presenta igual que un profesor
		 */
		public abstract void presentarse () ;

		/**
		 * Constructor vacio
		 * Inicializa los atributos con valores por defecto por si lo necesito
		 */
		public Persona() {
			this.id = 0;
			this.nombre = "";
			this.apellido = "";
		}
		/**
		 * Constructor con todos los atributos de Persona
		 * Es el que usan las clases hijas con super(...) para no repetir codigo
		 *
		 * @param id identificador unico de la persona
		 * @param nombre nombre de la persona
		 * @param apellido apellido de la persona
		 */
		// Constructor con todos los atributos
		public Persona(int id, String nombre, String apellido) {
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
		}
		
		// Setter y Getter
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		
		// toString
		@Override
		public String toString() {
			return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
		}
		
}
