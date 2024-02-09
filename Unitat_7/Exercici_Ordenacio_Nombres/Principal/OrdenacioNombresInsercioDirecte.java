package Principal;

public class OrdenacioNombresInsercioDirecte {

	private static int[] llistaNombres = {2,5,6,1,3,4,7,9,8};

	public static void main(String[] args) {

		ordenar();

	}

	// Mètode per ordenar els nombres.
	private static void ordenar() {
		int midaLlistaNombres = llistaNombres.length;
		int nombreCanvi = 0;

		// ordenar l'array.
		for(int i = midaLlistaNombres - 1; i > 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				if(llistaNombres[i] < llistaNombres[j]) {
					nombreCanvi = llistaNombres[j];
					llistaNombres[j] = llistaNombres[i];
					llistaNombres[i] = nombreCanvi;
				}
			}
		}
		
		// mostrar l'array.
		for(int i : llistaNombres) {
			System.out.print(i + " ");
		}

	}

}
