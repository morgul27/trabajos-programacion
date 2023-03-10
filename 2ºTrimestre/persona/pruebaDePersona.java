package persona;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;

public class pruebaDePersona {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        Persona p3 = new Persona();

        Persona array1[] = { p1, p2 };

        p1.setnombre("paco");
        p1.setedad(49);
        p1.setaltura(1.5);

        p2.setnombre("pablito");
        p2.setedad(19);
        p2.setaltura(1.95);

        System.out.println("compare to de p2 " + p1.compareTo(p2));

        System.out.println();
        System.out.println("edad");
        Arrays.sort(array1);
        Persona.mostrar(array1);

        System.out.println();
        System.out.println("altura");
        Arrays.sort(array1, new oAltura());
        Persona.mostrar(array1);
    }

}
