package clinicabd.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LIQUIDACIONES {
    protected String Fecha;
    protected int IDProfesional;
    protected Double Comision;

    public Double getComision() {
        return Comision;
    }

    public void setComision(Double comision) {
        Comision = comision;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public int getIDProfesional() {
        return IDProfesional;
    }

    public void setIDProfesional(int iDProfesional) {
        IDProfesional = iDProfesional;
    }

    public LIQUIDACIONES() {
    }

    public LIQUIDACIONES(String fecha, int iDProfesional) {
        Fecha = fecha;
        IDProfesional = iDProfesional;
    }

    // liquidaciones insert
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

            System.out.println("Cuantos TRATAMIENTOS vas a querer insertar");
            int contador = sc.nextInt();

            // necesito cambiarlo para adaptarlo a liquidaciones, probarlo
            for (int i = 0; i < contador; i++) {
                // preguntar todo antes de insertarlo
                System.out.println("Introduce la Fecha de liquidacion (yyyymmdd) ");
                String fecha = sc.nextLine();
                System.out.println("Introduce IDProfesional");
                String IDProfesional = sc.nextLine();
                System.out.println("Introduce Comision ");
                Double Comision = sc.nextDouble();

                // insertar todo
                connection_.setAutoCommit(false); // para que no pete fuerte si no se completa

                rs_.moveToInsertRow();
                rs_.updateString("Fecha", fecha);
                rs_.updateString("IDProfesional", IDProfesional);
                rs_.updateDouble("Comision", Comision);
                rs_.insertRow();
                rs_.moveToCurrentRow();

                connection_.commit();
                connection_.setAutoCommit(true);

            }

            System.out.println("Ha finalizado la insercion");

            connection_.close();
            st_.close();
            rs_.close();
            // Fin de escritura
            //

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection_.rollback();
            } catch (SQLException e1) {
                System.err.println("Error");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
