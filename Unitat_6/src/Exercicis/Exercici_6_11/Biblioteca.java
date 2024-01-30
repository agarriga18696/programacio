package Exercicis.Exercici_6_11;

public class Biblioteca {

	public static void main(String[] args) {
		
		IU.SaltLinea();
		IU.Titol("BENVINGUT/DA A LA BIBLIOTECA");
		while(true) {
			menuPrincipal();
		}
		
	}
	
	private static void menuPrincipal() {
		
		IU.Separador();
		IU.MenuOpcions("Insertar Llibre", "Eliminar Llibre", "Modificar Llibre", "Mostrar Llibre", "Sortir");
		
		int opcioMenu = Validar.Int(Entrada.input, "Opció");
		
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
		IU.SaltLinea();
		System.out.println(" Que tinguis bona lectura! 👋");
		System.exit(0);
		
	}

}
