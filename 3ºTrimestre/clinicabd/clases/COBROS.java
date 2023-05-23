package clinicabd.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class COBROS {

    protected String Fecha;
    protected int IDPaciente;
    protected int IDFCobro;
    protected Double Cobrado;
    protected Double Imputado;

    public COBROS(String fecha, int iDPaciente, int iDFCobro, Double cobrado, Double imputado) {
        Fecha = fecha;
        IDPaciente = iDPaciente;
        IDFCobro = iDFCobro;
        Cobrado = cobrado;
        Imputado = imputado;
    }

    public COBROS() {
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public int getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(int iDPaciente) {
        IDPaciente = iDPaciente;
    }

    public int getIDFCobro() {
        return IDFCobro;
    }

    public void setIDFCobro(int iDFCobro) {
        IDFCobro = iDFCobro;
    }

    public Double getCobrado() {
        return Cobrado;
    }

    public void setCobrado(Double cobrado) {
        Cobrado = cobrado;
    }

    public Double getImputado() {
        return Imputado;
    }

    public void setImputado(Double imputado) {
        Imputado = imputado;
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

            // necesito cambiarlo para adaptarlo a cobros, probarlo
            for (int i = 0; i < contador; i++) {
                // preguntar todo antes de insertarlo
                System.out.println("Introduce la Fecha de liquidacion (yyyymmdd) ");
                String fecha = sc.nextLine();
                System.out.println("Introduce el IDPaciente");
                int IDPaciente = sc.nextInt();
                System.out.println("Introduce IDFCobro");
                Double IDFCobro = sc.nextDouble();
                System.out.println("Introduce Cobrado");
                Double Cobrado = sc.nextDouble();
                System.out.println("Introduce imputado ");
                Double imputado = sc.nextDouble();

                // insertar todo
                connection_.setAutoCommit(false); // para que no pete fuerte si no se completa

                rs_.moveToInsertRow();
                rs_.updateString("Fecha", fecha);
                rs_.updateInt("IDPaciente", IDPaciente);
                rs_.updateDouble("IDFCobro", IDFCobro);
                rs_.updateDouble("Cobrado", Cobrado);
                rs_.updateDouble("Imputado", imputado);
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
