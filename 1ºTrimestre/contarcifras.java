import java.util.Scanner;

public class contarcifras {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int num=0;
		int con=0;
		
		do{
			System.out.println("Pon un numero entero:");
			num = sc.nextInt();
		}while (num<0);
		for (int i=num; i>0;i/=10){ //i>0 para salir o no del para, luego i entre 10 guardandolo en i, para hacer que salga una cifra más pequeña de 0  
			con++; //suma +1 cada vez que pasa por aqui, es decir, cada vez que se divide y el cociente no es 0
		} 
		if(con==1){
			System.out.println("el numero "+num+" tiene "+con+" cifra");
		}else{
		System.out.println("el numero "+num+" tiene "+con+" cifras");
		}
	}
}