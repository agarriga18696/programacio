package exercici_11_9.model;

public class Professor extends Persona {

	// Atributs.
	private static final long serialVersionUID = 1L;
	private String assignatura;

	// Constructor.
	public Professor(String nom, String dni, int edat, String assignatura) {
		super(nom, dni, edat);
		this.assignatura = assignatura;
	}

	// Getters i setters.
	public String getAssignatura() {
		return assignatura;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nom: ").append(this.getNom()).append(" | DNI: ").append(this.getDni()).append(" | Edat: ").append(this.getEdat()).append(" | Nivell: ").append(this.getAssignatura());

		return sb.toString();
	}

}
