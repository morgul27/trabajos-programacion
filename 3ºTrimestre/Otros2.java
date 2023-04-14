import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.module.FindException;
import java.util.Scanner;

public class Otros2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = "";

        try {
            System.out.println("introduce una palabra");
            p = sc.nextLine();

        } catch (FindException a) {
            System.out.println("Error");
        }
        sc.close();

        try {
            BufferedReader br = new BufferedReader(new FileReader("ejer11.txt"));
            int contador = 0;
            String l = "";

            while ((l != null)) {
                if (l.contains(p)) {
                    String[] palabras = l.split("\\s+");
                    contador++;
                }
                l = br.readLine();

            }

            br.close();
            System.out.println("la palabra " + p + " se repite " + contador + " veces");

        } catch (IOException ioe) {
            System.out.println("Se ha producido un error de lectura/escritura");
            System.err.println(ioe.getMessage());
        }

    }

    // funcion 2 contar cuantas palabras hay
    public static void NumPalabra(String palabra) {

        char cad = ' ';
        int contador = 1, pos;

        palabra = palabra.trim();// eliminar los posibles espacios en blanco al principio y al final
        if (palabra.isEmpty()) { // si la cadena está vacía
            contador = 0;
        } else {
            pos = palabra.indexOf(" "); // se busca el primer espacio en blanco
            while (pos != -1) { // mientras que se encuentre un espacio en blanco
                contador++; // se cuenta una palabra
                pos = palabra.indexOf(" ", pos + 1);// se busca el siguiente espacio en blanco a continuación del actual
            }
        }
        System.out.println("Hay " + contador + " palabras");
    }
}
