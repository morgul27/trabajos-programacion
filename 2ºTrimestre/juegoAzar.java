import java.util.Scanner;

public class juegoAzar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int saldo = 0;

        System.out.println("Introduzca su saldo");
        saldo = sc.nextInt();

        int x;

        // Menu para jugar
        x = sc.nextInt();
        switch (x) {
            case 1:
                System.out.println("loteria");
                break;
            case 2:
                System.out.println("euromillon");
                break;
        }

    }

    // funcion loteria
    public static void loteria() {
        Scanner sc = new Scanner(System.in);
        String palabra;

        System.out.println("¿Quieres meter numero o que sea aleatorio?");
        palabra = sc.nextLine();
        if (palabra.equals("aleatorio"))
            aleatorio(0, 99999);
    }

    // funcion euromillon
    public static void euromillon() {

    }

    // funcion aleatorio
    public static void aleatorio(int a, int b) {
        int min;
        int max;
        int ran;

        min = Math.min(a, b);
        max = Math.max(a, b);
        ran = (int) (Math.floor((max - min + 1) * Math.random()) + min);
    }

}