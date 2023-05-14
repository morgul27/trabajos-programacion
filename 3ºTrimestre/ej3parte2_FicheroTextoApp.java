import java.io.*;

public class ej3parte2_FicheroTextoApp {

    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("fichero2.txt");
            FileReader fr = new FileReader("fichero2.txt");
            fw.write("Hol");
            fw.write(97);
            fw.flush(); // esta funcion sirve para que pueda leer y escribir a la vez
            int valor = fr.read();
            while (valor != -1) {
                System.out.println((char) valor);
                valor = fr.read();
            }
            // Cerrar el stream
            fw.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }

    }

}
