package Exercicis.Exercici_6_11;

public class Llibre {
	
	private String titol;
	private String autor;
	private String sinopsis;
	private int numPagines;
	
	public Llibre(String titol, String autor, String sinopsis, int numPagines) {
		
		this.titol = titol;
		this.autor = autor;
		this.sinopsis = sinopsis;
		this.numPagines = numPagines;
		
	}

	public String getTitol() {
		return titol;
	}
	
	public String getAutor() {
		return autor;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public int getNumPagines() {
		return numPagines;
	}

	// Mètode per eliminar un llibre.
	public void eliminar() {
		
	}

	public String toString() {
		
		return titol + " | " + autor + " | " + sinopsis + " | " + numPagines;
		
	}

}
