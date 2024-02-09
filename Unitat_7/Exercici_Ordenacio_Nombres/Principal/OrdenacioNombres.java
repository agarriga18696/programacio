package Principal;

public class OrdenacioNombres {

	private static int[] llistaNombres = {2,5,6,1,3,7,4,9,8};

	public static void main(String[] args) {

		ordenar();

	}

	private static void ordenar() {
		int midaLlistaNombres = llistaNombres.length;
		
		for(int i = midaLlistaNombres - 1; i > 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				if(llistaNombres[i] < llistaNombres[j]) {
					llistaNombres[j] = llistaNombres[i];
					llistaNombres[i] = i + 1;
				}
			}
		}

		System.out.println();
		
		for(int n : llistaNombres) {
			System.out.print(n + " ");
		}

	}
}
