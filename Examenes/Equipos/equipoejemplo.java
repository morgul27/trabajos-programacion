package Equipos;

import java.util.Arrays;

public class equipoejemplo {

    public static void main(String[] args) {
        equipo e1 = new equipo();
        equipo e2 = new equipo();
        equipo e3 = new equipo();
        equipo e4 = new equipo();
        equipo e5 = new equipo();
        equipo e6 = new equipo();
        equipo e7 = new equipo();
        equipo e8 = new equipo();

        equipo aray[] = { e1, e2, e3, e4, e5, e6, e7, e8 };

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
        e6.setNombre("");

        e7.setRanking(45);
        e7.setNombre("Sevilla");

        e8.setRanking(45);
        e8.setNombre("Sevilla");

        mostrar(aray);
        System.out.println();

        System.out.println("en orden de ranking");
        Arrays.sort(aray);
        mostrar(aray);

        System.out.println();
        System.out.println("orden alfabetico");
        Arrays.sort(aray, new ordenNombre());
        mostrar(aray);

    }

    // mostrar
    public static void mostrar(Object aray[]) {
        for (int i = 0; i < aray.length; i++) {
            System.out.println(aray[i].toString());
        }

    }
}
