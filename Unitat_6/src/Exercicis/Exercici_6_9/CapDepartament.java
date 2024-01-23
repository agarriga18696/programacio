package Exercicis.Exercici_6_9;

public class CapDepartament extends Qualificat {

	private int treballadorsACarrec;
	private int projectes;
	private static int nombreCapDepartament;

	public CapDepartament(String nom, String cognoms, String dni, String titulacio, String departament, double souBase,
			double plus, int treballadorsACarrec, int projectes) {
		super(nom, cognoms, dni, titulacio, departament, souBase, plus);

		this.treballadorsACarrec = treballadorsACarrec;
		this.projectes = projectes;
		this.nombreEmpleat = nombreCapDepartament++;
		
	}
	
	public int getNombreCapDepartament() {
		return nombreCapDepartament;
	}

	@Override
	public String toString() {
		return " [" + nombreEmpleat + "] | " + nom + " | " + cognoms + " | " + dni + " | " + titulacio + " | " + departament + " | " + souBase + " | "  + plus + " | " + treballadorsACarrec + " | " + projectes;
	}

}
