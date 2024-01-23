package Exercicis.Exercici_6_9;

public class Obrer extends Empleat {

	private String desti;
	private double horesExtra;
	private double preuHoresExtra;
	private static int nombreObrer;

	public Obrer(String nom, String cognoms, String dni, double souBase, String desti, double horesExtra, double preuHoresExtra) {
		super(nom, cognoms, dni, souBase);
		
		this.desti = desti;
		this.horesExtra = horesExtra;
		this.preuHoresExtra = preuHoresExtra;
		this.nombreEmpleat = nombreObrer++;

	}
	
	public int getNombreObrer() {
		return nombreObrer;
	}
	
	@Override
	public String toString() {
		return " [" + nombreEmpleat + "] | " + nom + " | " + cognoms + " | " + dni + " | " + souBase + " | " + desti + " | " + horesExtra + " | " + preuHoresExtra;
	}

}
