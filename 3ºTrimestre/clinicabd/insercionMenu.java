package clinicabd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insercionMenu {

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

    // inser PROFESIONALES
    public static void insetarProfesional() {
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

    // COBROS insert
    public static void insertCobros() {
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
            sc.close();
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
            Scanner ss = new Scanner(System.in);

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            System.out.println("Se va a modificar la tabla SERVICIOS");

            rs_ = st_.executeQuery("select * from TtosRealizados");

            System.out.println("Cuantos tratamientos quieres insertar");
            int contador = sc.nextInt();

            // necesito insertar los id de todo
            for (int i = 0; i < contador; i++) {
                System.out.println("Introduce el IDServicio " + (contador + 1));
                int IDServicio = ss.nextInt();
                System.out.println("Introduce la fecha de realizacion del servicio (yyyy-mm-dd) numero "
                        + (contador + 1));
                String fecha = sc.nextLine();
                System.out.println("Introduce id del cliente " + (contador + 1));
                int iDPaciente = ss.nextInt();
                System.out.println("Introduce id del profesional " + (contador + 1));
                int idprofesional = ss.nextInt();
                System.out.println("Introduce precio del servicio " + (contador + 1));
                Double precio = ss.nextDouble();
                System.out.println("Introduce lo cobrado " + (contador + 1));
                Double cobrado = ss.nextDouble();
                System.out.println("Introduce id de la liquidacion " + (contador + 1));
                int idliquidacion = ss.nextInt();
                System.out.println("Introduce el ID del Tratamiento " + (contador + 1));
                int IDTratamiento = ss.nextInt();

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
            ss.close();
            sc.close();
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

    // insertar LIQUIDACIONES
    public static void insertarliquidacion() {
        String db_ = "Clinica";
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

            System.out.println("Que fecha es con el formato yyyymmdd");
            String fecha = sc.nextLine();
            System.out.println("El DNI del profesional");
            String dni = sc.nextLine();
            System.out.println("La comision que le pertenece");
            Double comision = sc.nextDouble();

            PreparedStatement ps = connection_.prepareStatement("INSERT INTO LIQUIDACION" +
                    "(?,(select IDProfesional from IDProfesional where NIF=" + dni + " ),?)");
            ps.setString(1, fecha);
            ps.setDouble(2, comision);
            ps.executeUpdate();
            ps.close();

            System.out.println("Ha finalizado la insercion");
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