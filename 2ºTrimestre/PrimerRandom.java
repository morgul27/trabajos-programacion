import java.util.Scanner;

public class PrimerRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int r = 0;
        int menor;
        boolean acertar = false;
        String fin = " ";

        do {
            do {
                System.out.println("Ahora solicitaras el primer numero");
                a = solicitarNumero();
                System.out.println("Ahora solicitaras el segundo numero");
                b = solicitarNumero();
                if (Math.abs(a - b) < 10)
                    System.out.println("no hay diferencia");

            } while (Math.abs(a - b) < 10);

            menor = Math.min(a, b);
            r = (int) (Math.floor(Math.abs(a - b + 1) * Math.random()) + menor);

            System.out.println(r);
            acertar = acertarNumero(r);

            if (acertar == false) {
                System.out.println("Te has equivocado, el numero era " + r);
                System.out.println("Quieres seguir jugando? introduce fin si no quieres");
                fin = sc.nextLine();

            } else
                System.out.println("Has acertado. Fin del programa");

        } while (acertar != true || fin.equals("fin"));

    }

    // funcion para solicitar un numero
    public static int solicitarNumero() {
        Scanner sc = new Scanner(System.in);
        int a;

        do {
            System.out.println("");
            System.out.println("introduce un numero entre el 1 y 100");
            a = sc.nextInt();
        } while (a < 1 || a > 100);

        return a;
    }

    // funcion para divinar numero
    public static boolean acertarNumero(int a) {
        Scanner sc = new Scanner(System.in);
        int x;
        int c = 0;
        boolean acertar = false;

        do {
            System.out.println("introduce un numero para adivinar cual ha salido, intento " + (c + 1) + " de 5");
            x = sc.nextInt();

            if (x == a) {
                acertar = true;
                break;
            }
            c++;

        } while (x != a && c < 5);

        return acertar;
    }
}