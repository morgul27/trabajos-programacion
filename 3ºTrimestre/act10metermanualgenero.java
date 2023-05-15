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

public class act10metermanualgenero {
    public static void main(String[] args) {
        String db_ = "clinica";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_ = null;
        Statement st_2 = null;
        ResultSet rs_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);

            ArrayList<String> listaClientes = new ArrayList<String>();

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement();
            System.out.println("Se va a modificar la tabla CLIENTES...");
            st_.executeUpdate("ALTER TABLE CLIENTES ADD GENERO VARCHAR(1)");

            rs_ = st_.executeQuery("select * from CLIENTES");

            st_2 = connection_.createStatement();

            while (rs_.next()) {
                System.out.println("Introduce el genero para el/la cliente/a" + rs_.getString("NOMBRE") + " "
                        + rs_.getString("APELLIDOS"));

                Scanner sc = new Scanner(System.in);

                String genero = sc.nextLine();

                st_2.executeUpdate(
                        "UPDATE CLIENTES SET GENERO='" + genero + "'where ID_CLIENTE=" + rs_.getInt("ID_CLIENTE"));
            }

            System.out.println("Fin");

            st_2.close();
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
