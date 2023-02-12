import java.util.ArrayList;
import java.util.Scanner;

public class porcentaje {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> Objeto = new ArrayList<String>();
        Objeto.add("azul");
        Objeto.add("verde");
        Objeto.add("blanco");
        Objeto.add("negro");

        int x;
        int c = 5;

        do {
            x = (int) (Math.floor((Objeto.size() * Math.random())));
            System.out.println(x);

            if (x < 0) {
                System.out.println("Numero erroneo");

            } else if (x < 1) {
                System.out.println(Objeto.get(x));
                Objeto.remove(x);

            } else if (x < 2) {
                System.out.println(Objeto.get(x));
                Objeto.remove(x);

            } else if (x < 3) {
                System.out.println(Objeto.get(x));
                Objeto.remove(x);

            } else if (x < 4) {
                System.out.println(Objeto.get(x));
                Objeto.remove(x);

            } else {
                System.out.println("Es mayor a 100");
            }
        } while (Objeto.isEmpty() == false);

    }
}