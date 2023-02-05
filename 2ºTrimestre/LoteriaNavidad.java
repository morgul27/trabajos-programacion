import java.util.Scanner;
import java.util.ArrayList;

public class LoteriaNavidad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numApostado = new ArrayList<Integer>();
        ArrayList<Integer> bolaBombo = new ArrayList<Integer>();
        int primerPremio;
        int premios[] = { 3000000, 60000, 20000, 100 };
        int segundoPremios[] = { 0, 0, 0 };
        int tercerPremios[] = { 0, 0, 0, 0, 0 };
        int milpremios[];
        milpremios = new int[1000];
        double saldo = 0.0;
        int ran;
        int x;
        boolean salirMenu = false;

        ran = aleatorio(1, 99999);
        numApostado.add(ran);
        System.out.println("Tienes el numero el numero " + numApostado);

        rellenarBombo(bolaBombo);

        do {
            System.out.println("");
            System.out.println("1. Coger numero");
            System.out.println("2. ");
            System.out.println("3. Meter saldo");
            System.out.println("4. Sacar saldo");
            System.out.println("5. Ver resultados");
            System.out.println("9. Ir a ver los premios");

            x = sc.nextInt();
            switch (x) {
                case 1:
                    System.out.println("9. Salir");
                    break;
                case 2:
                    System.out.println("9. Salir");
                    break;
                case 3:
                    saldo = saldo(saldo, x);
                    break;
                case 4:
                    saldo = saldo(saldo, x);
                    break;
                case 5:
                    break;
                case 9:
                    salirMenu = true;
                    break;
                default:
                    System.out.println("Se ha equivocado");

            }
        } while (!salirMenu);

        // premios
        // ahora los premios
        primerPremio = quitarnumerodelBombo(bolaBombo);

        // segundo premios
        cogerbola(segundoPremios, bolaBombo, 0, 3);
        ordenar(segundoPremios);

        // tercer premios
        cogerbola(tercerPremios, bolaBombo, 0, 5);
        ordenar(tercerPremios);

        // mil premios
        cogerbola(milpremios, bolaBombo, 0, 1000);
        ordenar(milpremios);

        // mostrar los premios
        System.out.println("El primer premio es: " + primerPremio);
        System.out.println();
        System.out.print("Los segundos premios son: ");
        mostrarPremios(segundoPremios);
        System.out.print("Los tercer premios premios son: ");
        mostrarPremios(tercerPremios);
        System.out.println("Los mil premios premios son: ");
        mostrarPremios(milpremios);

        // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        // comparaciones
        // aaaaaaaaaaaaaaaaa
        comparacionPremios(numApostado, segundoPremios);
        comparacionPremios(numApostado, tercerPremios);
        comparacionPremios(numApostado, milpremios);
    }

    // funcion para rellenar el bombo
    public static void rellenarBombo(ArrayList<Integer> bolaBombo) {
        for (int i = 0; i < 99999; i++) {
            bolaBombo.add(i + 1);
        }
    }

    // funcion para rellenar el bombo
    public static int quitarnumerodelBombo(ArrayList<Integer> bolaBombo) {
        int ran;

        ran = aleatorio(1, 99999);
        bolaBombo.remove(ran);
        bolaBombo.add(ran);

        return ran;
    }

    // funcion aleatorio
    public static int aleatorio(int a, int b) {
        int min;
        int max;
        int ran;

        min = Math.min(a, b);
        max = Math.max(a, b);
        ran = (int) (Math.floor((max - min + 1) * Math.random()) + min);
        return ran;
    }

    // funcion para for premios
    public static void cogerbola(int Premios[], ArrayList<Integer> bolaBombo, int min, int max) {
        for (int i = min; i < max; i++) {
            Premios[i] = quitarnumerodelBombo(bolaBombo);
        }
    }

    // funcion para ordenar los premios
    public static void ordenar(int Premios[]) {
        int aux;

        for (int i = 0; i < Premios.length; i++) {
            for (int j = 0; j < Premios.length - i - 1; j++) {

                if (Premios[j] > Premios[j + 1]) {
                    aux = Premios[j + 1];
                    Premios[j + 1] = Premios[j];
                    Premios[j] = aux;
                }
            }
        }
    }

    // funcion para mostrar los premios
    public static void mostrarPremios(int Premios[]) {
        for (int i = 0; i < Premios.length; i++)
            System.out.print(Premios[i] + " ");
        System.out.println(" ");
        System.out.println(" ");
    }

    // funcion para el meter o sacar saldo
    public static double saldo(Double saldo, int marcar) {
        Scanner sc = new Scanner(System.in);
        double pedir = 0;

        if (marcar == 3) {
            System.out.println("Introduzca el dinero que quiera meter");
            pedir = sc.nextDouble();
            pedir += saldo;
        } else if (marcar == 4) {
            System.out.println("Introduzca el dinero que quiera sacar");
            pedir = sc.nextDouble();
            pedir = saldo - pedir;
        }

        System.out.println("Su saldo es " + pedir);
        return pedir;
    }

    // funcion comparacion de premios
    public static void comparacionPremios(ArrayList<Integer> Premios2, int Premios[]) {
        int c = 0;
        for (int i = 0; i < Premios.length; i++) {
            for (int j = 0; j < Premios2.get(j); j++) {
                if (Premios[i] == Premios2.get(j)) {
                    c++;
                    System.out.println("Gilipollas");
                }
            }
        }
    }
}