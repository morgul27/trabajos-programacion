import java.util.Scanner;

public class registrodecontrasegna {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int x;
		int y;
		int contador=0;
		
		do{
			System.out.println("Inserte constrasegna:");
			x = sc.nextInt();

			System.out.println("Inserte de nuevo la constrasegna:");
			y = sc.nextInt();
			
		}while (x != y);
		System.out.println("Contraseña introducida correctamente");
		
		do{
			System.out.println("Inserte contraseña");
			y = sc.nextInt();
			contador++;
			if (contador==3){
					System.out.println("Demasiados intentos");
					System.exit(0);
				}
		}while (x != y);
			
		System.out.println("Contrasegna correcta");
	}
}