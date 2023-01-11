import java.util.Scanner;

public class primos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x;
		do {
			System.out.println("Introducir el número para saber si es primo o no:");
			x = sc.nextInt();
		} while (x <= 0); // meter un numero mayor que 0, sino repite el proceso

		int c = 1;

		do {
			c++;
			if (x == 2 || x == 3)
				System.out.println("es primo");

			else if (c > x / 2)
				System.out.println("es primo");

			else if (x % c == 0)
				System.out.println("no es primo");

		} while (c <= x / 2 && x % c != 0);
	}
}