package Joc;

import IU.Elements;
import IU.Missatge;
import Utilitat.Validar;

public class JocPenjat {
	
	public static void main(String[] args) {
		menu();
	}
	
	private static void opcionsMenu() {
		Elements.saltLinia();
		Elements.separador();
		System.out.println(" JOC DEL PENJAT\n");
		System.out.println(" (1) Jugar");
		System.out.println(" (2) Afegir paraules personalitzades");
		System.out.println(" (3) Configuració del jugador");
		System.out.println(" (4) Sortir");
	}
	
	private static void menu() {
		int opcio = 0;
		
		do {
			opcionsMenu();
			opcio = Validar.enter("Opció");
			
			switch(opcio) {
			case 1:
				jugar();
				break;
			case 2:
				paraulaPersonalitzada();
				break;
			case 3:
				configuracio();
				break;
			case 4:
				sortir();
				break;
			default:
				Missatge.Error("Opció no vàlida");
				break;
			}
		} while(opcio != 4);
	}

	private static void jugar() {
		Elements.saltLinia();
		Elements.separador();
		System.out.println(" JUGAR");
		
		
	}

	private static void paraulaPersonalitzada() {
		// TODO Auto-generated method stub
		
	}

	private static void configuracio() {
		// TODO Auto-generated method stub
		
	}

	private static void sortir() {
		Elements.saltLinia();
		Elements.separador();
		System.out.println("Fins un altre cop!");
		System.exit(0);
	}
	
}
