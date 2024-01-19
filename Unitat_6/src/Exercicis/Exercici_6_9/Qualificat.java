package Exercicis.Exercici_6_9;

public class Qualificat extends Empleat {
	
	private String titulacio;
	private double plus;
	private String departament;
	
	public Qualificat(String nom, String cognoms, double souBase, String dni, String titulacio, double plus, String departament) {
		super(nom, cognoms, souBase, dni);
		
		this.titulacio = titulacio;
		this.plus = plus;
		this.departament = departament;
		
	}
	
	@Override
	public String toString() {
		return titulacio + " | " + plus + " | " + departament;
	}

}
