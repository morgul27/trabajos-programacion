package Equipos;

import java.util.Arrays;
import java.util.ArrayList;

public class equipoejemplo {

    public static void main(String[] args) {
        ArrayList<equipo> Equipos = new ArrayList<equipo>();
        ArrayList<equipo> Equipos1 = new ArrayList<equipo>();
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
        equipo campo[];
        campo = new equipo[8];

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
        Equipos.sort(new ordenNombre());
        mostrar(aray);

        // parte del ejercicio 20
        for (int i = 0, j = 0; i - j < Equipos.size(); i++, j++) {
            ran = aleatorio(Equipos.size() - 1);
            Equipos1.add(Equipos.get(ran));
            Equipos.remove(ran);
            Equipos2.add(Equipos.get(ran));
            Equipos.remove(ran);
        }

        // campo
        elegir(campo, Equipos1, Equipos2);

        System.out.println();

        // for final
        for (int i = 0, j = 0; i < Equipos1.size(); i++) {
            System.out.println("El equipo de " + Equipos1.get(i) + " se enfrentará a " + Equipos2.get(i)
                    + " en el campo de " + campo[i].getNombre());
        }

        elegir(campo, Equipos1, Equipos2);
        System.out.println();

        for (int i = 0; i < Equipos1.size(); i++) {
            System.out.println("El ganador del partido " + (i + 1) + " es " + campo[i].getNombre());

        }

    }

    // mostrar
    public static void mostrar(Object aray[]) {
        for (int i = 0; i < aray.length; i++) {
            System.out.println(aray[i].toString());
        }

    }

    // for campo
    public static void elegir(equipo campo[], ArrayList<equipo> Equipos1, ArrayList<equipo> Equipos2) {
        for (int i = 0; i < Equipos1.size(); i++) {
            int j = aleatorio(2);
            if (j == 0) {
                campo[i] = Equipos1.get(i);
            } else {
                campo[i] = Equipos2.get(i);
            }
        }
    }

    // funcion aleatorio
    public static int aleatorio(int b) {
        int ran;

        ran = (int) (Math.floor((b) * Math.random()));
        return ran;
    }

}
