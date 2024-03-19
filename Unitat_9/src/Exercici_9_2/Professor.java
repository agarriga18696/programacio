package Exercici_9_2;

public class Professor extends Persona {

	// Atributs del professor.
	private String assignatura;

	public Professor(String nom, int edat, String assignatura) {
		super(nom, edat);
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

	// Mètode toString.
	/*@Override
	public String toString() {
		StringBuffer p = new StringBuffer();

		p.append(IU.llistaOrdenada(false, 
				"Nom: " + this.getNom(), 
				"DNI: " + this.getDni(), 
				"Edat: " + this.getEdat(), 
				"Assignatura: " + this.getAssignatura()));

		return p.toString();
	}*/

}
