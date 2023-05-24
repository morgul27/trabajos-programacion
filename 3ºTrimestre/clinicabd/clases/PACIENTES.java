package clinicabd.clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PACIENTES {
    protected int Historia;
    protected String Apellidos;
    protected String Nombre;
    protected String DNI;
    protected String FechaNacimiento; // mirar si poner date o String
    protected String Genero;
    protected String Direccion;
    protected int CP;
    protected int CodProvincia;
    protected String email;
    protected int Telefono1;
    protected int Telefono2;

    public PACIENTES() {
    }

    public PACIENTES(int historia, String apellidos, String nombre, String dNI, String fechaNacimiento, String genero,
            String direccion, int cP, int codProvincia, String email, int telefono1, int telefono2) {
        Historia = historia;
        Apellidos = apellidos;
        Nombre = nombre;
        DNI = dNI;
        FechaNacimiento = fechaNacimiento;
        Genero = genero;
        Direccion = direccion;
        CP = cP;
        CodProvincia = codProvincia;
        this.email = email;
        Telefono1 = telefono1;
        Telefono2 = telefono2;
    }

    public int getHistoria() {
        return Historia;
    }

    public void setHistoria(int historia) {
        Historia = historia;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int cP) {
        CP = cP;
    }

    public int getCodProvincia() {
        return CodProvincia;
    }

    public void setCodProvincia(int codProvincia) {
        CodProvincia = codProvincia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono1() {
        return Telefono1;
    }

    public void setTelefono1(int telefono1) {
        Telefono1 = telefono1;
    }

    public int getTelefono2() {
        return Telefono2;
    }

    public void setTelefono2(int telefono2) {
        Telefono2 = telefono2;
    }

    public static void INSERT() {
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

            System.out.println("Se va a modificar la tabla PACIENTES");

            rs_ = st_.executeQuery("select * from PACIENTES");

            System.out.println("Cuantos pacientes quieres insertar");
            int contador = sc.nextInt();

            // necesito insertar los id de todo
            for (int i = 0; i < contador; i++) {

                System.out.println("Introduce el codigo numerico del historial del paciente " + (contador + 1));
                int Historia = sc.nextInt();
                System.out.println("Introduce los apellidos del paciente " + (contador + 1));
                String apellidos = sc.nextLine();
                System.out.println("Introduce el nombre del paciente " + (contador + 1));
                String nombre = sc.nextLine();
                System.out.println("Introduce el DNI del paciente " + (contador + 1));
                String DNI = sc.nextLine();
                System.out.println("Introduce la fecha de nacimiento del paciente (yyyymmdd) "
                        + (contador + 1));
                String fecharea = sc.nextLine();
                System.out.println("Introduce el genero del paciente " + (contador + 1));
                String genero = sc.nextLine();
                System.out.println("Introduce la direccion del paciente " + (contador + 1));
                String direccion = sc.nextLine();
                System.out.println("Introduce el Codigo Postal del paciente " + (contador + 1));
                int CP = sc.nextInt();
                System.out.println("Introduce el CodProvincia del paciente " + (contador + 1));
                int CodProvincia = sc.nextInt();
                System.out.println("Introduce el email del paciente " + (contador + 1));
                String email = sc.nextLine();
                System.out.println("Introduce el primer numero del telefono del paciente " + (contador + 1));
                int telefono1 = sc.nextInt();
                System.out.println("Introduce el segundo numero del telefono del paciente " + (contador + 1));
                int telefono2 = sc.nextInt();

                rs_.moveToInsertRow();
                rs_.updateInt("Historia", Historia);
                rs_.updateString("Apellidos", apellidos);
                rs_.updateString("Nombre", nombre);
                rs_.updateString("DNI", DNI);
                rs_.updateString("Fecha", fecharea);
                rs_.updateString("Genero", genero);
                rs_.updateString("Direccion", direccion);
                rs_.updateInt("CP", CP);
                rs_.updateInt("CodProvincia", CodProvincia);
                rs_.updateString("email", email);
                rs_.updateInt("Telefono1", telefono1);
                rs_.updateInt("Telefono2", telefono2);
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

    //
    // funcion mostrar pacientes
    public void mostrarPac() {
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
                String nombre = rs_.getString("NOMBRE");
                String apellidos = rs_.getString("APELLIDOS");
                String fechana = rs_.getString("FECHA_NACIMIENTO");
                String genero = rs_.getString("GENERO");
                listaClientes.add(nombre + " | " + apellidos + " | " + fechana + " | " + genero);
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
}