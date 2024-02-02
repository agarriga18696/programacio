package Exercicis.Exercici_6_11;

public class LlistaLlibres {

	public static int contLlibres = 0;
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
			boolean existeixLlibre = false;
			String titol = Validar.String(Entrada.input, "Llibre (títol)");

			for(int i = 0; i < contLlibres; i++) {
				Llibre llibre = llibres[i];

				if(llibre != null && llibre.getTitol().equalsIgnoreCase(titol)) {
					IU.MissatgeExit("Llibre '" + llibre.getTitol() + "' eliminat");
					llibre.eliminar();

					// Reorganitzar l'array per no deixar index nulls entre mig.
					for(int j = i; j < contLlibres - 1; j++) {
						llibres[j] = llibres[j + 1];
					}

					llibres[contLlibres - 1] = null;
					contLlibres--;
					existeixLlibre = true;
					break;

				}

			}

			if(!existeixLlibre) {
				IU.MissatgeError("No s'ha trobat el llibre '" + titol + "'");
			}

		} else {
			IU.MissatgeAdvertencia("No hi ha llibres a eliminar");
		}

	}

	public static void modificarLlibre() {

		IU.Titol("MODIFICAR LLIBRE");

		if(contLlibres > 0) {
			boolean existeixLlibre = false;
			String titol = Validar.String(Entrada.input, "Llibre (títol)");

			for(Llibre llibre : llibres) {

				if(llibre != null && llibre.getTitol().equalsIgnoreCase(titol)) {

					boolean llibreCorrecte = false;

					while(!llibreCorrecte) {
						// Reassignar els valors.
						llibre.setTitol(Validar.String(Entrada.input, "Títol"));
						llibre.setAutor(Validar.String(Entrada.input, "Autor"));
						llibre.setSinopsis(Validar.String(Entrada.input, "Sinopsis"));
						llibre.setNumPagines(Validar.Int(Entrada.input, "Núm. Pàgines"));

						// Comprovar que els camps siguin correctes.
						if(
								llibre.getTitol().isBlank() || 
								llibre.getAutor().isBlank() || 
								llibre.getSinopsis().isBlank() || 
								llibre.getNumPagines() <= 0) {

							if(llibre.getTitol().isBlank()) IU.MissatgeError("El camp 'Títol' no pot estar buit");
							if(llibre.getAutor().isBlank()) IU.MissatgeError("El camp 'Autor' no pot estar buit");
							if(llibre.getSinopsis().isBlank()) IU.MissatgeError("El camp 'Sinopsis' no pot estar buit");
							if(llibre.getNumPagines() <= 0) IU.MissatgeError("El valor 'Núm. Pàgines' no pot ser negatiu o zero");

						} else {
							IU.MissatgeExit("Llibre '" + llibre + "' modificat correctament");
							llibreCorrecte = true;
							break; // sortir del bucle while.
						}
					}

					existeixLlibre = true;
					break; // sortir del bucle for-each.
				}
			}

			if(!existeixLlibre) {
				IU.MissatgeError("No s'ha trobat el llibre '" + titol + "'");
			}

		} else {
			IU.MissatgeAdvertencia("No hi ha llibres a modificar");
		}
	}

	public static void mostrarLlibre() {

		IU.Titol("MOSTRAR LLIBRE [escriu 'tots' per mostrar tots els llibres]");

		if(contLlibres > 0) {
			boolean existeixLlibre = false;
			String titol = Validar.String(Entrada.input, "Llibre (títol)");

			for(Llibre llibre : llibres) {
				
				if(titol.equalsIgnoreCase("tots") && llibre != null) {
					// Mostrar tots els llibres.
					System.out.println("\n " + llibre.toString());
					existeixLlibre = true;
					
				} else if(llibre != null && llibre.getTitol().equalsIgnoreCase(titol)) {
					// Mostrar un llibre.
					System.out.println("\n " + llibre.toString());
					existeixLlibre = true;
					break;
				}
				
			}

			if(!existeixLlibre) {
				IU.MissatgeError("No s'ha trobat el llibre '" + titol + "'");
			}

		} else {
			IU.MissatgeAdvertencia("No hi ha llibres a mostrar");
		}

	}

}
