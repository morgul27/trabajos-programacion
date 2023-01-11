import java.util.Scanner;

public class ejfinalv1 {
	public static void main (String[] arg) {
		Scanner sc = new Scanner (System.in);
		int m[][]={{9,5,10,25,50},{100,25,666,785,400},{114,696,433,800,3},{799,2,1,0,2}};
		int suma=0;
		int resto=0;
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				int impar=0;
				impar = i+j;
				
				if (impar%2!=0) {
					suma = m[i][j] + suma;
					resto = suma%100;
					
					System.out.println("");
					System.out.println("Su suma es "+suma);
					System.out.println("Las dos últimas cifras son "+resto);
					mes(resto);
					bisiesto(suma);
				}

			}
		}
	}
	
	
	//funcion del mes
	public static void mes(int resto){
		Scanner sc = new Scanner (System.in);
		
		switch (resto) {
			case 1:
			System.out.println("Su mes es Enero");
			break;
			case 2:
			System.out.println("Su mes es Febrero");
			break;
			case 3:
			System.out.println("Su mes es Marzo");
			break;
			case 4:
			System.out.println("Su mes es Abril");
			break;
			case 5:
			System.out.println("Su mes es Mayo");
			break;
			case 6:
			System.out.println("Su mes es Junio");
			break;
			case 7:
			System.out.println("Su mes es Julio");
			break;
			case 8:
			System.out.println("Su mes es Agosto");
			break;
			case 9:
			System.out.println("Su mes es Septiembre");
			break;
			case 10:
			System.out.println("Su mes es Octubre");
			break;
			case 11:
			System.out.println("Su mes es Noviembre");
			break;
			case 12:
			System.out.println("Su mes es Diciembre");
			break;
			default:
			System.out.println("El número del mes es incorrecto");
		}
	}	
	
	
	//funcion de año bisiesto
	public static void bisiesto (int suma){
		Scanner sc = new Scanner (System.in);
		if((suma % 4 == 0) && ((suma % 100 != 0) || (suma % 400 == 0)))
			System.out.println("El año es bisiesto");
		else
			System.out.println("El año no es bisiesto");
	}
}