import java.util.Scanner;
import java.util.ArrayList;

public class prueba1 {
    public static void main(String[] args) {
        Scanner sb = new Scanner(System.in);
        int boton = 0;
        ArrayList<Integer> resultado = new ArrayList();
        ArrayList<Integer> quiniela = new ArrayList();

        do {

            System.out.println("------------------------");
            System.out.println("Menu de la quiniela");
            System.out.println("1.Meter los resultados de tu quiniela");
            System.out.println("2.Mirar los resultados de la quiniela");
            System.out.println("3.Comprobar los resultados");
            System.out.println("4.Salir");
            System.out.println("-------------------------");
            System.out.println("Elige una opcion");
            boton = sb.nextInt();
            switch (boton) {
                case 1:
                    meterquiniela(quiniela);
                    break;
                case 2:
                    generaresul(resultado);
                    break;
                case 3:
                    check(quiniela, resultado);
            }
        } while (boton != 4);

    }

    public static void imprimir(ArrayList<Integer> quiniela) {
        for (int i = 0; i < quiniela.size(); i++) {
            System.out.println("El resultado del partido numero " + i + " es " + quiniela.get(i));
        }
    }

    public static void meterquiniela(ArrayList<Integer> quiniela) {
        Scanner sb = new Scanner(System.in);
        System.out.println(
                "Para seleccionar el primer equipo pon '1', si es empate pon '0' y si seleccione el segundo equipo pon '2'");
        for (int i = 0; i < 14; i++) {
            System.out.println("Quien ganara el partido numero " + (i + 1));
            quiniela.add(sb.nextInt());
        }
    }

    public static void generaresul(ArrayList<Integer> resultado) {
        int x;
        for (int i = 0; i < 14; i++) {
            x = (int) (Math.floor(10 * Math.random()));
            if (x >= 5) {
                resultado.add(1);
            } else if (x < 5 && x > 2) {
                resultado.add(0);
            } else {
                resultado.add(2);
            }
        }
        System.out.println("Los resultados han sido generados y son ");
        imprimir(resultado);
    }

    public static void check(ArrayList<Integer> quiniela, ArrayList<Integer> resultado) {
        int contpartido = 0;
        System.out.println("El tamaño de la quiniela es " + quiniela.size());
        System.out.println(quiniela);
        System.out.println("El tamaño de la resultados es " + resultado.size());
        System.out.println(resultado);
        for (int i = 0; i < quiniela.size(); i++) {
            System.out.println(i);
            if (quiniela.get(i) == resultado.get(i)) {
                contpartido++;
            }
        }
        System.out.println("Has obtenido " + contpartido + "aciertos");
        if (contpartido == 15) {
            System.out.println("HAS GANADO LA QUINIELAAAAAAAA");
        }
    }
}