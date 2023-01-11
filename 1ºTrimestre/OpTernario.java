import java.util.Scanner;

public class OpTernario {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int result;
		System.out.println("Primer valor:");
		int a = sc.nextInt();
		
		System.out.println("Segundo valor");
		int b = sc.nextInt();
		
		System.out.println("Tercer valor");
		int c = sc.nextInt();
		
		
		result = ((a > b) ? (a > c) ? a : c : (b > c) ? b:c);
		System.out.println ("el maximo es " + result);
	}
}