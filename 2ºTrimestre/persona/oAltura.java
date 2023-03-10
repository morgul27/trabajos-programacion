package persona;

import java.util.Comparator;

public class oAltura implements Comparator<Persona> {

    public int compare(Persona a, Persona b) {
        int resultado = 0;

        if (a.altura < b.altura) {
            resultado = 1;
        } else if (a.altura > b.altura) {
            resultado = -1;
        }

        return resultado;
    }

}
