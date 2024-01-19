package Exercicis.Exercici_6_5;

public class Alumne extends Persona {

	// Atributs de l'alumne.
	private String NivellEstudis;
	
	public Alumne(String nomPersona, String DNIPersona, byte edatPersona, String nivellEstudisAlumne) {
		super(nomPersona, DNIPersona, edatPersona);
		this.NivellEstudis = nivellEstudisAlumne;
	}

	// Classe per mostrar les dades.
	public void mostrarDades() {
		System.out.println("Nom: " + this.getNom());
		System.out.println("DNI: " + this.getDNI());
		System.out.println("Edat: " + this.getEdat());
		System.out.println("Nivell d'estudis: " + this.getNivellEstudis());
		System.out.println();
	}

	// Getters i setters.
	public String getNivellEstudis() {
		return NivellEstudis;
	}
	public void setNivellEstudis(String nivellEstudis) {
		NivellEstudis = nivellEstudis;
	}

}
