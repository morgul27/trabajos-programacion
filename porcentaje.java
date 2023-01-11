import java.util.Scanner;

public class porcentaje {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;

        System.out.println("Introduce numero del 1 al 100");
        x = sc.nextInt();

        if (x < 0)
            System.out.println("Numero erroneo");
        else if (x < 20)
            System.out.println("Opcion 1");
        else if (x < 40)
            System.out.println("Opcion 2");
        else if (x < 75)
            System.out.println("Opcion 3");
        else if (x < 100)
            System.out.println("Opcion 4");
        else
            System.out.println("Es mayor a 100");
    }
}