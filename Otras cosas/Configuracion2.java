import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuracion2 {
    public static void main(String[] argv) {
        Properties configuracion = new Properties();

        try {

            configuracion.load(new BufferedReader(new FileReader("ejemplo.cfg")));
            System.out.println("Usuario: " + configuracion.getProperty("user") + "\n" + "Contraseña: "
                    + configuracion.getProperty("password") + "\n" +
                    "Servidor: " + configuracion.getProperty("server") + "\n" +
                    "Puerto: " + configuracion.getProperty("port"));

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    }
}
