package Equipos;

import java.util.Arrays;

public class equipoejemplo {

    public static void main(String[] args) {
        equipo e1 = new equipo();
        equipo e2 = new equipo();

        equipo aray[] = { e1, e2 };

        e1.setRanking(15);
        e1.setNombre("Betis");

        e2.setRanking(45);
        e2.setNombre("Sevilla");

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
