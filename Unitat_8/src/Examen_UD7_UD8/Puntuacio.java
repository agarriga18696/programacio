package Examen_UD7_UD8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Puntuacio {

	// Atributs.
	private String nom;
	private String cognoms;
	private int punts;
	private LocalDate data;
	
	private static DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// Constructor.
	public Puntuacio(String nom, String cognoms, int punts) {
		this.nom = nom;
		this.cognoms = cognoms;
		this.punts = punts;
		this.data = LocalDate.now();
	}

	// Getters i Setters.
	public String getNom() {
		return nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public int getPunts() {
		return punts;
	}

	public LocalDate getData() {
		return data;
	}
	
	// Mètode toString.
	public String toString() {
		StringBuffer sortida = new StringBuffer();
		
		sortida.append(IU.llistaOrdenada(false, 
				"Nom: " + nom,
				"Cognoms: " + cognoms,
				"Punts: " + punts,
				"Data: " + formatData.format(data)));
		
		return sortida.toString();
	}
	
}