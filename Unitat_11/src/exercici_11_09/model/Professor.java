package exercici_11_09.model;

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
		return super.toString() + " - " + assignatura;
	}

}
