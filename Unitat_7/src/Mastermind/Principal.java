package Mastermind;

public class Principal {
	
	private static final int INTENTS_MAX = 16;
	private static int intentsRestants = INTENTS_MAX;

	public static void main(String[] args) {

		menuPrincipal();

	}

	// Mètode per mostrar el menú.
	private static void menuPrincipal() {
		
		while(true) {
			
			IU.separador();
			IU.title("Mastermind");
			IU.menu("Nova Partida", "Sortir");
			int opcio = Entrada.enter("Opció");

			switch(opcio) {
			case 1:
				novaPartida();
				return;
			case 2:
				sortir();
				return;
			default:
				IU.missatgeError("Opció no vàlida");
				break;
			}

		}

	}

	private static void novaPartida() {
		
		boolean partidaValida = false;
		
		String nom = null; 
		
		do {
			nom = Entrada.cadena("Nom Jugador").trim().toUpperCase();
			
			if(nom.isEmpty() || nom == null) {
				IU.missatgeError("El nom del Jugador no pot estar en blanc");
			} else {
				partidaValida = true;
			}

		} while(!partidaValida);
		
		crearNovaCombinacio();
		
		// Crear objecte partida.
		Partida partida = new Partida(nom, combinacioSecreta);
		
		IU.separador();
		IU.title("Nova Partida");
		
		// Condicions per acabar la partida.
		// -> No tenir més intents (has perdut).
		// -> Haver endevinat la combinació de l'ordinador (has guanyat).
		while(intentsRestants > 1) {
			
			// Anar demanant al Jugador que introdueixi els colors.
			
		}

	}

	private static void sortir() {
		// TODO Auto-generated method stub

	}


}
