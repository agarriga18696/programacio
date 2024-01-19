package Exercicis.Exercici_6_9;

public class CapDepartament extends Empleat {
	
	private int treballadorsACarrec;
	private int projectes;
	private int plus;
	
	public CapDepartament(String nom, String cognoms, double souBase, String dni, int treballadorsACarrec, int projectes, int plus) {
		super(nom, cognoms, souBase, dni);
		
		this.treballadorsACarrec = treballadorsACarrec;
		this.projectes = projectes;
		this.plus = plus;
		
	}
	
	@Override
	public String toString() {
		return treballadorsACarrec + " | " + projectes + " | " + plus;
	}

}
