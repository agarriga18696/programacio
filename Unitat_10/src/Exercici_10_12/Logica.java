package Exercici_10_12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import Exercici_10_12.Partida.Dificultats;

public class Logica {

	//////////////////////////
	//						//
	//		  PARTIDA		//
	//						//
	//////////////////////////

	// Mètode per crear un nou jugador (nom).
	protected static String definirJugador() {
		String nomJugador = null;
		boolean nomJugadorValid = false;

		do {
			IU.titol("Jugador", null);
			nomJugador = Entrada.cadena("Nom");

			if(nomJugador != null && !nomJugador.isEmpty()) {
				nomJugadorValid = true;
			} else {
				IU.missatgeError("El nom del Jugador no pot estar en blanc");
			}

		} while(!nomJugadorValid);

		return nomJugador;
	}

	// Mètode per comprovar el resultat de la tirada.
	protected static boolean comprovarResultat(Character[] resultatTirada, Partida partida) {
		for(Character i : resultatTirada) {
			if(i != null && !i.equals(IU.NEGRE)) {
				return false;

			} else if(i == null) {
				return false;
			}
		}

		return true;
	}

	// Mètode per assignar la puntuació segons el resultat de la tirada.
	protected static void assignarPunts(Tirada tirada, Character[] resultatTirada, Partida partida) {
		int puntsTotals = 0, encertNegre = 0, encertBlanc = 0;

		try {
			for(int i = 0; i < resultatTirada.length; i++) {
				Character c = resultatTirada[i];
				if(c != null) {
					if(c.equals(IU.NEGRE)) {
						encertNegre++;
					} else if(c.equals(IU.BLANC)) {
						encertBlanc++;
					}
				}
			}

			// Calcular els punts de la tirada i sumar-los a la puntuació total de la partida.
			puntsTotals = (2 * encertNegre) + (encertBlanc);
			tirada.setPuntuacioTirada(puntsTotals);
			partida.setPuntuacio(partida.getPuntuacio() + puntsTotals);

		} catch(IndexOutOfBoundsException e) {
			IU.missatgeErrorCritic("S'ha intentat iterar sobre un índex que sobrepassa els límits de la mida de l'array");
		}
	}

	// Mètode per demanar l'entrada de colors al jugador.
	protected static Character[] demanarColors(Partida partida) {
		Character[] combinacioIntentada = new Character[partida.getMaxCombinacioColors()];

		try {
			for(int i = 0; i < partida.getMaxCombinacioColors(); i++) {
				boolean colorCorrecte = false;

				while(!colorCorrecte) {
					combinacioIntentada[i] = Entrada.lletra("Color " + (i + 1)).toUpperCase().charAt(0);

					colorCorrecte = validarColorEntrada(combinacioIntentada[i], partida);

					if(!colorCorrecte) {
						IU.missatgeError("El color introduït no és vàlid");
						IU.missatge("Els colors vàlids son:");
						IU.llistaColors(partida);
					} else {
						break;
					}
				}
			}

		} catch(IndexOutOfBoundsException e) {
			IU.missatgeErrorCritic("S'ha intentat iterar sobre un índex que sobrepassa els límits de la mida de l'array");
		}


		return combinacioIntentada;
	}

	// Mètode per validar que el color (char) introduït pel jugador sigui vàlid.
	protected static boolean validarColorEntrada(Character c, Partida partida) {
		char color = Character.toUpperCase(c);

		if(!partida.getDificultat().equals(Dificultats.EXPERT) && (color == IU.VERMELL || color == IU.VERD || color == IU.BLAU ||
				color == IU.GROC || color == IU.MAGENTA || color == IU.CIAN)) {
			return true;

		} else if(partida.getDificultat().equals(Dificultats.EXPERT) && (color == IU.VERMELL || color == IU.VERD || color == IU.BLAU ||
				color == IU.GROC || color == IU.MAGENTA || color == IU.CIAN || color == IU.ROSA || 
				color == IU.NEGRE || color == IU.BLANC)) {
			return true;

		} else {
			return false;
		}
	}

	// Mètode per mostrar el missatge de victoria o derrota.
	protected static void resultatPartida(boolean partidaFinalitzada, boolean combinacioEndevinada, Partida partida) {
		if(partidaFinalitzada && combinacioEndevinada) {
			IU.missatge("🏆 Has guanyat! Has endevinat la combinació!");
			IU.missatge("Has aconseguit un total de " + partida.getPuntuacio() + " punts!");
			partida.setResultatPartida("Victòria");

		} else if(partidaFinalitzada && partida.getIntentsRestants() <= 0){
			IU.missatge("💔 Has perdut... T'has quedat sense intents.");
			IU.missatge("La combinació era: " + Logica.imprimirColors(partida.getCombinacioSecreta(), 0, partida));
			// Quan perds també perds tots els punts guanyats durant la partida.
			partida.setPuntuacio(0);
			partida.setResultatPartida("Derrota");
		}

		// Comprovar si ha batut el rècord de punts.
		comprovarRecordPunts(partida);
	}

	// Mètode per comprovar si ha batut el rècord de punts en comparació a les altres partides.
	private static void comprovarRecordPunts(Partida partida) {
		int[] puntuacionsTotalsPartides = new int[Joc.llistaPartides.size()];

		// Fer la comprovació si hi ha com a mínim 2 partides registrades.
		if(Joc.llistaPartides != null) {
			// Afegir totes les puntuacions a l'array de puntuacions totals.
			try {
				for(int i = 0; i < Joc.llistaPartides.size(); i++) {
					puntuacionsTotalsPartides[i] = Joc.llistaPartides.get(i).getPuntuacio();
				}
			} catch(IndexOutOfBoundsException e) {
				IU.missatgeErrorCritic("S'ha intentat iterar sobre un índex que sobrepassa els límits de la mida de l'array");
			}


			// Ordenar l'array de major a menor, així l'índex 0 sempre serà la puntuació més alta.
			Ordenacio.seleccioDirecta(puntuacionsTotalsPartides);

			// Comprovar si la puntuació de la partida actual és més alta que la puntuació més alta registrada.
			if(partida.getPuntuacio() > Joc.puntuacioRecord) {
				IU.missatge("🎉 Enhorabona! Has batut el rècord de punts!");

				// Definir la variable de puntuacio record de totes les partides com a false.
				for(Partida p : Joc.llistaPartides) {
					p.setPuntuacioRecord(false);
				}

				// Establir com a true la puntuacio record de la partida actual.
				partida.setPuntuacioRecord(true);

				// Emmagatzemar la puntuació rècord a la variable global.
				Joc.puntuacioRecord = partida.getPuntuacio();
			}
		}
	}

	// Mètode per mostrar l'historial de partides.
	protected static void historialPartides() {	
		int i = 0;

		// Mostrar l'historial de tirades.
		if(Joc.llistaPartides.size() > 0) { // Comprovar si existeixen partides.
			for(Partida partida : Joc.llistaPartides) {
				IU.titol("Resum de la partida " + (i + 1) + ":", null);
				IU.historialTirades(partida);
				i++;
			}
			
		} else {
			IU.missatgeAdvertencia("No s'ha trobat cap partida registrada");
		}
	}


	//////////////////////////
	//						//
	//	  COLORS CERCLES	//
	//						//
	//////////////////////////

	// Mètode per imprimir els cercles de colors per pantalla.
	protected static String imprimirColors(Character[] combinacio, int opcio, Partida partida) {
		String[] colors = new String[partida.getMaxCombinacioColors()];

		// Colors de la combinació de la tirada.
		if(opcio == 0) {
			try {
				for(int i = 0; i < partida.getMaxCombinacioColors(); i++) {
					if(combinacio[i] != null) {
						// Switch 1
						// Imprimir els cercles segons el color.
						switch(combinacio[i]) {
						case IU.VERMELL:
							colors[i] = IU.TEXT_VERMELL + IU.CERCLE + IU.TEXT_RESET;
							break;
						case IU.VERD:
							colors[i] = IU.TEXT_VERD + IU.CERCLE + IU.TEXT_RESET;
							break;
						case IU.BLAU:
							colors[i] = IU.TEXT_BLAU + IU.CERCLE + IU.TEXT_RESET;
							break;
						case IU.MAGENTA:
							colors[i] = IU.TEXT_MAGENTA + IU.CERCLE + IU.TEXT_RESET;
							break;
						case IU.GROC:
							colors[i] = IU.TEXT_GROC + IU.CERCLE + IU.TEXT_RESET;
							break;
						case IU.CIAN:
							colors[i] = IU.TEXT_CIAN + IU.CERCLE + IU.TEXT_RESET;
							break;
						case IU.ROSA:
							colors[i] = IU.TEXT_ROSA + IU.CERCLE + IU.TEXT_RESET;
							break;
						case IU.NEGRE:
							colors[i] = IU.TEXT_NEGRE + IU.CERCLE + IU.TEXT_RESET;
							break;
						case IU.BLANC:
							colors[i] = IU.TEXT_BLANC + IU.CERCLE + IU.TEXT_RESET;
							break;
						default:
							IU.missatgeErrorCritic("Error en el mètode 'imprimirColors' de la classe 'Logica' al intentar "
									+ "iterar sobre un valor desconegut en el 'switch 1'.");
							break;
						}

					} else {
						// Si el valor és null (color incorrecte) imprimirà una creu.
						colors[i] = Character.toString(IU.CREU);
					}
				}

			} catch(IndexOutOfBoundsException e) {
				IU.missatgeErrorCritic("S'ha intentat iterar sobre un índex que sobrepassa els límits de la mida de l'array");
			}

		} else if(opcio == 1) { // Colors del resultat de la tirada.
			try {
				for(int i = 0; i < combinacio.length; i++) {
					if(combinacio[i] != null) {
						// Switch 2
						// Imprimir els cercles segons el color.
						switch(combinacio[i]) {
						case IU.NEGRE:
							colors[i] = IU.TEXT_NEGRE + IU.CERCLE + IU.TEXT_RESET;
							break;
						case IU.BLANC:
							colors[i] = IU.TEXT_BLANC + IU.CERCLE + IU.TEXT_RESET;
							break;
						default:
							IU.missatgeErrorCritic("Error en el mètode 'imprimirColors' de la classe 'Logica' al intentar "
									+ "iterar sobre un valor desconegut en el 'switch 2'.");
							break;
						}

					} else {
						// Si el valor és null (color incorrecte) imprimirà una creu.
						colors[i] = Character.toString(IU.CREU);
					}
				}

			} catch(IndexOutOfBoundsException e) {
				IU.missatgeErrorCritic("S'ha intentat iterar sobre un índex que sobrepassa els límits de la mida de l'array");
			}
		}

		return Arrays.toString(colors);
	}

	// Mètode per carregar una partida guardada.
	protected static void carregarPartida() {
		try {
			FileInputStream fileIn = new FileInputStream("src/Exercici_10_12/partida.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			Partida partida = (Partida) objectIn.readObject();
			objectIn.close();
			fileIn.close();
			Joc.llistaPartides.add(partida);

			IU.missatge("🔄 Partida carregada: La partida s'ha carregat correctament");

		} catch(IOException | ClassNotFoundException e) {
			// En cas que no es pugui carregar la partida des de l'arxiu, fer com si no hi hagués cap partida guardada.
			IU.missatgeAdvertencia("No s'ha trobat cap partida guardada. S'iniciarà una nova partida");
		}
	}

	// Mètode per guardar la partida a un fitxer.
	protected static void guardarPartida(Partida partida) {
		try {
			// Serialitzar la partida i escriure-la al fitxer.
			FileOutputStream fileOut = new FileOutputStream("src/Exercici_10_12/partida.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(partida);
			objectOut.close();
			fileOut.close();

			IU.saltLinia();
			IU.missatge("💾 Guardat autom.: La partida s'ha guardat correctament");

		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
