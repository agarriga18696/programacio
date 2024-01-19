package Exercicis.Exercici_6_9;

public class Obrer extends Empleat {
	
	private String desti;
	private double horesExtra;
	private double preuHoresExtra;
	
	public Obrer(String nom, String cognoms, double souBase, String dni, String desti, double horesExtra, double preuHoresExtra) {
		super(nom, cognoms, souBase, dni);
		
		this.desti = desti;
		this.horesExtra = horesExtra;
		this.preuHoresExtra = preuHoresExtra;
		
	}
	
	@Override
	public String toString() {
		return desti + " | " + horesExtra + " | " + preuHoresExtra;
	}

}
