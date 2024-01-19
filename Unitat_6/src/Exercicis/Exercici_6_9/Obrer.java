package Exercicis.Exercici_6_9;

public class Obrer extends Empleat {

	private String desti;
	private double horesExtra;
	private double preuHoresExtra;
	private int id = 0;
	private static int nombreObrers = 0;

	public Obrer(String nom, String cognoms, String dni, double souBase, String desti, double horesExtra, double preuHoresExtra) {
		super(nom, cognoms, dni, souBase);
		
		this.desti = desti;
		this.horesExtra = horesExtra;
		this.preuHoresExtra = preuHoresExtra;
		
		id += nombreObrers;
		
		comptarObrers();

	}
	
	public static int getNombreObrers() {
		return nombreObrers;
	}

	// Funció per comptar els obrers creats.
	public void comptarObrers() {
		nombreObrers++;
	}

	@Override
	public String toString() {
		return " [" + id + "] | " + nom + " | " + cognoms + " | " + dni + " | " + souBase + " | " + desti + " | " + horesExtra + " | " + preuHoresExtra;
	}

}
