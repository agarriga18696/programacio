package Exercici_10_08;

public class Professor extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributs del professor.
	private String assignatura;
	
	public Professor(String nom, String dni, int edat, String assignatura) {
		super(nom, dni, edat);
		this.assignatura = assignatura;
	}

	// Classe per mostrar les dades.
	public void mostrarDades() {
		Msg.simple("Nom: " + this.getNom());
		Msg.simple("DNI: " + this.getDni());
		Msg.simple("Edat: " + this.getEdat());
		Msg.simple("Assignatura: " + this.getAssignatura());
		IU.saltLinia();
	}

	// Getters i setters.
	public String getAssignatura() {
		return assignatura;
	}
	public void setAssignatura(String assignatura) {
		this.assignatura = assignatura;
	}

}
