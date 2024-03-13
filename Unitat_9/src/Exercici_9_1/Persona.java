package Exercici_9_1;

public class Persona {

	// Atributs.
	private String nom;
	private String dni;
	private byte edat;

	// Definir els atributs de la persona.
	public Persona(String nom, String dni, byte edat) {
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

	public byte getEdat() {
		return edat;
	}

}
