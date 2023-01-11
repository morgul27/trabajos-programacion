import java.util.Scanner;

public class mayor {
	
	public static void main (String[] arg) {
		
		Scanner sc = new Scanner (System.in);
				
		System.out.println("Inserte numero");
		System.out.println("");
		int x = sc.nextInt();
		
		System.out.println("Inserte numero");
		System.out.println("");
		int y = sc.nextInt();
		
		System.out.println("Inserte numero");
		System.out.println("");
		int z = sc.nextInt();
		
		int mayor=(x>y)?x:y;
		
		int mayor1=(z>mayor)?z:mayor;
		
		System.out.println("El mayor es:" +(mayor1) );
		System.out.println();
		
	}
}