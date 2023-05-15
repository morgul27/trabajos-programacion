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

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class act9bdfecha {
    public static void main(String[] args) {
        String db_ = "clinica";
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

            ResultSet rs_ = st_.executeQuery("select * from CLIENTES");
            while (rs_.next()) {
                Date fechaNacimiento = rs_.getDate("FECHA_NACIMIENTO");
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate fecha = LocalDate.parse(fechaNacimiento.toString(), fmt);
                LocalDate ahora = LocalDate.now();

                Period periodo = Period.between(fecha, ahora);

                if (periodo.getYears() < 30) {
                    String nombre = rs_.getString("NOMBRE");
                    String apellidos = rs_.getString("APELLIDOS");
                    String fechana = rs_.getString("FECHA_NACIMIENTO");
                    String genero = rs_.getString("GENERO");
                    listaClientes.add(nombre + " " + apellidos + " " + fechana + " " + genero);
                }

            }
            System.out.println("La lista de clientes menores de 20 años es: ");
            for (String cliente : listaClientes) {
                System.out.println(cliente);
            }

            System.out.println("Se han creado todas las tablas correctamente!!");

            //
            // Empieza la escritura
            BufferedReader br = new BufferedReader(new FileReader("fichero1.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String nombre = parts[0];
                String apellidos = parts[1];
                String fechaNacimiento = parts[2];
                String genero = parts[3];

                PreparedStatement ps = connection_.prepareStatement("INSERT INTO CLIENTES" +
                        " (NOMBRE, APELLIDOS, FECHA_NACIMIENTO) VALUES (?, ?, ?, ?)");
                ps.setString(1, nombre);
                ps.setString(2, apellidos);
                ps.setString(3, fechaNacimiento);
                ps.setString(3, genero);
                ps.executeUpdate();
                ps.close();
            }

            System.out.println("Fin");
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
