import java.util.Scanner;

public class expendedora {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String a[][]={{"producto11","producto12","producto13","producto14","producto15"},{"producto21","producto22","producto23","producto24","producto25"},{"producto31","producto32","producto33","producto34","producto35"},{"producto41","producto42","producto43","producto44","producto45"}};
		int b[][]={{11,12,13,14,15},{21,22,23,24,25},{31,32,33,34,35},{41,42,43,44,45}};
		double c[][]={{11.1,12.2,13.3,14.4,15.5},{21,22,23,24,25},{31,32,33,34,35},{41,42,43,44,45}};
		int x;
		boolean salirMenu = false;
		
		
		do{
			System.out.println ("");
			System.out.println ("1.Nombre del producto");
			System.out.println ("2.precio");
			System.out.println ("3.comprar");
			System.out.println ("4.Ver Stock");
			System.out.println ("5.Salir");
			x = sc.nextInt();
			
			switch (x){
			case 1:
				ver(a);
				break;
			case 2:				
				precio(c);
				break;
			case 3:
				comprar(c,b,a);	
				break;
			case 4:
				Stock(b);	
				break;
			case 5:			
				salirMenu = true;	
				break;
			default:
				System.out.println ("Debe introducir un numero entre 1 y 5");
			}
		}while (!salirMenu);
		System.out.println ("Fin ejercicio");
		
	}
	
	//funcion ver el producto
	public static void  ver(String a[][]) {
		Scanner sc = new Scanner(System.in);
		int x;
		int i;
		int j;
		do{
			System.out.println ("Selecciona un numero entre 11 y 45 para ver el nombre del producto");
			x = sc.nextInt();
			i=x/10;
			i=i-1;
			j=x%10;
			j=j-1;
		
		}while(x<11 || x>15 && x<21 || x>25 && x<31 || x>35 && x<41 || x>45);
		System.out.println ("");
		System.out.println ("El nombre del producto seleccionado es: "+a[i][j]);
	}
	
	//funcion precio
	public static void precio(double c[][]) {
		Scanner sc = new Scanner(System.in);
		int x;
		int i;
		int j;
		do{
			System.out.println ("Selecciona un numero entre 11 y 45 para ver el precio del producto");
			x = sc.nextInt();
			i=x/10;
			i=i-1;
			j=x%10;
			j=j-1;
			
			
		}while(x<11 || x>15 && x<21 || x>25 && x<31 || x>35 && x<41 || x>45);
		System.out.println ("El precio del producto seleccionado cuesta: "+c[i][j]);
	}
	
	//funcion ver comprar
	public static void comprar(double c[][], int b[][], String a[][]) {
		Scanner sc = new Scanner(System.in);
		int x;
		int i;
		int j;
		do{
			System.out.println ("Selecciona un numero entre 11 y 45 para ver el precio del producto");
			x = sc.nextInt();
			i=x/10;
			i=i-1;
			j=x%10;
			j=j-1;
			
			b[i][j]=b[i][j]-1;
			
		}while(x<11 || x>15 && x<21 || x>25 && x<31 || x>35 && x<41 || x>45);
		System.out.println ("El precio del producto "+a[i][j]+" es: "+c[i][j]);
		System.out.println (c[i][j]);
		
	}
	
	//funcion Stock
	public static void Stock(int b[][]) {
		Scanner sc = new Scanner(System.in);
		int x;
		int i;
		int j;
		do{
			System.out.println ("Selecciona un numero entre 11 y 45 para ver el precio del producto");
			x = sc.nextInt();
			i=x/10;
			i=i-1;
			j=x%10;
			j=j-1;
			
			
		}while(x<11 || x>15 && x<21 || x>25 && x<31 || x>35 && x<41 || x>45);
		System.out.println ("El Stock del producto seleccionado es: "+b[i][j]);
	}
	
}