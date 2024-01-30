package Exercicis.Exercici_6_11;

public class Llibre {
	
	private String titol;
	private String autor;
	private String genere;
	private String sinopsis;
	private String editorial;
	private int iban;
	private int numPagines;
	private int anyPublicacio;
	
	public Llibre(String titol, String autor, String genere, String sinopsis, String editorial, int iban, int numPagines, int anyPublicacio) {
		
		this.titol = titol;
		this.autor = autor;
		this.genere = genere;
		this.sinopsis = sinopsis;
		this.editorial = editorial;
		this.iban = iban;
		this.numPagines = numPagines;
		this.anyPublicacio = anyPublicacio;
		
	}
	
	public void setTitol(String titol) {
		this.titol = titol;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setIban(int iban) {
		this.iban = iban;
	}

	public void setNumPagines(int numPagines) {
		this.numPagines = numPagines;
	}

	public void setAnyPublicacio(int anyPublicacio) {
		this.anyPublicacio = anyPublicacio;
	}

	public String toString() {
		
		return " " + titol + " | " + autor;
		
	}

}
