package Exercici_9_1;

public class Persona {

	// Atributs.
	private String nom;
	private String dni;
	private int edat;

	// Definir els atributs de la persona.
	public Persona(String nom, String dni, int edat) {
		this.nom = nom;
		this.dni = dni;
		this.edat = edat;
	}

	// Getters i setters.
	public String getNom() {
		return nom;
	}

	public String getDni() {
		return dni;
	}

	public int getEdat() {
		return edat;
	}

	// Mètode toString.
	public String toString() {
		StringBuffer p = new StringBuffer();

		p.append(IU.llistaOrdenada(false, 
				"Nom: " + nom, 
				"DNI: " + dni, 
				"Edat: " + edat));

		return p.toString();
	}

}
