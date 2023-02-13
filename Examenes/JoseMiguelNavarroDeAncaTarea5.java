import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.lang.invoke.StringConcatFactory;
import java.text.*;
import java.util.Locale;

public class JoseMiguelNavarroDeAncaTarea5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int persona;
        ArrayList<String> personas = new ArrayList<String>();

        personas.add("Jose");
        personas.add("Paco");
        personas.add("Lolo");
        personas.add("Fran");
        personas.add("Samu");
        personas.sort(null);

        if (args.length != 1)
            System.out.println("Debes ejecutar el nombre de 5 persona");

        else {
        }

        for (int i = 0; i < 3; i++) {
            persona = aleatorio(0, 4);
            System.out.println(personas.get(persona));
        }

    }

    // funcion aleatorio
    public static int aleatorio(int a, int b) {
        int ran;

        ran = (int) (Math.floor((b) * Math.random()));
        return ran;
    }
}
