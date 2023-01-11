import java.util.Scanner;

public class encuesta {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int a[][] = new int[4][3];

		/*
		 * la j1 es genero, j2 es edad y j3 numeros de hermanos
		 * int b[][]={{0,2,3},{0,30,0},{0,42,2},{0,50,2}};
		 */

		// preguntas
		for (i = 0; i < a.length; i++) {
			do {
				System.out.println("persona numero " + (i + 1) + " indique si eres hombre 1 o mujer 2");
				a[i][0] = sc.nextInt();
			} while (a[i][0] < 1 || a[i][0] > 2);

			System.out.println("persona numero " + (i + 1) + " indique su edad");
			a[i][1] = sc.nextInt();

			System.out.println("persona numero " + (i + 1) + " indique el numero de hermanos");
			a[i][2] = sc.nextInt();
		}

		int mayor = 0;
		int mediam = 0;
		int mediah = 0;
		int contadorh2 = 0;
		int contadorhm = 0;
		int contadorm = 0;

		for (i = 0; i < a.length; i++) {
			if (a[i][0] == 1 && a[i][2] == 0) {
				if (mayor < a[i][1]) {
					mayor = a[i][1];
				}
			}
			if (a[i][0] == 2) {
				contadorm += 1;
				mediam = mediam + a[i][1];
			}
			mediah = mediah + a[i][2];

			if (a[i][2] > 2) {
				contadorh2++;
			}

			if (a[i][1] < 30 && a[i][2] < 2) {
				contadorm++;
			}

		}
		System.out.println("La edad del mayor de los hombres que es hijo unico es: " + mayor);
		System.out.println("La media de edad de las mujeres encuestadas es: " + (mediam / contadorm));
		System.out.println("La media de hermanos de las personas encuestadas es: " + (mediah / 10));
		System.out.println("El porcentaje de personas que tengan más de dos hermanos es: " + ((contadorh2 / 10) * 100));
		System.out.println("El porcentaje de personas con menos de 30 anos y con menos de dos hermanos es: "
				+ ((contadorm / 10) * 100) + "%");

	}
}