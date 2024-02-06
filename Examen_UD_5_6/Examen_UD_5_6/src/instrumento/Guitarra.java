package instrumento;

public class Guitarra extends InstrumentoMusical implements Tocable, Afinable, Transportable {
	
	private int numeroCuerdas;
	
	// Constructor
	public Guitarra(String nombre, String material, int anioFabricacion, int numeroCuerdas) {
		super(nombre, material, anioFabricacion);
		
		this.numeroCuerdas = numeroCuerdas;
	}

	// Getters
	public int getNumeroCuerdas() {
		return numeroCuerdas;
	}

	// Método toString
	@Override
	public String toString() {
		return "\n 🎸 " + this.getNombre() + " | " + this.getMaterial() + " | "
				+ this.getAnioFrabricacion() + " | " + numeroCuerdas;
	}

	@Override
	public String tocar() {
		return "\n Tocando la guitarra " + this.getNombre() + " 🎸";
	}

	@Override
	public String afinar() {
		return "\n Afinando la guitarra " + this.getNombre() + " 🛠️";
	}

	@Override
	public String empaquetar() {
		return "\n Empaquetando la guitarra " + this.getNombre() + " 📥 ...";
	}

	@Override
	public String desempaquetar() {
		return "\n Desempaquetando la guitarra " + this.getNombre() + " 📤 ...";
	}
	
}
