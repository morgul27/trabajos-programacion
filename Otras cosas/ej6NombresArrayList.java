import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class ej6NombresArrayList {
    // dundassad
    public static void main(String[] args) {
        ArrayList<String> mujeres = new ArrayList<String>();
        ArrayList<String> hombres = new ArrayList<String>();
        ArrayList<String> apellidos = new ArrayList<String>();

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "fichero1.txt"));
            int gen;

            // para declarar una matriz de ArrayList <String> array []
            ArrayList<String> array1[] = new ArrayList[3];
            array1[0] = mujeres;
            array1[1] = hombres;
            array1[2] = apellidos;

            String genero[] = { "mujeres", "hombres" };
            String rutas[] = {
                    "mujeres.txt",
                    "hombres.txt",
                    "apellidos.txt" };

            // hacer esto con un for que envie esto 3 veces con una i y j que vayan sumando
            for (int i = 0, j = 0; i < 3; i++, j++) {
                lectura(rutas[i], array1[j]);
            }
            // int maxuser = Integer.parseInt("3000");

            for (int i = 0; i < 3000; i++) {
                // gen es el genero, que sale aleatoriamente sin tener que preguntar más tarde
                // cual es
                gen = aleatorio(0, 100) / 55; // para quitar la parte entera dividir entre 55, enviar 0
                                              // al 100

                // estoy cogiendo dentro del array, el nombre aleatoriamente del Arraylist
                String nombres = (array1[gen])
                        .get(aleatorio(0, ((array1[gen]).size() - 1)));

                // Aqui estoy escribiendo el nombre de la persona y los dos apellidos con un
                // salto de linea al final
                bw.write("'" + nombres + "','" + apellidos.get(aleatorio(0, apellidos.size() - 1)) + " "
                        + apellidos.get(aleatorio(0, apellidos.size() - 1)) + "'," + fechas()
                        + ", '" + genero[gen]
                        + "' \n");

            }

            bw.close();

        } catch (IOException ioe) {
            System.out.println("Se ha producido un error de lectura/escritura");
            System.err.println(ioe.getMessage());
        }
    }

    // funcion de fechas
    public static String fechas() {

        // Aqui cogemos el primer dia que quiero y luego el ultimo dia que quiero mirar
        LocalDate dia1 = LocalDate.of(1918, Month.JANUARY, 1);
        LocalDate dia2 = LocalDate.of(2015, Month.DECEMBER, 30);
        LocalDate fechana; // fecha de nacimiento

        // Con el ChronoUnit mira el intervalo de los dos dias que he puesto
        long intervalo = ChronoUnit.DAYS.between(dia1, dia2);
        intervalo = aleatorio(0, intervalo);
        fechana = dia1.plusDays(intervalo);

        return String.format("%04d%02d%02d", fechana.getYear(), fechana.getMonthValue(),
                fechana.getDayOfMonth());

    }

    // leer fichero y guardando los nombre o el apellido en un ArrayList
    public static void lectura(String texto, ArrayList<String> array) {
        String linea1 = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(texto));

            while ((linea1 != null)) {
                linea1 = br.readLine();
                (array).add(linea1);
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
