package Exercicis.Exercici_6_5;

public class Professor extends Persona {

	// Atributs del professor.
	private String Assignatura;
	
	public Professor(String nomPersona, String DNIPersona, byte edatPersona, String assignaturaProfessor) {
		super(nomPersona, DNIPersona, edatPersona);
		this.Assignatura = assignaturaProfessor;
	}

	// Classe per mostrar les dades.
	public void mostrarDades() {
		System.out.println("Nom: " + this.getNom());
		System.out.println("DNI: " + this.getDNI());
		System.out.println("Edat: " + this.getEdat());
		System.out.println("Assignatura: " + this.getAssignatura());
		System.out.println();
	}

	// Getters i setters.
	public String getAssignatura() {
		return Assignatura;
	}
	public void setAssignatura(String assignatura) {
		Assignatura = assignatura;
	}

}
