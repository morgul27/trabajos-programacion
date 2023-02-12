import java.util.Scanner;
import java.util.ArrayList;

public class prueba1 {
    public static void main(String[] args) {
        Scanner sb = new Scanner(System.in);
        String pa = "abcd caca";

        for (int i = 0; i < pa.length(); i++) {
            char b = 'a';
            for (int j = 0; j < pa.length(); j++, b++) {
                if (pa.charAt(i) == b) {
                    System.out.println("Las vocales iguales que hay son: " + pa.charAt(i));
                }
            }
        }

        String cad = "cadena caco o";
        int p = -1;
        int cont = 0;
        char c = ' ';

        do {
            p = cad.indexOf(c, ++p); // la funcion de "p" es saltar despues del espacio y luego el valor es
                                     // sustituido por otro que este más adelante
            System.out.println(p);
            if (p >= 0)
                cont++;
        } while (p >= 0 && p < cad.length());
        System.out.println(cont);
    }
}