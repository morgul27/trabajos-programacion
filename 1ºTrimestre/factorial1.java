import java.util.Scanner;

public class factorial1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num;
		double re = 1;

		// hacer esto hasta que sea mayor a 1, es decir, 2 y menor a 20, es decir, 19
		do {
			System.out.println("introduce numero mayor a 1 y menor que 20");
			num = sc.nextInt();
		} while (num <= 1 || num >= 20);

		// si solo tengo la variable num se crea un bucle infinito porque la i nunca
		// llega a num, por ello usamos re
		for (int i = 1; i <= num; i++) {
			re *= i;
			System.out.println(re);
		}
		System.out.println("El factorial de " + num + " es " + re);

	}
}