package Paraules;

public class Paraula {

	// Atributs
	private String paraula;
	private int lletresAcertades;
	
	// Constructor
	public Paraula() {
		this.paraula = Paraules.generarParaula();
		this.lletresAcertades = 0;
	}

	public String getParaula() {
		return paraula;
	}

	public void setParaula(String paraula) {
		this.paraula = paraula;
	}

	public int getLletresAcertades() {
		return lletresAcertades;
	}

	public void setLletresAcertades(int lletresAcertades) {
		this.lletresAcertades = lletresAcertades;
	}
	
}
