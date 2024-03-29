import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ejextra_2Ficherotexto {
    public static void main(String[] args) {
        try {
            BufferedReader fr = new BufferedReader(new FileReader("FichTexto1.txt"));
            BufferedReader fr2 = new BufferedReader(new FileReader("fichero1.txt"));
            BufferedWriter fw = new BufferedWriter(new FileWriter("fichero2.txt"));

            String linea1 = "";
            String linea2 = "";

            while ((linea1 != null) || (linea2 != null)) {
                linea1 = fr.readLine();
                linea2 = fr2.readLine();
                if (linea1 != null) {
                    fw.write(linea1 + "\n");
                }
                if (linea2 != null) {
                    fw.write(linea2 + "\n");
                }
            }

            fr.close();
            fr2.close();
            fw.close();

        } catch (IOException ioe) {
            System.out.println("Se ha producido un error de lectura/escritura");
            System.err.println(ioe.getMessage());
        }
    }
}