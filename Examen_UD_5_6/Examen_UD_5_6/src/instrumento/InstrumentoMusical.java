package instrumento;

public abstract class InstrumentoMusical {

	private String nombre;
	private String material;
	private int anioFrabricacion;
	
	// Constructor
	public InstrumentoMusical(String nombre, String material, int anioFabricacion) {
		this.nombre = nombre;
		this.material = material;
		this.anioFrabricacion = anioFabricacion;
	}
	
	// Getters
	public String getNombre() {
		return nombre;
	}

	public String getMaterial() {
		return material;
	}

	public int getAnioFrabricacion() {
		return anioFrabricacion;
	}

	// Método toString
	public abstract String toString();
	
}
