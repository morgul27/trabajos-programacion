import java.io.*;
import java.io.PrintWriter;

public class ej4parte2_Copia {
    public static void main(String[] args) {
        try {
            FileInputStream fw = new FileInputStream("fichero1.txt");
            FileOutputStream fr = new FileOutputStream("fichero1.txt");
            FileInputStream fw2 = new FileInputStream("fichero2.txt");

            fw.write("Hol");
            fw.write(97);
            fw.flush();

            int valor = fr.read();
            while ((valor = fr.read()) != -1) {

                System.out.println(valor);
                fw2.write(valor);
                valor = fr.read();
            }
            // Cerrar el stream
            fw.close();
            fr.close();
            fw2.close();

        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }
    }
}
