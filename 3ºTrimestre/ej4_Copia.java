import java.io.*;

public class ej4_Copia {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("fichero1.txt");
            FileReader fr = new FileReader("fichero1.txt");
            FileWriter fw2 = new FileWriter("fichero2.txt");
            fw.write("Hol");
            fw.write(97);
            fw.flush();

            int valor = fr.read();
            while (valor != -1) {

                System.out.println((char) valor);
                fw2.write((char) valor);
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
