package Principal;

public class OrdenacioNombresInsercioDirecta {

	private static int[] llistaNombres = {9,2,4,9,5,3,1,8,7};

	public static void main(String[] args) {

		ordenar();

	}

	private static void ordenar() {
		
		for(int i = 1; i < llistaNombres.length; i++) {
			int n = llistaNombres[i];
			for(int j = i - 1; j >= 0; j--) {	
				if(llistaNombres[j] > llistaNombres[i]) {
					llistaNombres[j + 1] = llistaNombres[j];
				}
				llistaNombres[j + 1] = n;
			}
		}

		System.out.println();
		
		for(int n : llistaNombres) {
			System.out.print(n + " ");
		}

	}
}
