import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class act2ClinicaBD {
    public static void main(String[] args) {
        String db_ = "clinica";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);

            System.out.println("Conexion a base de datos");
            st_ = connection_.createStatement();

            System.out.println("Creacion de la tabla CLIENTES...");
            st_.executeUpdate(
                    "CREATE TABLE CLIENTES (" +
                            "ID_CLIENTE INT NOT NULL AUTO_INCREMENT," +
                            "NOMBRE VARCHAR (250)," +
                            "APELLIDOS VARCHAR(250)," +
                            "FECHA_NACIMIENTO DATE," +
                            "PRIMARY KEY (ID_CLIENTE)" +
                            ")");

            System.out.println("Se han creado todas las tablas correctamente!!");

            //
            // Empieza la escritura
            BufferedReader br = new BufferedReader(new FileReader("fichero1.txt"));

            String linea1 = br.readLine();
            while ((linea1 != null)) {

                String string = linea1;
                String[] parts = string.split(",");
                st_.executeUpdate(
                        "Insert into CLIENTES(NOMBRE, APELLIDOS, FECHA_NACIMIENTO)" +
                                "values (" + parts[0] + "," + parts[1] + ",'" + parts[2] + "')");
                linea1 = br.readLine();
            }

            //
            connection_.close();
            st_.close();
            br.close();
            // Fin de escritura
            //

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // leer fichero y guardando los nombre o el apellido en un ArrayList
    public static void lectura(String texto, Object array) {
        String linea1 = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(texto));

            while ((linea1 != null)) {
                linea1 = br.readLine();
                ((ArrayList<String>) array).add(linea1);
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println("Se ha producido un error de lectura/escritura");
            System.err.println(ioe.getMessage());
        }

    }
}
