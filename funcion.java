import java.util.Scanner;

public class funcion {
	public static void main (String[] args)
	{
		int Numero = solicitarnumero(0,10);;
		System.out.println ("El factorial de "+Numero+" es: "+factorial(Numero));
	}//necesito poner entre parentesis algo, al lado de factorial para pedir abajo en el metodo un numero
	
	
	public static int solicitarnumero(int desde, int hasta){
			int N;
			Scanner sc = new Scanner(System.in);
			
			do{
				System.out.print ("Introduce un número mayor a "+desde+" y menor que "+hasta+": ");
				N = sc.nextInt();
			}while(N<=desde || N>=hasta);
			return N;
		}
		public static float factorial (int Numero){
			float salida=1;
			for (int i = 1; i <= Numero; i++)
				salida *= i; //es como si pusiera salida= salida*i
			return salida;
	}
}