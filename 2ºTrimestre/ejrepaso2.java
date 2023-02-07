import java.util.Scanner;
import java.util.Locale;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class ejrepaso2 {
    public static void main(String[] args) {
        ArrayList<String> idCiudades = new ArrayList<String>();
        idCiudades.add("Sevilla");
        idCiudades.add("Cadiz");
        idCiudades.add("Jaen");

        int fecha = 0, temp_max = 0, temp_min = 0, hora_max = 0, hora_min = 0;
        int ran = 0;
        String ciudad;

        // orden de la extructura de datos
        // { idCiudades, fecha, temp_max, temp_min, hora_max, hora_min }
        Object datos[][] = {
                { idCiudades, fecha, temp_max, temp_min, hora_max, hora_min },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
        };

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

    // funcion for
    public static void parafor(int a, int b, int idCiudad[]) {
        int min;
        int max;
        int random = 5;
        int TDias = 5;
        int Datos[][];
        Datos = new int[5][5];

        for (int i = 0; i < idCiudad.length; i++) {
            for (int j = 0; j < TDias; j++) {
                Datos[i * TDias + j][0] = i; // ciudad
                Datos[i * TDias + j][1] = j; // fecha
                Datos[i * TDias + j][2] = random; // temp max, hacer un random
                Datos[i * TDias + j][3] = random; // temp min, hacer un random
            }
        }
    }

    // anotaciones

    // hacer un solo random para las horas, se calcula solo los segundos y luego se
    // saca las horas, 24x60x60 son los segundos en un dia

    // arraylist Object

    // se supone que dos for

    // matriz ocupa tanta ciudades por dias

    // calcular TDias con las funciones de fechas

    // i*TDias+j
}