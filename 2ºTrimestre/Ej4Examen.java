import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.text.*;
import java.util.Locale;

public class Ej4Examen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numApostado = new ArrayList<Integer>();
        int d1;
        int d2;
        int aux;
        Object matriz[][] = {

                { 0 }, // 6-6
                { 0, 0 }, // 5-5 5-6
                { 0, 0, 0 }, // 4-4 4-5 4-6
                { 0, 0, 0, 0 }, // 3-3 3-4 3-5 3-6
                { 0, 0, 0, 0, 0 }, // 2-2 2-3 2-4 2-5 2-6
                { 0, 0, 0, 0, 0, 0 }, // 1-1 1-2 1-3 1-4 1-5 1-6
        };

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <= i; j++) {
                matriz[i][j] = new ArrayList();
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                d1 = aleatorio();
                d2 = aleatorio();
                if (d1 < d2) { // d1 tiene que ser mayor que d1 siempre porque es la filas
                    aux = d1;
                    d1 = d2;
                    d2 = aux;
                }
                System.out.println("d1 " + d1 + " d2 " + d2);
                matriz[d1 - 1][d2 - 1] = 1;

                // matriz[d1 - 1][d2 - 1] = add(d1+""+d2);
            }
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }

    }

    // funcion aleatorio
    public static int aleatorio() {
        int ran;

        ran = (int) (Math.floor((6) * Math.random()) + 1);
        return ran;
    }

}