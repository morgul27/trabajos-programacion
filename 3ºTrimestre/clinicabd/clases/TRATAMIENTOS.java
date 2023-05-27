package clinicabd.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TRATAMIENTOS {
    //
    // funcion para meter los tratamientos con csv
    public static void tratamientomano() {
        String db_ = "ClinicaDental";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Statement st_ = null;
        Connection connection_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);

            System.out.println("Conexion a base de datos");
            st_ = connection_.createStatement();

            //
            // Empieza la escritura
            BufferedReader br = new BufferedReader(new FileReader("Tratamientos.csv"));

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                String CodTto = parts[0];
                String nombre = parts[1];
                int CodFamilia = Integer.parseInt(parts[2]);
                Double Precio = Double.parseDouble(parts[3]);

                PreparedStatement ps = connection_.prepareStatement("INSERT INTO FAMILIAS" +
                        " (CodTto, Nombre, CodFamilia, Precio) VALUES (?, ?, ?, ?)");
                ps.setString(1, CodTto);
                ps.setString(2, nombre);
                ps.setInt(3, CodFamilia);
                ps.setDouble(4, Precio);
                ps.executeUpdate();
                ps.close();
            }

            System.out.println("Insertado los 3000 pacientes en la base de datos");
            //
            connection_.close();
            st_.close();
            br.close();
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
