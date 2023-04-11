import java.io.*;

public class ej5parte2_LeerFichTextoBuf {
    public static void main(String[] args) {
        try {
            BufferedWriter fichero = new BufferedWriter(new FileWriter("FichTexto1.txt"));
            for (int i = 1; i < 11; i++) {
                fichero.write("Filanumero:" + i);// escribeunalínea
                fichero.newLine();// escribeunsaltodelínea
            }
            fichero.close();
        } catch (FileNotFoundException fn) {
            System.out.println("Noseencuentraelfichero");
        } catch (IOException io) {
            System.out.println("ErrordeE/S");
        }
    }
}