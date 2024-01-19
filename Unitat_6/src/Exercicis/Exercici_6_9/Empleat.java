package Exercicis.Exercici_6_9;

public abstract class Empleat {

	// Atributs.
	public String nom;
	public String cognoms;
	public String dni;
	public double souBase;
	private static int nombreEmpleats = 0;
	
	// Constructor
	public Empleat(String nom, String cognoms, String dni, double souBase) {

		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
		this.souBase = souBase;
		
		comptarEmpleats();

	}
	
	// Getters.
	public String getNom() {
		return nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public double getSouBase() {
		return souBase;
	}

	public String getDNI() {
		return dni;
	}
	
	public static int getNombreEmpleats() {
		return nombreEmpleats;
	}

	// Funció per comptar els empleats creats.
	public void comptarEmpleats() {
		nombreEmpleats++;
	}
	
	// Funció toString.
	public String toString() {
		return " [" + nombreEmpleats + "] | " + nom + " | " + cognoms + " | " + souBase + " | " + dni;
	}

}
