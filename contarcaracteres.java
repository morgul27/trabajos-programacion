import java.util.Scanner;

public class contarcaracteres {
 
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        String cadena;
		System.out.println("Escribe");
		cadena=sc.nextLine();
         
        System.out.println("La cadena tiene "+cadena.length()+" caracteres");
         
    }
}