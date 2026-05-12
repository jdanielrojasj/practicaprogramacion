package clases;

public class Profesor extends Persona {
	
	// Constante
	private static final double BONO_ANTIGUEDAD = 500.0;
	
	// Atributos
	private double salarioBase = 1000.0;
	private boolean antiguedad;
	private Idioma idioma;
	
	// Contructor con herencia de Persona
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

	// Metodo propio que suma 500 al salario base si antiguedad es TRUE
		public double calcularSalario() {
			if (antiguedad) {
				return salarioBase + BONO_ANTIGUEDAD;
			}
			return salarioBase;
		}
		@Override
		public String toString() {
			return "Profesor [salarioBase=" + salarioBase + ", antiguedad=" + antiguedad + ", idioma=" + idioma
					+ ", calcularSalario()=" + calcularSalario() + ", toString()=" + super.toString() + "]";
		}
		
		
		
		
		
	
}
