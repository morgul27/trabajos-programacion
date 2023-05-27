package clinicabd.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TtosRealizados { // SERVICIOS

    // funcion cuando quiera insertar servicios
    public static void insertar() {
        String db_ = "ClinicaDental";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_ = null;
        ResultSet rs_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);

            Scanner sc = new Scanner(System.in);

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            System.out.println("Se va a modificar la tabla SERVICIOS");

            rs_ = st_.executeQuery("select * from TtosRealizados");

            System.out.println("Cuantos tratamientos quieres insertar");
            int contador = sc.nextInt();

            // necesito insertar los id de todo
            for (int i = 0; i < contador; i++) {
                System.out.println("Introduce el IDServicio " + (contador + 1));
                int IDServicio = sc.nextInt();
                System.out.println("Introduce la fecha de realizacion del servicio (yyyy-mm-dd) numero "
                        + (contador + 1));
                String fecha = sc.nextLine();
                System.out.println("Introduce id del cliente " + (contador + 1));
                int iDPaciente = sc.nextInt();
                System.out.println("Introduce id del profesional " + (contador + 1));
                int idprofesional = sc.nextInt();
                System.out.println("Introduce precio del servicio " + (contador + 1));
                Double precio = sc.nextDouble();
                System.out.println("Introduce lo cobrado " + (contador + 1));
                Double cobrado = sc.nextDouble();
                System.out.println("Introduce id de la liquidacion " + (contador + 1));
                int idliquidacion = sc.nextInt();
                System.out.println("Introduce el ID del Tratamiento " + (contador + 1));
                int IDTratamiento = sc.nextInt();

                rs_.moveToInsertRow();
                rs_.updateInt("IDServicio", IDServicio);
                rs_.updateString("Fecha", fecha);
                rs_.updateInt("IDPaciente", iDPaciente);
                rs_.updateInt("IDProfesional", idprofesional);
                rs_.updateInt("IDTratamiento", IDTratamiento);
                rs_.updateDouble("Precio", precio);
                rs_.updateDouble("Cobro", cobrado);
                rs_.updateInt("IDLiquidacion", idliquidacion);

                rs_.insertRow();
                rs_.moveToCurrentRow();
            }
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

        // si necesito algo en date
        // java.sql.Date fecharea = java.sql.Date.valueOf(sc.nextLine());

    }

}
