package Exercici_7_5_Ordenacio;

public class Algorisme {

	public static void insercioDirecta(int[] array) {

		for(int i = 1; i < array.length; i++) {
			int clau = array[i];

			int j = i - 1;
			while(j >= 0 && array[j] > clau) {	
				array[j + 1] = array[j];
				j = j - 1;
			}

			array[j + 1] = clau;
		}
	}
	
	public static void intercanviDirecta(int[] array) {
		int midaArray = array.length;

		// Ordenar l'array.
		for(int i = 0; i < midaArray - 1; i++) {
			for(int j = i + 1; j < midaArray; j++) {
				if(array[i] > array[j]) {
					int nombreCanvi = array[i];
					array[i] = array[j];
					array[j] = nombreCanvi;
				}
			}
		}
	}
	
	public static void seleccioDirecta(int[] array) {
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {
			int indexMenor = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[indexMenor]) {
					indexMenor = j;
				}
			}

			int temp = array[indexMenor];
			array[indexMenor] = array[i];
			array[i] = temp;
		}
	}

}
