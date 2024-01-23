package Exercicis.Exercici_6_9;

public abstract class Empleat {

	// Atributs.
	public String nom;
	public String cognoms;
	public String dni;
	public double souBase;
	public int nombreEmpleat;
	
	// Constructor
	public Empleat(String nom, String cognoms, String dni, double souBase) {
		
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
		this.souBase = souBase;

	}
	
	public abstract String toString();

}
