import java.io.*;
import java.util.Properties;

public class Configuracion {
    public static void main(String[] argv) {
        Properties configuracion = new Properties();
        configuracion.setProperty("user", "miUsuario");
        configuracion.setProperty("password", "miContrasena");
        configuracion.setProperty("server", "elServidor");
        configuracion.setProperty("port", "elPuerto");

        try {

            configuracion.store(new FileOutputStream("ejemplo.cfg"), "ejemplo.cfg");
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