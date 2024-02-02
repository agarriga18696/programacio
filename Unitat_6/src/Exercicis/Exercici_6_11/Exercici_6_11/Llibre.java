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

	// Getters i setters.
	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getNumPagines() {
		return numPagines;
	}

	public void setNumPagines(int numPagines) {
		this.numPagines = numPagines;
	}

	// Mètode per eliminar un llibre.
	public Llibre eliminar() {
		return null;
	}

	// Mètode toString.
	public String toString() {
		
		return titol + " | " + autor + " | " + sinopsis + " | " + numPagines;
		
	}

}
