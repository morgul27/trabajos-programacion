import java.util.Scanner;
import java.util.ArrayList;

public class juegoAzar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numApostadoLo = new ArrayList<Integer>();
        ArrayList<Integer> numApostadoEuro = new ArrayList<Integer>();
        int euromillonnum[] = { 0, 0, 0, 0, 0 };
        int estrella[] = { 0, 0 };
        int premios[] = { 3, 2, 1 };
        Double saldo = 50.00;
        int x;
        boolean salirMenu = false;

        // rellenar(euromillonnum, 50);
        // rellenar(estrella, 10);

        // Menu para jugar
        do {
            System.out.println("");
            System.out.println("1. Loteria");
            System.out.println("2. Euromillon");
            System.out.println("3. Meter saldo");
            System.out.println("4. Sacar saldo");
            System.out.println("5. Ver resultados");
            System.out.println("9. Salir");

            x = sc.nextInt();
            switch (x) {
                case 1:
                    saldo = loteria(saldo, numApostadoLo);
                    break;
                case 2:
                    saldo = Euromillon(saldo, numApostadoEuro);
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

        premios(numApostadoLo, numApostadoEuro);

    }

    // funcion para rellenar vector del euromillon
    public static void rellenar(int euromillon[], int n) {

        for (int i = 1; i < n; i++) {
            euromillon[i - 1] = i;
        }

    }

    // funcion LOTERIA
    public static double loteria(Double saldo, ArrayList<Integer> numApostadoLo) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String aceptar;

        if (saldo >= 3) {
            do {
                pedirnumero(numApostadoLo, 0, 99999);

                System.out.println("Quieres pedir otro? Di si para aceptar, tienes " + saldo + " euros");
                aceptar = sc.next();
                System.out.println("");

            } while (aceptar.equals("si") && saldo >= 3);
        }
        return saldo;
    }

    // funcion EUROMILLON
    public static double Euromillon(Double saldo, ArrayList<Integer> numApostadoEuro) {
        Scanner sc = new Scanner(System.in);
        String aceptar;

        System.out.println("Estas en el EUROMILLON");
        do {

            // 5 numeros normales
            for (int c = 0; c < 5; c++) {
                pedirnumero(numApostadoEuro, 1, 49);
            }

            // 2 estrellas
            for (int c = 0; c < 2; c++) {
                pedirnumero(numApostadoEuro, 1, 9);
            }
            saldo -= 2.5;

            System.out.println("Quieres pedir otro? Di si para aceptar, tienes " + saldo + " euros");
            aceptar = sc.next();
            System.out.println("");

        } while (aceptar.equals("si") && saldo >= 2.5);

        return saldo;
    }

    // funcion de numero ver arriba loteria
    // funcion para meter numero dentro de un juego
    public static ArrayList<Integer> pedirnumero(ArrayList<Integer> numApostado, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String aceptar = " ";

        System.out.println("¿Quieres meter numero(0) o que sea aleatorio?(1)");
        opcion = sc.nextInt();
        do {
            if (opcion == 1) {
                numApostado.add(aleatorio(min, max));
                System.out.println("Su numero es: " + numApostado);
            } else if (opcion == 0) {
                System.out.println("mete numero");
                numApostado.add(sc.nextInt());
                System.out.println("Su numero es: " + numApostado);
            } else
                System.out.println("Gilipollas");

        } while (opcion != 0 && opcion != 1);

        return numApostado;
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

    // funcion para numeros premiados
    public static void premios(ArrayList<Integer> numApostadoLo, ArrayList<Integer> numApostadoEuro) {
        int premiado;
        int c = 0;
        int resultado = 0;
        int ap = 0;
        int x = 0;

        premiado = aleatorio(0, 99999);
        System.out.println("El numero premiado de la loteria es " + premiado);
        System.out.println("Su numero es " + numApostadoLo);
        System.out.println("Sus numeros de euromillon son " + numApostadoEuro);

        System.out.println("Fin");
    }

    /*
     * for(int i=10; x<=100000; x*=10)
     * if(resultado%i == ap%i)
     * c++;
     * else
     * break;
     * 
     * 
     * else
     * 
     * switch (c) tambien es un vector
     * case 1:
     * premio=3
     * entero
     * case2:
     * premio=6
     * 
     * default
     * Los premios en un vector {3,6,15,75,3000,1800}
     * 
     * if(c==0 && abs(in premiado-ap)==1)
     * c=6;
     */
}