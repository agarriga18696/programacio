package Exercicis.Exercici_6_11;

public class LlistaLlibres {

	private static int contLlibres = 0;
	private static Llibre[] llibres = new Llibre[contLlibres+1];

	public static void insertarLlibre() {
		String titol = null, autor = null, genere = null, sinopsis = null, editorial = null;
		int iban = 0, numPagines = 0, anyPublicacio = 0;
		boolean llibreCorrecte = false;

		while(!llibreCorrecte) {
			IU.SaltLinea();
			IU.Titol("INSERTAR LLIBRE");
			IU.Separador();
			titol = Validar.String(Entrada.input, "Títol");
			autor = Validar.String(Entrada.input, "Autor");
			genere = Validar.String(Entrada.input, "Gènere");
			sinopsis = Validar.String(Entrada.input, "Sinopsis");
			editorial = Validar.String(Entrada.input, "Editorial");
			iban = Validar.Int(Entrada.input, "IBAN");
			numPagines = Validar.Int(Entrada.input, "Núm. Pàgines");
			anyPublicacio = Validar.Int(Entrada.input, "Any Publicació");

			// Comprovar que els camps siguin correctes.
			if(
					titol.isBlank() || 
					autor.isBlank() || 
					genere.isBlank() || 
					sinopsis.isBlank() || 
					editorial.isBlank() ||
					iban <= 0 ||
					numPagines <= 0 ||
					anyPublicacio <= 0) {

				if(titol.isBlank()) IU.MissatgeError("El camp 'Títol' no pot estar buit");
				if(autor.isBlank()) IU.MissatgeError("El camp 'Autor' no pot estar buit");
				if(genere.isBlank()) IU.MissatgeError("El camp 'Gènere' no pot estar buit");
				if(sinopsis.isBlank()) IU.MissatgeError("El camp 'Sinopsis' no pot estar buit");
				if(editorial.isBlank()) IU.MissatgeError("El camp 'Editorial' no pot estar buit");
				if(iban <= 0) IU.MissatgeError("El valor 'IBAN' no pot ser negatiu o zero");
				if(numPagines <= 0) IU.MissatgeError("El valor 'Núm. Pàgines' no pot ser negatiu o zero");
				if(anyPublicacio <= 0) IU.MissatgeError("El valor 'Any Publicació' no pot ser negatiu o zero");

			} else {
				llibreCorrecte = true;
				break; // sortir del bucle while.
			}

		} // fi while.

		// Insertar el llibre dins l'array de llibres.
		llibres[contLlibres] = new Llibre(titol, autor, genere, sinopsis, editorial, iban, numPagines, anyPublicacio);

		// Incrementar contador llibres.
		contLlibres++;

	}

	public static void eliminarLlibre() {



	}

	public static void modificarLlibre() {



	}

	public static void mostrarLlibre() {

		if(llibres.length <= 0) {
			IU.MissatgeAdvertencia("No s'ha creat cap llibre");
		} else {
			for(Llibre llibre : llibres) {
				System.out.println(llibre.toString());
			}
		}

	}

}
