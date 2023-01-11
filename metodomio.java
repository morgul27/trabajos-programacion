import java.util.Scanner;

public class metodomio {
	
	public static void main (String[] args) {
		int num=pedirnumero(1,10);
		System.out.println("el factorial de ese numero es "+factorial(num)); 
	} //necesito poner entre parentesis algo, al lado de factorial para pedir abajo en el metodo un numero
	
	public static int pedirnumero (int min, int max){
		Scanner sc = new Scanner (System.in);
		
		int num;
		do{
			System.out.println("Pon un numero comprendido entre "+min+" y "+max);
			num = sc.nextInt();
		}while (num<=min || num>=max);
		return num;
	}
	
	public static int factorial (int num) {
		
		int re=1;
		
		for(int i=1; i<=num; i++){
			re*=i;
	
		}
		return re;
	}
}