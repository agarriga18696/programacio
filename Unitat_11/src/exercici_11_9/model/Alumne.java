package exercici_11_9.model;

public class Alumne extends Persona {

	// Atributs.
	private static final long serialVersionUID = 1L;
	private String nivell;

	// Constructor.
	public Alumne(String nom, String dni, int edat, String nivell) {
		super(nom, dni, edat);
		this.nivell = nivell;
	}

	// Getters i setters.
	public String getNivell() {
		return nivell;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nom: ").append(this.getNom()).append(" | DNI: ").append(this.getDni()).append(" | Edat: ").append(this.getEdat()).append(" | Nivell: ").append(this.getNivell());

		return sb.toString();
	}

}
