package Exercicis.Exercici_6_1;

public class Persona {

	private String dni;
	private String nom;
	private short edat;

	// Getters.
	public String getDni() {
		return dni;
	}

	public String getNom() {
		return nom;
	}

	public short getEdat() {
		return edat;
	}

	// Setters.
	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEdat(short edat) {
		this.edat = edat;
	}

	// Mètode per visualitzar l'objecte Persona.
	public void mostrarDades() {
		System.out.println("Visualització de dades de la persona:");
		System.out.println("DNI...........: " + this.getDni());
		System.out.println("Nom...........: " + this.getNom());
		System.out.println("Edat..........: " + this.getEdat());
		System.out.println();
	}

}
