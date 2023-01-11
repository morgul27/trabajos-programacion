import java.util.Scanner;

public class solicitarentero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Inserte numero");
		System.out.println("");
		int i = sc.nextInt();

		if (i < 10)
			System.out.println(i + " es una unidad");
		else if (i < 100)
			System.out.println(i + " tiene una decena");
		else if (i < 1000)
			System.out.println(i + " tiene una centena");
		else if (i >= 1000)
			System.out.println(i + " tiene una milesima");
		else
			System.out.println(i + "es mayor a 1000");
	}
}