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
        Integer T = new Integer(0);
        // en la T(tirada) se guardan el orden por asi decirlo y d1 y d2 son los numeros
        // que salen
        int d1;
        int d2;
        int aux;
        int x = 0;
        ArrayList<Integer> m[][] = new ArrayList[6][];

        for (int i = 0; i < 6; i++) {
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
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++) {
                if (cantidad < m[i][j].size()) {
                    cantidad = m[i][j].size();
                    Y = i;
                    J = j;
                }

            }

        }

        System.out.println("La combinacion que mas a salido es " + (Y + 1) + "-" + (J + 1));
        System.out.println("La combinacion salio " + cantidad + " veces");
        System.out.println("En la tirada " + m[Y][J]);

    }

    // funcion aleatorio
    public static int aleatorio() {
        int ran;

        ran = (int) (Math.floor((6) * Math.random()));
        return ran;
    }

}