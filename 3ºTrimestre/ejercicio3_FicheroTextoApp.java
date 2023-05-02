import java.io.*;
import java.io.PrintWriter;

public class ejercicio3_FicheroTextoApp {

    public static void main(String[] args) throws IOException {
        try {
            // Abrir stream,crea el fichero si no existe
            FileWriter fw = new FileWriter("fichero1.txt");
            // Escribir en el fichero un String
            fw.write("Hol");
            // Escribir en el fichero un carácter
            fw.write(97);
            fw.close();

            // Abrir el stream, el fichero debe existir
            FileReader fr = new FileReader("fichero1.txt");
            // Leer el fichero y mostrarlo por pantalla
            int valor = fr.read();
            while (valor != -1) {
                System.out.println((char) valor);
                valor = fr.read();
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }

    }

}
