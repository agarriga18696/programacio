package Exercicis.Exercici_6_11;

public class Biblioteca {
	
	private static int opcioMenu = 0;

	public static void main(String[] args) {
		
		while(opcioMenu != 5) {
			menuPrincipal();
		}
		
	}
	
	private static void menuPrincipal() {
		
		IU.Titol("BIBLIOTECA [llibres: " + LlistaLlibres.contLlibres + "]");
		IU.MenuOpcions("Insertar Llibre", "Eliminar Llibre", "Modificar Llibre", "Mostrar Llibre", "Sortir");
		
		opcioMenu = Validar.Int(Entrada.input, "Opció");
		
		switch(opcioMenu) {
		case 1:
			LlistaLlibres.insertarLlibre();
			break;
		case 2:
			LlistaLlibres.eliminarLlibre();
			break;
		case 3:
			LlistaLlibres.modificarLlibre();
			break;
		case 4:
			LlistaLlibres.mostrarLlibre();
			break;
		case 5:
			Sortir();
			break;
		default:
			IU.MissatgeError("La opció introduïda no és correcta");
		}
		
	}

	private static void Sortir() {
		IU.Titol("Que tinguis bona lectura! 👋📖");
		System.exit(0);
		
	}

}
