package clases;

/**
 * Clase Profesor
 *
 * Hereda de Persona igual que Alumno porque un Profesor tambien es una
 * persona, asi reutilizo id, nombre y apellido
 *
 * Cada profesor tiene un salario base (por defecto 1000), un booleano
 * antiguedad que indica si lleva mucho tiempo en la academia, y el
 * idioma que imparte. 
 * 
 * Si tiene antiguedad cobra un bono extra
 *
 * @author Daniel
 * @version 1.0
 */
public class Profesor extends Persona {

	/** Cantidad fija que se suma al salario base cuando el profesor tiene antiguedad. */
	private static final double BONO_ANTIGUEDAD = 500.0;

	// Atributos
	private double salarioBase = 1000.0;
	private boolean antiguedad;
	private Idioma idioma;

	/**
	 * Constructor de Profesor con todos los atributos
	 * Llama a super(...) para inicializar los atributos heredados de Persona
	 * El salarioBase no se pide por parametro porque ya tiene un valor por
	 * defecto de 1000, despues se puede modificar con el setter
	 *
	 * @param id identificador unico del profesor
	 * @param nombre nombre del profesor
	 * @param apellido apellido del profesor
	 * @param antiguedad true si el profesor tiene antiguedad y cobra el bono
	 * @param idioma idioma que imparte el profesor
	 */
	public Profesor(int id, String nombre, String apellido, boolean antiguedad, Idioma idioma) {
		super(id, nombre, apellido);
		this.antiguedad = antiguedad;
		this.idioma = idioma;
	}
	
	// Setter y Getter
	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public boolean isAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(boolean antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

		/**
		 * Metodo propio de Profesor que calcula el salario final del profesor
		 * si el profesor tiene antiguedad le sumo el BONO_ANTIGUEDAD al
		 * salario base, si no, devuelvo solo el salario base
		 *
		 * @return salario total que cobra el profesor (con o sin bono)
		 */
		public double calcularSalario() {
			if (antiguedad) {
				return salarioBase + BONO_ANTIGUEDAD;
			}
			return salarioBase;
		}
		@Override
		public String toString() {
			// Uso idioma.getNombre() en vez de idioma para que solo salga el
			// nombre del idioma y no el toString completo de Idioma.
			return "Profesor " + super.toString()
					+ " salarioBase=" + salarioBase
					+ ", antiguedad=" + antiguedad
					+ ", idioma=" + idioma.getNombre()
					+ ", calcularSalario()=" + calcularSalario()
					;
		}
		/**
		 * Metodo abstracto presentarse heredado de Persona
		 * De momento esta vacio porque para el profesor no se ha definido un
		 * mensaje de presentacion
		 */
		@Override
		public void presentarse() {

		}
		
		
		
		
		
	
}
