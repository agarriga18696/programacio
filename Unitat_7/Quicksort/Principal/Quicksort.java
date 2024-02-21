package Principal;

public class Quicksort {

	public static void main(String[] args) {

		int[] array = {1,6,7,4,8,2,9,3,5};
		int primerIndex = 0;
		int darrerIndex = array.length - 1;
		
		System.out.println("+---------------+");
		System.out.println("|   QUICKSORT   |");
		System.out.println("+---------------+\n");

		// Mostrar array antes d'ordenar.
		System.out.println("Array desordenat: ");
		mostrar(array);

		quicksort(array, primerIndex, darrerIndex);

		// Mostrar array després d'ordenar.
		System.out.println("Array ordenat: ");
		mostrar(array);

	}

	// Mètode per ordenar amb quicksort.
	private static void quicksort(int array[], int primerIndex, int darrerIndex) {
		int esquerra, dreta, pivot, canvi;

		if(array.length > 1) {
			esquerra = primerIndex;
			dreta = darrerIndex;
			pivot = array[(esquerra + dreta) / 2];

			while(esquerra <= dreta) {
				while(array[esquerra] < pivot) {
					esquerra++;
				}

				while(array[dreta] > pivot) {
					dreta--;
				}

				if(esquerra <= dreta) {
					// Intercanviar les posicions.
					canvi = array[esquerra];
					array[esquerra] = array[dreta];
					array[dreta] = canvi;
					esquerra++;
					dreta--;
				}
			}

			if(primerIndex < dreta) {
				quicksort(array, primerIndex, dreta);
			}

			if(esquerra < darrerIndex) {
				quicksort(array, esquerra, darrerIndex);
			}
		}
	}
	
	// Mètode per mostrar l'array.
	private static void mostrar(int[] array) {
		
		for(int i : array) {
			System.out.print(i + ", ");
		}
		
		System.out.println(System.lineSeparator());
		
	}

}
