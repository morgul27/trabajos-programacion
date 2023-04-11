import java.io.*;

public class ejextra_2Ficherotexto {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("Lista de caracteres.txt");
            FileWriter fw = new FileWriter("fichero1.txt");
            FileWriter fw2 = new FileWriter("fichero2.txt");

            int valor = fr.read();
            while (valor != -1) {

                System.out.println((char) valor);
                fw.write((char) valor);
                fw.flush();
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
