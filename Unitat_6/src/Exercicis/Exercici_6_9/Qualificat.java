package Exercicis.Exercici_6_9;

public class Qualificat extends Empleat {

	protected String titulacio;
	protected String departament;
	protected double plus;
	private static int nombreQualificat;

	public Qualificat(String nom, String cognoms, String dni, String titulacio, String departament, double souBase, double plus) {
		super(nom, cognoms, dni, souBase);

		this.titulacio = titulacio;
		this.departament = departament;
		this.plus = plus;
		this.nombreEmpleat = nombreQualificat++;
		
	}
	
	public int getNombreQualificat() {
		return nombreQualificat;
	}

	@Override
	public String toString() {
		return " [" + nombreEmpleat + "] | " + nom + " | " + cognoms + " | " + dni + " | " + titulacio + " | " + departament + " | " + souBase + " | "  + plus;
	}

}
