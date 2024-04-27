package Exercici_10_08;

public class Alumne extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributs de l'alumne.
	private String nivellEstudis;
	
	public Alumne(String nom, String dni, int edat, String nivellEstudis) {
		super(nom, dni, edat);
		this.nivellEstudis = nivellEstudis;
	}

	// Classe per mostrar les dades.
	public void mostrarDades() {
		Msg.simple("Nom: " + this.getNom());
		Msg.simple("DNI: " + this.getDni());
		Msg.simple("Edat: " + this.getEdat());
		Msg.simple("Nivell d'estudis: " + this.getNivellEstudis());
		IU.saltLinia();
	}

	// Getters i setters.
	public String getNivellEstudis() {
		return nivellEstudis;
	}
	public void setNivellEstudis(String nivellEstudis) {
		this.nivellEstudis = nivellEstudis;
	}

}
