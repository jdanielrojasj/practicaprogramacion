package clases;

public abstract class Persona {
	//Atributos protected porque seran heredados por las clases hijas
		protected int id;
		protected String nombre;
		protected String apellido;
		
		public abstract void presentarse () ;
		
		// Constructor sin atributos
		public Persona() {
			this.id = 0;
			this.nombre = "";
			this.apellido = "";
		}
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
