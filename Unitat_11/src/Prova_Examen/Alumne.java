package Prova_Examen;

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
	
	/*public String toString() {
		StringBuffer alumne = new StringBuffer();
		
		alumne.append(this.getNom())
		.append(" | ").append(this.getDni())
		.append(" | ").append(this.getEdat())
		.append(" | ").append(this.getNivellEstudis());
		
		return alumne.toString();
		
	}*/

	// Getters i setters.
	public String getNivellEstudis() {
		return nivellEstudis;
	}
	public void setNivellEstudis(String nivellEstudis) {
		this.nivellEstudis = nivellEstudis;
	}

}
