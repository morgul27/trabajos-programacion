package Equipos;

import java.util.Comparator;

public class ordenNombre implements Comparator<equipo> {

    public int compare(equipo a, equipo b) {
        return a.getNombre().compareTo(b.getNombre());
    }

}
