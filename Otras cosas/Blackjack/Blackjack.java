package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // hacerlo con arrays
        ArrayList<Integer> repartidor = new ArrayList<Integer>();
        ArrayList<Integer> jugador = new ArrayList<Integer>();
        ArrayList<Integer> baraja = new ArrayList<Integer>();
        // para hacerlo con clases
        Jugadores j1 = new Jugadores();
        int i = 1;
        int al = 0;// numero aleatorio que te toca
        // probando cosas
        // barajal es de baraja letras, que sirve para mostrarlas
        String barajal[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        // cosas para arreglar
        for (int j = 0; j < 4; j++) {
            for (int q = 1; q < 14; q++)
                baraja.add(q);
        }
        System.out.println(baraja);

        // prueba de array baraja
        al = aleatorio(1, 12);
        System.out.print("miraaaaaaaaaaaaaaa ");
        System.out.println(barajal[baraja.get(al) - 2]);

        // tengo que añadir j1 con baraja sin nada, es decir arraylist y quitar barajac,
        // que ya no me sirve de nada

        // eran las pruebas
        Integer barajac[][] = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }
        }; // barajac de baraja contar, sirve para ir sumando los numeros

        // con otra baraja, pero esta vez de String no hace falta tener un switch
        jugador.add(barajac[0][11]);
        jugador.add(barajac[0][12]);
        jugador.add(barajac[0][0]);

        System.out.println("Tus cartas son: ");
        for (i = 0; i < jugador.size(); i++) {
            System.out.print(jugador.get(i) + " ");
            System.out.print(barajal[jugador.get(i) - 1] + " ");

        }
        System.out.println();

        // probando
        al = aleatorio(0, 12);
        j1.setManol(barajal[al]);
        j1.setManon(barajac[0][al]);
        System.out.println(barajac[0][al]);

        al = aleatorio(0, 12);
        j1.setManol(barajal[al]);
        j1.setManon(barajac[0][al]);
        System.out.println(barajac[0][al]);

        // mostrar todo(el toString)
        System.out.println(j1);

    }

    // Método para GENERAR UN ENTERO ALEAORIO DENTRO DE UN RANGO
    public static int aleatorio(int menor, int mayor) {
        int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
        return n;
    }

    // metodo
    public static void a(int menor, int mayor) {
        System.out.println();
    }

    // hacer un metodo para pedir, retirarse o doblar la apuesta

    // hacer otro para mostrar la baraja
}