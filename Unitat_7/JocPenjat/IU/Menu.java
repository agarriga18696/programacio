package IU;

import Joc.JocPenjat;
import Utilitat.Validar;

public class Menu {

	//////////////////////
	//					//
	//		 MENÚ		//
	//					//
	//////////////////////

	// Menú principal.
	public static void menuPrincipal() {
		int opcio = 0;

		do {
			Element.saltLinia();
			Element.titolAmbMarc("PENJAT");
			System.out.println(" (1) Jugar");
			System.out.println(" (2) Afegir nova paraula");
			System.out.println(" (3) Sortir");
			
			opcio = Validar.enter("Opció");

			switch(opcio) {
			case 1:
				JocPenjat.jugar();
				break;
			case 2:
				JocPenjat.afegirParaula();
				break;
			case 3:
				JocPenjat.sortir();
				break;
			default:
				Missatge.Error("Opció no vàlida");
				break;
			}
		} while(opcio != 3);
	}
	
}
