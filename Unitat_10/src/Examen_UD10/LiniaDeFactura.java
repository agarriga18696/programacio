package Examen_UD10;

import java.io.Serializable;

public class LiniaDeFactura implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributs.
	private String descripcio;
	private double quantitat;
	private double preuUnitari;
	
	// Constructor.
	public LiniaDeFactura(String descripcio, double quantitat, double preuUnitari) {
		this.descripcio = descripcio;
		this.quantitat = quantitat;
		this.preuUnitari = preuUnitari;
	}
	
	// Mètode toString.
	public String toString() {
		StringBuffer resultat = new StringBuffer();
		
		// Sistema per aliniar les columnes de manera simètrica per les tabulacions.
		// Fer que cada linia tingui la mateixa mida (52 caracters), completant amb espais en blanc.
		if(descripcio.length() < 52) {
			while(descripcio.length() < 52) {
				for(int i = 0; i < (52 - descripcio.length()); i++) {
					descripcio += " ";
				}
			}
		}
		
		resultat.append("\n\t- " + descripcio)
		.append("\t|\t" + quantitat)
		.append("\t | \t" + preuUnitari)
		.append("\n");
		
		return resultat.toString();
	}

}
