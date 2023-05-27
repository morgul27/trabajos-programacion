

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

public class PACIENTES {

    // insertar PACIENTES
    public static void insertarPac() {
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
            Scanner ss = new Scanner(System.in);

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            System.out.println("Se va a modificar la tabla PACIENTES");

            rs_ = st_.executeQuery("select * from PACIENTES");

            // necesito insertar los id de todo

            System.out.println("Introduce los apellidos del paciente ");
            String apellidos = sc.nextLine();

            System.out.println("Introduce el nombre del paciente ");
            String nombre = sc.nextLine();

            System.out.println("Introduce el DNI del paciente ");
            String DNI = sc.nextLine();

            System.out.println("Introduce la fecha de nacimiento del paciente (yyyymmdd)");
            String fecharea = sc.nextLine();

            System.out.println("Introduce el genero del paciente ");
            String genero = sc.nextLine();

            System.out.println("Introduce la direccion del paciente ");
            String direccion = sc.nextLine();

            System.out.println("Introduce el Codigo Postal del paciente ");
            int CP = ss.nextInt();

            System.out.println("Introduce el CodProvincia del paciente ");
            int CodProvincia = ss.nextInt();

            System.out.println("Introduce el email del paciente");
            String Email = sc.nextLine();

            System.out.println("Introduce el numero del telefono 1 ");
            int telefono1 = ss.nextInt();

            System.out.println("Introduce el numero del telefono 2 ");
            int telefono2 = ss.nextInt();

            PreparedStatement ps = connection_.prepareStatement("INSERT INTO PACIENTES" +
                    "(Apellidos,Nombre,DNI,FechaNacimiento,genero,Direccion,CP,CodProvincia,email,Telefono1,Telefono2)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, apellidos);
            ps.setString(2, nombre);
            ps.setString(3, DNI);
            ps.setString(4, fecharea);
            ps.setString(5, genero);
            ps.setString(6, direccion);
            ps.setInt(7, CP);
            ps.setInt(8, CodProvincia);
            ps.setString(9, Email);
            ps.setInt(10, telefono1);
            ps.setInt(11, telefono2);
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

    //
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
                listaClientes.add(nombre + " | " + apellidos + " | " + fechana + " | " + genero + " | " + Direccion
                        + " | " + CP + " | " + CodProvincia);
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

    // borrar / Delete pacientes
    public void borrarPac() {
        String db_ = "clinica";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);
            Scanner sc = new Scanner(System.in);

            ArrayList<String> listaClientes = new ArrayList<String>();

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement();

            System.out.println("Dime la id del cliente que quieres borrar");
            int id = sc.nextInt();

            ResultSet rs_ = st_.executeQuery("select * from CLIENTES where id=" + id);

            while (rs_.next()) {
                String nombre = rs_.getString("NOMBRE");
                String apellidos = rs_.getString("APELLIDOS");
                String fechana = rs_.getString("FECHA_NACIMIENTO");
                String genero = rs_.getString("GENERO");
                listaClientes.add(nombre + " | " + apellidos + " | " + fechana + " | " + genero);
            }

            System.out.println("El cliente que quieres borrar es este? 1 para aceptar, 2 para denegar");
            for (String cliente : listaClientes) {
                System.out.println(cliente);
            }

            int x = sc.nextInt();

            if (x == 1) {
                rs_ = st_.executeQuery("delete from CLIENTES where id=" + id);
                System.out.println("Cliente borrado correctamente");
            }

            connection_.close();
            st_.close();
            sc.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // ver los servicios por el paciente
    public void serviciosPacientes() {
        String db_ = "ClinicaDental";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_;
        int idp = 1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);
            Scanner sc = new Scanner(System.in);
            ArrayList<String> listaClientes = new ArrayList<String>();

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement();

            System.out.println("Introduce el DNI del paciente");
            String dni = sc.nextLine();
            ResultSet id = st_.executeQuery(
                    "select id from PACIENTES where DNI = " + dni);

            if (id.next()) {
                idp = id.getInt("id");
            }

            ResultSet rs_ = st_.executeQuery(
                    "select * from PACIENTES p" +
                            "inner join TtosRealizados tr on c.IDPaciente = tr.IDPaciente" +
                            "inner join TRATAMIENTOS tra on tr.IDTratamiento = tra.IDTratamiento" +
                            "where p.id = " + idp);

            while (rs_.next()) {
                String apellidos = rs_.getString("Apellidos");
                String pnombre = rs_.getString("p.Nombre");
                String DNI = rs_.getString("DNI");
                String fechana = rs_.getString("FechaNacimiento");
                String Precio = rs_.getString("Precio");
                String tnombre = rs_.getString("tra.Nombre");
                String email = rs_.getString("email");
                String Telefono1 = rs_.getString("Telefono1");
                listaClientes.add(pnombre + " | " + apellidos + " | " + fechana + " | El precio de tratamiento es "
                        + Precio + " | El nombre del tratamiento es " + tnombre
                        + " | " + DNI + " | " + email + " | " + Telefono1 + " | ");
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

    // ver el historial de los paciente
    public void HistorialPacientes() {
        String db_ = "ClinicaDental";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;
        Statement st_;
        int idp = 1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);
            Scanner sc = new Scanner(System.in);
            ArrayList<String> listaClientes = new ArrayList<String>();

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement();

            System.out.println("Introduce el DNI del paciente");
            String dni = sc.nextLine();
            ResultSet id = st_.executeQuery(
                    "select id from PACIENTES where DNI = " + dni);

            if (id.next()) {
                idp = id.getInt("id");
            }

            ResultSet rs_ = st_.executeQuery(
                    "select * from PACIENTES p" +
                            "inner join TtosRealizados tr on c.IDPaciente = tr.IDPaciente" +
                            "inner join TRATAMIENTOS tra on tr.IDTratamiento = tra.IDTratamiento" +
                            "where p.id = " + idp);

            while (rs_.next()) {
                String apellidos = rs_.getString("Apellidos");
                String pnombre = rs_.getString("p.Nombre");
                String DNI = rs_.getString("DNI");
                String fechana = rs_.getString("FechaNacimiento");
                String Fecha = rs_.getString("Fecha");
                String Cobrado = rs_.getString("Cobrado");
                String tnombre = rs_.getString("tra.Nombre");
                String email = rs_.getString("email");
                String Telefono1 = rs_.getString("Telefono1");
                listaClientes.add(
                        pnombre + " | " + apellidos + " | " + fechana + " | fecha de cobro " + Fecha + " | " + Cobrado
                                + " | " + tnombre
                                + " | " + DNI + " | " + email + " | " + Telefono1 + " | ");
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
    // mirar g ii. no se que significa

}