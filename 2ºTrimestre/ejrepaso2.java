import java.util.Scanner;
import java.util.Locale;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class ejrepaso2 {
    public static void main(String[] args) {
        ArrayList<Integer> temperatura = new ArrayList<Integer>();
        String ciudades[] = { "Sevilla", "Cadiz", "Jaen", "Cordoba" };
        int ran = 0;
        String ciudad;

        // elegir 3 ciudades
        for (int i = 0; i < 3; i++) {
            ran = aleatorio(0, 3);
            ciudad = ciudades[ran];
        }
        System.out.println(temperatura);
    }

    // funcion aleatorio
    public static int aleatorio(int a, int b) {
        int min;
        int max;
        int ran;

        min = Math.min(a, b);
        max = Math.max(a, b);
        ran = (int) (Math.floor((max - min + 1) * Math.random()) + min);
        return ran;
    }

    // anotaciones

    // hacer un solo random para las horas, se calcula solo los segundos y luego se
    // saca las horas

    // arraylist Object
}