import java.util.Scanner;

public class contadorcifrasmas5 {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int num;
		int con=0;
		
		//hasta que sea mayor de 0
		do{
			System.out.println("introduce numero mayor a 0");
			num=sc.nextInt();
		}while(num<0);
		
		
		for(int i=num; i>0; i/=10){
			con++;
			if(con==5)break; //aqui vemos si con es igual a 5, en ese caso salimos
		}
		
		//si solo tiene una cifra lo ponemos en singular, si no lo ponemos en plural, menos si la cifra es mayor a 5, que saltara otro mensaje
		if(con==1){
			System.out.println("tiene "+con+" cifra");
		}else if(con==5){
			System.out.println("el numero introducido tiene mas de 5 cifras");
		}else{
			System.out.println("tiene "+con+" cifras");
		}
		
	}
}
		
		
		