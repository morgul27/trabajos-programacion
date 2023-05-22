import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        // no esta terminado
        String db_ = "clinica";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            Scanner sc = new Scanner(System.in);

            System.out.println("Se va a modificar la tabla PACIENTES");

            ResultSet rs_ = st_
                    .executeQuery("select top 1 count(*) as registro from PACIENTES ORDER BY FECHA_NACIMIENTO DESC");

            // necesito cambiarlo para adaptarlo a tratamiento

            System.out.println("Introduce id del tratamiento ");

            rs_.moveToInsertRow();

            rs_.insertRow();
            rs_.moveToCurrentRow();

            System.out.println("Ha finalizado la insercion");

            connection_.close();
            st_.close();
            rs_.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
