package clinicabd.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class COBROS {

    // COBROS insert
    public static void INSERT() {
        String db_ = "ClinicaDental";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;

        Statement st_ = null;
        ResultSet rs_ = null;
        Connection connection_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);

            Scanner sc = new Scanner(System.in);

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            System.out.println("Se va a modificar la tabla TRATAMIENTOS");

            rs_ = st_.executeQuery("select * from TRATAMIENTOS");

            // necesito cambiarlo para adaptarlo a cobros, probarlo

            // preguntar todo antes de insertarlo
            System.out.println("Introduce la Fecha de liquidacion (yyyymmdd)");
            String fecha = sc.nextLine();
            System.out.println("Introduce el DNI IDPaciente");
            String IDDNI = sc.nextLine();
            System.out.println("Introduce la forma de Cobro");
            String IDFCobro = sc.nextLine();
            System.out.println("Introduce lo Cobrado");
            Double Cobrado = sc.nextDouble();
            System.out.println("Introduce imputado ");
            Double imputado = sc.nextDouble();

            PreparedStatement ps = connection_.prepareStatement("INSERT INTO PROFESIONALES" +
                    "(Fecha,IDPaciente,IDFCobro,Cobrado,Imputado))"
                    + " VALUES (?, (select id from PACIENTES where DNI=" + IDDNI
                    + "),(select id from PACIENTES where IDFCobro=" + IDFCobro + "),?, ?)");
            ps.setString(1, fecha);
            ps.setDouble(2, Cobrado);
            ps.setDouble(3, imputado);
            ps.executeUpdate();
            ps.close();

            System.out.println("Ha finalizado la insercion");

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
