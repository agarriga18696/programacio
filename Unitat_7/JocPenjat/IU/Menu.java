package IU;

import Joc.JocPenjat;
import Utilitat.Validar;

public class Menu {

	//////////////////////
	//					//
	//		 MENÚ		//
	//					//
	//////////////////////

	private static void opcionsMenu() {
		Element.saltLinia();
		Element.titolAmbMarc("PENJAT");
		System.out.println(" (1) Jugar");
		System.out.println(" (2) Opcions");
		System.out.println(" (3) Sortir");
	}

	public static void menu() {
		int opcio = 0;

		do {
			opcionsMenu();
			opcio = Validar.enter("Opció");

			switch(opcio) {
			case 1:
				JocPenjat.jugar();
				break;
			case 2:
				JocPenjat.configuracio();
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
