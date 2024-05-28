package Prova_Examen;

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

	// Getters i setters.
	public String getAssignatura() {
		return assignatura;
	}
	public void setAssignatura(String assignatura) {
		this.assignatura = assignatura;
	}

}
