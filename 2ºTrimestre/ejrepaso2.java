import java.util.Scanner;
import java.util.Locale;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class ejrepaso2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numApostado = new ArrayList<Integer>();
        Integer T = new Integer(0);
        // en la T(tirada) se guardan el orden por asi decirlo y d1 y d2 son los numeros
        // que salen
        int d1;
        int d2;
        int aux;
        int x = 0;
        Object matriz[][] = {
                { 0 }, // 6-6
                // 1-1
                { 0, 0 }, // 5-5 5-6
                // 2-1 2-2
                { 0, 0, 0 }, // 4-4 4-5 4-6
                // 3-1 3-2 3-3
                { 0, 0, 0, 0 }, // 3-3 3-4 3-5 3-6
                // 4-1 4-2 4-3 4-4
                { 0, 0, 0, 0, 0 }, // 2-2 2-3 2-4 2-5 2-6
                // 5-1 5-2 5-3 5-4 5-5
                { 0, 0, 0, 0, 0, 0 }, // 1-1 1-2 1-3 1-4 1-5 1-6
                // 6-1 6-2 6-3 6-4 6-5 6-6
        };
        ArrayList<Integer> m[][] = new ArrayList[6][];

        for (int i = 0; i < matriz.length; i++) {
            m[i] = new ArrayList[i + 1];
            for (int j = 0; j <= i; j++) {
                m[i][j] = new ArrayList<Integer>();
            }
        }

        for (int i = 0; i < 100; i++) {
            d1 = aleatorio();
            d2 = aleatorio();
            T = Integer.valueOf(i);

            if (d1 < d2) { // d1 tiene que ser mayor que d1 siempre porque es la filas
                aux = d1;
                d1 = d2;
                d2 = aux;
            }

            m[d1][d2].add(T);

        }

        int Y = 0;
        int J = 0;
        int cantidad = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (cantidad < m[i][j].size()) {
                    cantidad = m[i][j].size();
                    Y = i;
                    J = j;
                }

            }

        }

        System.out.println("Salio la combinacion que mas a salido es " + (Y + 1) + "-" + (J + 1));
        System.out.println("La combinacion salio " + cantidad + " veces");
        System.out.println("En la tirada " + m[Y][J]);

        System.out.println();
        System.out.println();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println(" ");
        }

    }

    // funcion aleatorio
    public static int aleatorio() {
        int ran;

        ran = (int) (Math.floor((6) * Math.random()));
        return ran;
    }

}