package Exercici_7_5_Ordenacio;

public class OrdenarArray {
	
	private static boolean sortir = false;

	public static void main(String[] args) {
		
		do {
			
			int[] array = inicialitzarArray();		
			seleccionarAlgorisme(array);
			mostrarArray(array);
			
		} while(!sortir);
		
	}

	private static int[] inicialitzarArray() {
		System.out.println("\n ORDENACIÓ DE NOMBRES");

		int mida = Entrada.enter("De quina mida vols l'array?");
		// Inicialitzar l'array amb la mida.
		int[] array = new int[mida];

		// Afegir els nombres a l'array.
		for(int i = 0; i < mida; i++) {
			int nombre = Entrada.enter("Nombre " + (i+1));
			array[i] = nombre;
		}

		return array;
	}

	private static void mostrarOpcionsMenu() {
		System.out.println(System.lineSeparator());
		System.out.println(" ALGORISME");
		System.out.println(" (1) Inserció directa");
		System.out.println(" (2) Selecció directa");
		System.out.println(" (3) Intercanvi directa");
		System.out.println(" (4) Sortir");
	}

	private static void seleccionarAlgorisme(int[] array) {
		int opcio = 0;

		mostrarOpcionsMenu();
		opcio = Entrada.enter("Opció");

		switch(opcio) {
		case 1:
			Algorisme.insercioDirecta(array);
			break;
		case 2:
			Algorisme.seleccioDirecta(array);
			break;
		case 3:
			Algorisme.intercanviDirecta(array);
			break;
		case 4:
			sortir();
			break;
		default:
			Missatge.error("Opció no vàlida");
			break;
		}

	}

	private static void mostrarArray(int[] array) {
		System.out.println(System.lineSeparator());
		System.out.println(" ARRAY ORDENAT\n");

		for(int i : array) {
			System.out.print(" " + i + " ");
		}
		
		System.out.println(System.lineSeparator());
	}

	private static void sortir() {
		sortir = true;
		System.out.println("Fins una altra! 👋");
		System.exit(0);
	}

}
