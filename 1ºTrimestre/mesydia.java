import java.util.Scanner;

public class mesydia {
	public static void main (String[] arg) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Introduzca número del mes: ");
		int mes = sc.nextInt();
		
		switch (mes) {
			case 1:
			System.out.println("Su mes es Enero, Enero consta de 31 días");
			break;
			case 2:
			System.out.println("Su mes es Febrero, Febrero consta de 28 días");
			break;
			case 3:
			System.out.println("Su mes es Marzo, Marzo consta de 31 días");
			break;
			case 4:
			System.out.println("Su mes es Abril, Abril consta de 30 días");
			break;
			case 5:
			System.out.println("Su mes es Mayo, Mayo consta de 31 días");
			break;
			case 6:
			System.out.println("Su mes es Junio, Junio consta de 30 días");
			break;
			case 7:
			System.out.println("Su mes es Julio, Julio consta de 31 días");
			break;
			case 8:
			System.out.println("Su mes es Agosto, Agosto consta de 31 días");
			break;
			case 9:
			System.out.println("Su mes es Septiembre, Septiembre consta de 30 días");
			break;
			case 10:
			System.out.println("Su mes es Octubre, Octubre consta de 31 días");
			break;
			case 11:
			System.out.println("Su mes es Noviembre, Noviembre consta de 30 días");
			break;
			case 12:
			System.out.println("Su mes es Diciembre, Diciembre consta de 31 días");
			break;
			default:
			System.out.println("El número del mes es incorrecto");
		}
	}
}