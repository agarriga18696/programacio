package Exercicis.Exercici_6_11;

public class LlistaLlibres {

	private static int contLlibres = 0;
	private static Llibre[] llibres = new Llibre[50];

	public static void insertarLlibre() {
		String titol = null, autor = null, sinopsis = null;
		int numPagines = 0;
		boolean llibreCorrecte = false;

		while(!llibreCorrecte) {
			IU.Titol("INSERTAR LLIBRE");

			titol = Validar.String(Entrada.input, "Títol");
			autor = Validar.String(Entrada.input, "Autor");
			sinopsis = Validar.String(Entrada.input, "Sinopsis");
			numPagines = Validar.Int(Entrada.input, "Núm. Pàgines");

			// Comprovar que els camps siguin correctes.
			if(
					titol.isBlank() || 
					autor.isBlank() || 
					sinopsis.isBlank() || 
					numPagines <= 0) {

				if(titol.isBlank()) IU.MissatgeError("El camp 'Títol' no pot estar buit");
				if(autor.isBlank()) IU.MissatgeError("El camp 'Autor' no pot estar buit");
				if(sinopsis.isBlank()) IU.MissatgeError("El camp 'Sinopsis' no pot estar buit");
				if(numPagines <= 0) IU.MissatgeError("El valor 'Núm. Pàgines' no pot ser negatiu o zero");

			} else {
				llibreCorrecte = true;
				break; // sortir del bucle while.
			}

		} // fi while.

		// Insertar el llibre dins l'array de llibres.
		if(!(contLlibres > llibres.length)) {
			llibres[contLlibres] = new Llibre(titol, autor, sinopsis, numPagines);
		} else {
			IU.MissatgeAdvertencia("T'has quedat sense espai a la biblioteca");
			IU.MissatgeAdvertencia("Per poder afegir més llibres n'hauràs d'eliminar un");
		}

		// Incrementar contador llibres.
		contLlibres++;

	}

	public static void eliminarLlibre() {

		IU.Titol("ELIMINAR LLIBRE");

		if(contLlibres > 0) {
			String titol = Validar.String(Entrada.input, "Títol");

			for(int i = 0; i < llibres.length; i++) {
				Llibre llibre = llibres[i];

				if(llibre != null && llibre.getTitol().equalsIgnoreCase(titol)) {
					IU.MissatgeExit("Llibre '" + llibre.toString() + "' eliminat");
					llibre = null;
				}
			}
			
			contLlibres--;

		} else {
			IU.MissatgeAdvertencia("No hi ha llibres a eliminar");
		}

	}

	public static void modificarLlibre() {

		IU.Titol("MODIFICAR LLIBRE");

	}

	public static void mostrarLlibre() {

		IU.Titol("MOSTRAR LLIBRE");

		if(contLlibres > 0) {
			for(int i = 0; i < contLlibres; i++) {
				Llibre llibre = llibres[i];
				if(llibre != null) {
					System.out.println(" " + llibre.toString());
				}
			}
		} else {
			IU.MissatgeAdvertencia("No hi ha llibres a mostrar");
		}

	}

}
