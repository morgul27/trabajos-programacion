package clinicabd.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                PACIENTES pa = new PACIENTES();

                System.out.println("Introduce el codigo del historial del paciente " + (contador + 1));
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

                pa.setHistoria(Historia);
                pa.setApellidos(apellidos);
                pa.setNombre(nombre);
                pa.setDNI(DNI);
                pa.setFechaNacimiento(fecharea);
                pa.setGenero(genero);
                pa.setDireccion(direccion);
                pa.setCP(CP);
                pa.setCodProvincia(CodProvincia);
                pa.setEmail(email);
                pa.setTelefono1(telefono1);
                pa.setTelefono2(telefono2);

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
                rs_.updateInt("telefono1", telefono1);
                rs_.updateInt("telefono2", telefono2);
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

    // funcion toString
    @Override
    public String toString() {
        return "PACIENTES - Historia=" + Historia + ", Apellidos=" + Apellidos + ", Nombre=" + Nombre + ", DNI=" + DNI
                + ", FechaNacimiento=" + FechaNacimiento + ", Genero=" + Genero + ", Direccion=" + Direccion + ", CP="
                + CP + ", CodProvincia=" + CodProvincia + ", email=" + email + ", Telefono1=" + Telefono1
                + ", Telefono2=" + Telefono2;
    }

}
