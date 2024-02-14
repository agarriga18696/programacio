package Principal;

public class OrdenacioNombres {

	private static int[] llistaNombres = {9,2,4,9,5,3,1,8,7};

	public static void main(String[] args) {

		ordenar();

	}

	private static void ordenar() {
		
		for(int i = 1; i < llistaNombres.length; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(llistaNombres[j] > llistaNombres[i]) {
					llistaNombres[j + 1] = llistaNombres[j];
				} else {
					llistaNombres[j + 1] = llistaNombres[i];
					break;
				}
				
			}
		}

		System.out.println();
		
		for(int n : llistaNombres) {
			System.out.print(n + " ");
		}

	}
}
