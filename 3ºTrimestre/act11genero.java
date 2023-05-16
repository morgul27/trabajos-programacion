import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class act11genero {

    public static void main(String[] args) {
        String db_ = "clinica";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_ = null;
        ResultSet rs_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);

            ArrayList<String> listaClientes = new ArrayList<String>();

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Se va a modificar la tabla CLIENTES...");

            rs_ = st_.executeQuery("select * from CLIENTES LIMIT 5"); // El LIMIT 5 es como el top 5 de bbdd, es decir,
                                                                      // coge los 5 primeros clientes

            while (rs_.next()) {
                System.out.println("Introduce el genero para el/la cliente/a" + rs_.getString("NOMBRE") + " "
                        + rs_.getString("APELLIDOS"));

                if ("M".equals(rs_.getString("GENERO"))) {
                    System.out.println("Se ha detectado un cliente masculino");
                    Scanner sc = new Scanner(System.in);

                    System.out.println("Introduce nombre de la clienta:");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce apellidos de la clienta:");
                    String apellidos = sc.nextLine();
                    System.out.println("Introduce la fecha de nacimiento de la clienta:");
                    java.sql.Date fecha_nacimiento = java.sql.Date.valueOf(sc.nextLine());
                    System.out.println("Introduce genero de la clienta:");
                    String genero = sc.nextLine();

                    rs_.moveToInsertRow();
                    rs_.updateString("nombre", nombre);
                    rs_.updateString("apellidos", apellidos);
                    rs_.updateDate("FECHA_NACIMIENTO", fecha_nacimiento);
                    rs_.updateString("genero", genero);

                    rs_.insertRow();
                    rs_.moveToCurrentRow();
                }

            }
            System.out.println("ha finalizado la actualizacion de generos");

            System.out.println("Fin");

            connection_.close();
            st_.close();
            rs_.close();
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

}
