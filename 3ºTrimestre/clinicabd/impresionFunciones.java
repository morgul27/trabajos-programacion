package clinicabd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class impresionFunciones {

    // funcion mostrar pacientes
    public static void mostrarPac() {
        String db_ = "ClinicaDental";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);

            ArrayList<String> listaClientes = new ArrayList<String>();

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement();

            ResultSet rs_ = st_.executeQuery(
                    "select Apellidos,Nombre,DNI,FechaNacimiento,Genero,Direccion,CP,CodProvincia,email,Telefono1 from PACIENTES");

            while (rs_.next()) {
                String apellidos = rs_.getString("Apellidos");
                String nombre = rs_.getString("Nombre");
                String DNI = rs_.getString("DNI");
                String fechana = rs_.getString("FechaNacimiento");
                String genero = rs_.getString("Genero");
                String Direccion = rs_.getString("Direccion");
                String CP = rs_.getString("CP");
                String CodProvincia = rs_.getString("CodProvincia");
                String email = rs_.getString("email");
                String Telefono1 = rs_.getString("Telefono1");
                listaClientes.add(
                        nombre + " | " + apellidos + " | " + DNI + " | " + fechana + " | " + genero + " | " + Direccion
                                + " | " + CP + " | " + CodProvincia + " | " + email + " | " + Telefono1);
            }

            System.out.println("La lista de clientes es: ");
            for (String cliente : listaClientes) {
                System.out.println(cliente);
            }

            connection_.close();
            st_.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // mostrar la liquidaciones
    public static void mostrarliquid() {
        String db_ = "ClinicaDental";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);

            ArrayList<String> listaliqui = new ArrayList<String>();

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement();

            ResultSet rs_ = st_.executeQuery(
                    "select IDLiquidacion,Fecha,IDProfesional,Comision from LIQUIDACIONES");

            while (rs_.next()) {
                int IDLiq = rs_.getInt("IDLiquidacion");
                String Fec = rs_.getString("Fecha");
                int IDProf = rs_.getInt("IDProfesional");
                int Comi = rs_.getInt("Comision");
                listaliqui.add(IDLiq + " | " + Fec + " | " + IDProf + " | " + Comi);
            }

            System.out.println("La lista de liquidaciones es: ");
            for (String liquidaciones : listaliqui) {
                System.out.println(liquidaciones);
            }

            connection_.close();
            st_.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
