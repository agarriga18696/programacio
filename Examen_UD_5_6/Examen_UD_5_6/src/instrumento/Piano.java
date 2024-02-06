package instrumento;

public class Piano extends InstrumentoMusical implements Tocable, Afinable {

	private boolean esPianoDeCola;

	// Constructor
	public Piano(String nombre, String material, int anioFabricacion, boolean esPianoDeCola) {
		super(nombre, material, anioFabricacion);

		this.esPianoDeCola = esPianoDeCola;
	}

	// Getters
	public boolean isEsPianoDeCola() {
		return esPianoDeCola;
	}
	
	// Método toString
	@Override
	public String toString() {
		String pianoDeCola = esPianoDeCola ? "SI" : "NO";
		
		return "\n 🎹 " + this.getNombre() + " | " + this.getMaterial() + " | "
				+ this.getAnioFrabricacion() + " | " + pianoDeCola;
	}

	@Override
	public String tocar() {
		return "\n Tocando el piano " + this.getNombre() + " 🎹";
	}

	@Override
	public String afinar() {
		return "\n Afinando el piano " + this.getNombre() + " 🛠️";
	}

}
