package clinicabd.clases;

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

public class PROFESIONALES {
    public static void insetarprofesional() {
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
            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            Scanner sc = new Scanner(System.in);
            System.out.println("¿Cual es el NIF?");
            String nif = sc.next();
            System.out.println("¿Cual es su apellido?");
            String apellido = sc.next();
            System.out.println("¿Cual es su nombre?");
            String nombre = sc.next();
            System.out.println("¿Cual es su direccion?");
            String direccion = sc.next();
            System.out.println("¿Cual es su CP?");
            int CP = sc.nextInt();
            System.out.println("¿Cual es su Codigo de provincia?");
            int codpro = sc.nextInt();
            System.out.println("¿Cual es su email?");
            String email = sc.next();
            System.out.println("¿Cual es su telefono1?");
            int tel1 = sc.nextInt();
            System.out.println("¿Cual es su telefono2?");
            int tel2 = sc.nextInt();
            System.out.println("¿Cual es su comision?");
            double com = sc.nextDouble();

            PreparedStatement ps = connection_.prepareStatement("INSERT INTO PROFESIONALES" +
                    "(NIF,Apellidos,Nombre,Direccion,CP,CodProvincia,email,Telefono1,Telefono2,Comision)"
                    + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, nif);
            ps.setString(2, apellido);
            ps.setString(3, nombre);
            ps.setString(4, direccion);
            ps.setInt(5, CP);
            ps.setInt(6, codpro);
            ps.setString(7, email);
            ps.setInt(8, tel1);
            ps.setInt(9, tel2);
            ps.setDouble(10, com);
            ps.executeUpdate();
            ps.close();

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
