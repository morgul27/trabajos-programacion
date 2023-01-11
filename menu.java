import java.util.Scanner;

public class menu {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int x;
		boolean salirMenu = false;
		boolean matrizOk = false;
		
		do{
			System.out.println ("");
			System.out.println ("1.Rellena una matriz de enteros de 4x4");
			System.out.println ("2.Mostrar la matriz introducida");
			System.out.println ("3.Suma la diagonal principal");
			System.out.println ("4.Suma la diagonal inversa");
			System.out.println ("5.Salir");
			x = sc.nextInt();
			
			switch (x){
			case 1:
				matrizOk = matriz(a);
				break;
			case 2:
				if (matrizOk)
					mostrar(a);
				else
					System.out.println("La matriz aun esta vacia");
				break;
			case 3:
				if (matrizOk)
					System.out.println ("La suma de la diagonal principal es: "+diagonal(a));
				else
					System.out.println("La matriz aun esta vacia");		
				break;
			case 4:
				if (matrizOk)
					System.out.println ("La suma de la diagonal inversa es: "+diagonalin(a));
				else
					System.out.println("La matriz aun esta vacia");		
				break;
			case 5:			
					salirMenu = true;	
				break;
			default:
				System.out.println ("Debe introducir un numero entre 1 y 4");
			}
		}while (!salirMenu);
		System.out.println ("Fin ejercicio");
		
	}
	
	//funcion 1 para rellenar la matriz
	public static boolean matriz (int a[][]) {
		Scanner sc = new Scanner(System.in);
		System.out.println ("mete numeros hasta completar la matriz de 4x4");
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				a[i][j] = sc.nextInt();
			}
		}
		return true;
	}
	
	//funcion 2 para mostrar la matriz introducida
	public static void mostrar (int a[][]) {
		System.out.println("");
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print (a[i][j]+" ");
			} System.out.println ("    ");
		}
	}
	
	//funcion 3 suma la diagonal principal
	public static int diagonal (int a[][]) {
		int suma = 0;
		for (int i = 0; i < a.length; i++){
			suma += a[i][i];
		}
		return suma;
	}
	
	//funcion 4 suma la diagonal inversa
	public static int diagonalin (int a[][]) {
		int suma = 0;
		for (int i = 0, j = 3; i < a.length; i++, j--){
			suma += a[i][j];
		}
		return suma;
	}
}