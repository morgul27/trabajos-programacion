import java.io.*;

public class escribirfichero {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:/Programacion_c/ej1.txt");
        FileReader fic = new FileReader(fichero);
        int i;

        while ((i = fic.read()) != -1)
            System.out.println(i);
        fic.close();

    }
}
