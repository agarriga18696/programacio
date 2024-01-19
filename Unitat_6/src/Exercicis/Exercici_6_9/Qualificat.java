package Exercicis.Exercici_6_9;

public class Qualificat extends Empleat {

	private String titulacio;
	private String departament;
	private double plus;
	private int id = 0;
	private static int nombreQualificats = 0;

	public Qualificat(String nom, String cognoms, String dni, double souBase, String titulacio, String departament, double plus) {
		super(nom, cognoms, dni, souBase);

		this.titulacio = titulacio;
		this.departament = departament;
		this.plus = plus;
		
		id += nombreQualificats;
		
		comptarQualificats();

	}

	public static int getNombreQualificats() {
		return nombreQualificats;
	}

	// Funció per comptar els obrers creats.
	public void comptarQualificats() {
		nombreQualificats++;
	}

	@Override
	public String toString() {
		return " [" + id + "] | " + nom + " | " + cognoms + " | " + dni + " | " + souBase + " | " + titulacio + " | " + departament + " | " + plus;
	}

}
