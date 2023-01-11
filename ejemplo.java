import java.util.Scanner;

public class ejemplo{
	
	public static void main (String[] args) {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Ejemplo de texto con salto de línea");
	System.out.print("Ejemplo de texto"); //lo que quiere decir, es que print es peor porque el texto cuando termina no salta a la siguiente línea, sino que continua, mientras que println es como si le dieras al enter
	System.out.print("Ejemplo de texto");
	
	System.out.println("");
	
	String entrada = sc.next();
	System.out.println("El valor de entrada es: "+entrada);
	}
}