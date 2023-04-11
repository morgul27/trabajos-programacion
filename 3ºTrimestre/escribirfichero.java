import java.io.*;

public class escribirfichero {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:/Programacion_c/ej1.txt");
        FileWriter fic = new FileWriter(fichero);
        // FileWriter fic = new FileWriter(fichero, true);

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
}
