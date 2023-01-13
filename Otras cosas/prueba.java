//OPCION A

public class prueba {
	public static void main(String[] args) {
		int a[][] = { { 9, 5, 13, 3 }, { 1, 14, 6, 12 }, { 16, 11, 4, 8 }, { 7, 2, 10, 15 } };
		int b[] = { 0, 0, 0, 0 };

		// guardar fila 0
		for (int i = 0; i < a.length; i++) {
			b[i] = a[3][i];
		}

		// mostrar matriz
		System.out.println("matriz 1");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}

		// mover datos hacia abajo
		for (int i = 3; i >= 0; i--) {
			for (int j = 0; j < a[i].length; j++) {
				if (i == 0) {
					a[0][j] = b[j];
				} else {
					a[i][j] = a[i - 1][j];
				}
			}
			System.out.println("");
		}
		System.out.println("");

		System.out.println("matriz resultado");
		// mostrar resultado
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}