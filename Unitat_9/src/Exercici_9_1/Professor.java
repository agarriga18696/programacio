package Exercici_9_1;

public class Professor extends Persona {

	// Atributs del professor.
	private String assignatura;
	
	public Professor(String nom, String dni, byte edat, String assignatura) {
		super(nom, dni, edat);
		this.assignatura = assignatura;
	}

	// Classe per mostrar les dades.
	public void mostrarDades() {
		System.out.println("Nom: " + this.getNom());
		System.out.println("DNI: " + this.getDni());
		System.out.println("Edat: " + this.getEdat());
		System.out.println("Assignatura: " + this.getAssignatura());
		System.out.println();
	}

	// Getters i setters.
	public String getAssignatura() {
		return assignatura;
	}
	public void setAssignatura(String assignatura) {
		this.assignatura = assignatura;
	}

}
