package Exercici_9_2;

public class Alumne extends Persona {

	// Atributs de l'alumne.
	private String estudis;

	public Alumne(String nom, int edat, String estudis) {
		super(nom, edat);
		this.estudis = estudis;
	}

	// Classe per mostrar les dades.
	public void mostrarDades() {
		System.out.println("Nom: " + this.getNom());
		System.out.println("DNI: " + this.getDni());
		System.out.println("Edat: " + this.getEdat());
		System.out.println("Nivell d'estudis: " + this.getEstudis());
		System.out.println();
	}

	// Getters i setters.
	public String getEstudis() {
		return estudis;
	}
	public void setEstudis(String estudis) {
		this.estudis = estudis;
	}

	// Mètode toString.
	/*@Override
	public String toString() {
		StringBuffer p = new StringBuffer();

		p.append(IU.llistaOrdenada(false, 
				"Nom: " + this.getNom(), 
				"DNI: " + this.getDni(), 
				"Edat: " + this.getEdat(), 
				"Estudis: " + this.getEstudis()));

		return p.toString();
	}*/

}