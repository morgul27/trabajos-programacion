import java.io.*;

public class ej7File {
    public static void main(String[] args) {

        File fichero = new File("ej7.txt");
        if (fichero.exists()) {
            System.out.println("Nombre del archivo " + fichero.getName());
            System.out.println("Camino " + fichero.getPath());
            System.out.println("Camino absoluto " + fichero.getAbsolutePath());
            System.out.println("Se puede leer " + fichero.canRead());
            System.out.println("Se puede escribir " + fichero.canWrite());
            System.out.println("Tamaño " + fichero.length());
        }
    }
}
