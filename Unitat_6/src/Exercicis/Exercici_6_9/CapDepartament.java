package Exercicis.Exercici_6_9;

public class CapDepartament extends Empleat {

	private int treballadorsACarrec;
	private int projectes;
	private double plus;
	private int id = 0;
	private static int nombreCapsDepartaments = 0;

	public CapDepartament(String nom, String cognoms, String dni, double souBase, int treballadorsACarrec, int projectes, double plus) {
		super(nom, cognoms, dni, souBase);

		this.treballadorsACarrec = treballadorsACarrec;
		this.projectes = projectes;
		this.plus = plus;
		
		id += nombreCapsDepartaments;
		
		comptarCapsDepartament();

	}

	public static int getNombreCapsDepartaments() {
		return nombreCapsDepartaments;
	}

	// Funció per comptar els obrers creats.
	public void comptarCapsDepartament() {
		nombreCapsDepartaments++;
	}

	@Override
	public String toString() {
		return " [" + id + "] | " + nom + " | " + cognoms + " | " + dni + " | " + souBase + " | " + treballadorsACarrec + " | " + projectes + " | " + plus;
	}

}
