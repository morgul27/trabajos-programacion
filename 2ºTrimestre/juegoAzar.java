import java.util.Scanner;
import java.util.ArrayList;

public class juegoAzar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numApostado = new ArrayList<Integer>();
        Double saldo = 0.00;
        int x;

        System.out.println("");
        System.out.println("1. Loteria");
        System.out.println("2. Euromillon");
        System.out.println("3. Meter saldo");
        System.out.println("4. Sacar saldo");
        System.out.println("5. Ver resultados");

        // Menu para jugar
        x = sc.nextInt();
        switch (x) {
            case 1:
                loteria(saldo, numApostado);
                break;
            case 2:
                System.out.println("euromillon");
                break;
            case 3:
                saldo = metersaldo(saldo);
                break;
            case 4:
                saldo = sacarsaldo(saldo);
                break;
            case 5:
                break;
            default:
                System.out.println("Se ha equivocado");

        }

        premios(numApostado);

    }

    // funcion loteria
    public static ArrayList<Integer> loteria(Double saldo, ArrayList<Integer> numApostado) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String aceptar;
        int x;
        int num = 0;

        if (saldo >= 3) {
            do {
                System.out.println("¿Quieres meter numero(0) o que sea aleatorio?(1)");
                opcion = sc.nextInt();
                if (opcion == 1)
                    numApostado.add(aleatorio(0, 99999));
                else if (opcion == 0) {
                    System.out.println("mete numero");
                    numApostado.add(sc.nextInt());
                }

                saldo -= 3;
                System.out.println("su numero es: " + numApostado);

                System.out.println("Quieres pedir otro? Di si para aceptar, tienes " + saldo + " euros");
                aceptar = sc.nextLine();
                System.out.println("");

            } while (aceptar.equals("si") && saldo >= 3);
        }
        return numApostado;

    }

    // funcion euromillon
    public static void euromillon() {

    }

    // funcion para el meter saldo
    public static double metersaldo(Double saldo) {
        Scanner sc = new Scanner(System.in);
        double suma = 0;

        System.out.println("Introduzca su saldo");
        saldo = sc.nextDouble();
        suma += saldo;
        return suma;
    }

    // funcion para sacar el saldo
    public static double sacarsaldo(Double saldo) {
        Scanner sc = new Scanner(System.in);
        double resta = 0;

        System.out.println("Introduzca su saldo");
        saldo = sc.nextDouble();
        resta = saldo - resta;
        return resta;
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
    public static void premios(ArrayList<Integer> numApostado) {
        int num;
        num = aleatorio(0, 9999);
        System.out.println("El numero premiado de la loteria es " + num);
        System.out.println("Su numero es " + numApostado);
    }
}