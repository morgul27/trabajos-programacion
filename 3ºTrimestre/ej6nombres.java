import java.util.ArrayList;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.text.*;

public class ej6nombres {
    public static void main(String[] args) {
        ArrayList<String> mujeres = new ArrayList<String>();
        ArrayList<String> hombres = new ArrayList<String>();
        ArrayList<String> apellidos = new ArrayList<String>();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("fichero1.txt"));
            int gen;

            Object array[] = { mujeres, hombres, apellidos };
            String rutas[] = { "mujeres.txt", "hombres.txt", "apellidos.txt" };

            // hacer esto con un for que envie esto 3 veces con una i y j que vayan sumando
            for (int i = 0, j = 0; i < 3; i++, j++) {
                lectura(rutas[i], array[j]);
            }

            for (int i = 0; i < 3000; i++) {
                // gen es el genero, que sale aleatoriamente sin tener que preguntar más tarde
                // cual es
                gen = aleatorio(0, 100) / 55; // para quitar la parte entera dividir entre 55, enviar 0 al 100

                // estoy cogiendo dentro del array, el nombre aleatoriamente del Arraylist
                String nombres = ((ArrayList<String>) array[gen])
                        .get(aleatorio(0, (((ArrayList<String>) array[gen]).size() - 1)));

                // Aqui estoy escribiendo el nombre de la persona y los dos apellidos con un
                // salto de linea al final
                bw.write(nombres + " " + apellidos.get(aleatorio(0, apellidos.size() - 1)) + " "
                        + apellidos.get(aleatorio(0, apellidos.size() - 1)) + "\n");

            }

            bw.close();

        } catch (IOException ioe) {
            System.out.println("Se ha producido un error de lectura/escritura");
            System.err.println(ioe.getMessage());
        }
        fechas();
    }

    // funcion de fechas
    public static void fechas() {

        // String fechana = String.valueOf(ano*10000 + mes*100 + dia);

        // Aqui cogemos el primer dia que quiero y luego el ultimo dia que quiero mirar
        LocalDate dia1 = LocalDate.of(1918, Month.JANUARY, 1);
        LocalDate dia2 = LocalDate.of(2015, Month.DECEMBER, 30);
        LocalDate fechana; // fecha de nacimiento

        // Con el ChronoUnit mira el intervalo de los dos dias que he puesto
        long intervalo = ChronoUnit.DAYS.between(dia1, dia2);
        System.out.println(intervalo);
        intervalo = aleatorio(0, intervalo);
        System.out.println(intervalo);

        fechana = dia1.plusDays(intervalo);
        System.out.println(fechana);
    }

    // leer fichero y guardando los nombre o el apellido en un ArrayList
    public static void lectura(String texto, Object array) {
        String linea1 = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(texto));

            while ((linea1 != null)) {
                linea1 = br.readLine();
                ((ArrayList<String>) array).add(linea1);
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println("Se ha producido un error de lectura/escritura");
            System.err.println(ioe.getMessage());
        }

    }

    // Método para GENERAR UN ENTERO ALEAORIO DENTRO DE UN RANGO
    public static int aleatorio(int menor, int mayor) {
        int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
        return n;
    }

    // Método sobrecargado de aleatorio para poder hacelo con las fechas
    public static int aleatorio(int menor, Long mayor) {
        int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
        return n;
    }

}