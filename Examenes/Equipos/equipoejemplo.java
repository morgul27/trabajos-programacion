package Equipos;

import java.util.Arrays;
import java.util.ArrayList;

public class equipoejemplo {

    public static void main(String[] args) {
        ArrayList<equipo> Equipos = new ArrayList<equipo>();
        ArrayList<equipo> Equipos2 = new ArrayList<equipo>();
        int ran;

        equipo e1 = new equipo();
        equipo e2 = new equipo();
        equipo e3 = new equipo();
        equipo e4 = new equipo();
        equipo e5 = new equipo();
        equipo e6 = new equipo();
        equipo e7 = new equipo();
        equipo e8 = new equipo();

        equipo aray[] = { e1, e2, e3, e4, e5, e6, e7, e8 };

        Equipos.add(e1);
        Equipos.add(e2);
        Equipos.add(e3);
        Equipos.add(e4);
        Equipos.add(e5);
        Equipos.add(e6);
        Equipos.add(e7);
        Equipos.add(e8);

        e1.setRanking(15);
        e1.setNombre("Betis");

        e2.setRanking(45);
        e2.setNombre("Sevilla");

        e3.setRanking(35);
        e3.setNombre("Barcelona");

        e4.setRanking(25);
        e4.setNombre("Madrid");

        e5.setRanking(50);
        e5.setNombre("Cadiz");

        e6.setRanking(6);
        e6.setNombre("DAM");

        e7.setRanking(7);
        e7.setNombre("Futbol");

        e8.setRanking(8);
        e8.setNombre("Baloncesto");

        mostrar(aray);
        System.out.println();

        System.out.println("en orden de ranking");
        Arrays.sort(aray);
        mostrar(aray);

        System.out.println();
        System.out.println("orden alfabetico");
        Arrays.sort(aray, new ordenNombre());
        mostrar(aray);

        // parte del ejercicio 20
        for (int i = 0; i < aray.length; i++) {
            ran = aleatorio(0, 7);
            Equipos.add(aray[ran]);
        }

    }

    // mostrar
    public static void mostrar(Object aray[]) {
        for (int i = 0; i < aray.length; i++) {
            System.out.println(aray[i].toString());
        }

    }

    // funcion aleatorio
    public static int aleatorio(int a, int b) {
        int max;
        int ran;

        max = Math.max(a, b);
        ran = (int) (Math.floor((max) * Math.random()));
        return ran;
    }
}
