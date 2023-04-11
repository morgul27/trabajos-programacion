import java.io.*;
import java.io.PrintWriter;

public class Ejercicio2_PrinWriter {

    public static void main(String[] args) throws IOException {
        File fichero = new File("C:/Programacion_c/ej1.txt");
        FileWriter fic = new FileWriter(fichero);
        FileWriter fic = new FileWriter(fichero, true);

        String cadena = "1.Lista de caracteres";
        char[] c = cadena.toCharArray();
        for (int i = 0; i < c.length; i++) {
            fic.write(c[i]);
        }
        fic.write("\n");

        String nombre[] = { "Juan", "Maria", "Pedro", "Luisa" };
        for (int i = 0; i < nombre.length; i++) {
            fic.write(nombre[i]);
            fic.write("\n");
        }

        fic.close();

    }

    public static void escribeFichero(String salida) {
        FileWriter f_sal = null;
        PrintWriter p_sal = null;
        try {
            fileWriter f_sal = new FileWriter(salida);
            PrintWriter p_sal = new PrintWriter(f_sal);
            p_salprintln("Este texto es un ejemplo de escritura en el fichero de salida");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero");
        } finally {
            p_sal.close();
        }
    }
}
