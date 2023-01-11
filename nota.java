import java.util.Scanner;

public class nota {
	public static void main (String[] arg) {
		Scanner sc = new Scanner (System.in);
				
		System.out.println("Nombre alumno:");
		System.out.println("");
		String nombre_alumno = sc.next();
		
		System.out.println("Nota primera evaluacion:");
		System.out.println("");
		double evaluacion1 = sc.nextDouble();
		
		System.out.println("Nota segunda evaluacion:");
		System.out.println("");
		double evaluacion2 = sc.nextDouble();
		
		System.out.println("Nota tercera evaluacion:");
		System.out.println("");
		double evaluacion3 = sc.nextDouble();
		
		System.out.println("MEDIAS DE LAS NOTAS DE "+nombre_alumno+": "+((evaluacion1 + evaluacion2 + evaluacion3)/3));
		System.out.println();
	}
}