package clinicabd.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TRATAMIENTOS {
    protected String CodTto;
    protected String Nombre;
    protected int CodFamilia;
    protected double Precio;

    public TRATAMIENTOS() {
    }

    public TRATAMIENTOS(String codTto, String nombre, int codFamilia, double precio) {
        CodTto = codTto;
        Nombre = nombre;
        CodFamilia = codFamilia;
        Precio = precio;
    }

    public String getCodTto() {
        return CodTto;
    }

    public void setCodTto(String codTto) {
        CodTto = codTto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCodFamilia() {
        return CodFamilia;
    }

    public void setCodFamilia(int codFamilia) {
        CodFamilia = codFamilia;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

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

            // necesito cambiarlo para adaptarlo a tratamiento, pruebalo ------LEEEEE------
            for (int i = 0; i < contador; i++) {
                System.out.println("Introduce la CodTto");
                String CodTto = sc.nextLine();
                System.out.println("Introduce Nombre");
                String Nombre = sc.nextLine();
                System.out.println("Introduce CodFamilia ");
                String CodFamilia = sc.nextLine();
                System.out.println("Introduce Precio ");
                Double Precio = sc.nextDouble();

                rs_.moveToInsertRow();
                rs_.updateString("CodTto", CodTto);
                rs_.updateString("Nombre", Nombre);
                rs_.updateString("CodFamilia", CodFamilia);
                rs_.updateDouble("Precio", Precio);
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

    }

}
