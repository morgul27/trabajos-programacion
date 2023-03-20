package Equipos;

import java.util.Comparator;

public class ordenNombre implements Comparator<equipo> {

    public int compare(equipo a, equipo b) {
        int resultado = 0;

        if (a.caracter(a.nombre) < b.caracter(b.nombre)) {
            resultado = -1;
        } else if (a.caracter(a.nombre) > b.caracter(b.nombre)) {
            resultado = 1;
        }

        return resultado;
    }

}
