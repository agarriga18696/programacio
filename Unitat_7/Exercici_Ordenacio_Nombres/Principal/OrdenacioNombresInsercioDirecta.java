package Principal;

public class OrdenacioNombresInsercioDirecta {

	private static int[] llistaNombres = {9,3,4,2,5,6,1,8,7};

	public static void main(String[] args) {

		ordenar();

	}

	private static void ordenar() {
		
		for(int i = 1; i < llistaNombres.length; i++) {
			int clau = llistaNombres[i];
			for(int j = i - 1; j < llistaNombres.length - 1; j++) {	
				if(llistaNombres[j] > clau) {
					llistaNombres[j+1] = llistaNombres[j];
					llistaNombres[i - 1] = clau;
				}
			}
		}

		System.out.println();
		
		for(int n : llistaNombres) {
			System.out.print(n + " ");
		}

	}
}
