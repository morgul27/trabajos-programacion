import java.util.Scanner;

public class AlumnoMedias {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor introduzca el nombre del alumno: ");
		System.out.println("");

		String nom = sc.next();
		System.out.println();
		System.out.println("////");
		System.out.println();

		System.out.println("Nota de 1EVA: ");
		System.out.println("");
		double n1 = sc.nextDouble();

		System.out.println();
		System.out.println("////");
		System.out.println();

		System.out.println("Nota de 2EVA: ");
		System.out.println("");
		double n2 = sc.nextDouble();

		System.out.println();
		System.out.println("////");
		System.out.println();

		System.out.println("Nota de 3EVA: ");
		System.out.println("");
		double n3 = sc.nextDouble();

		System.out.println();
		System.out.println("////");
		System.out.println();
		System.out.println();
		System.out.println("MEDIAS DE LAS NOTAS DE " + nom + ": " + ((n1 + n2 + n3) / 3));
		System.out.println();

		sc.close();
	}
}