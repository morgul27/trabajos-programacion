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
                System.out.println("Introduce la fecha de realizacion del servicio (yyyy-mm-dd) numero "
                        + (contador + 1));
                java.sql.Date fecharea = java.sql.Date.valueOf(sc.nextLine());
                System.out.println("Introduce el codigo del historial " + (contador + 1));
                String precio = sc.nextLine();
                System.out.println("Introduce cobro importado " + (contador + 1));
                String cobro = sc.nextLine();
                System.out.println("Introduce id del cliente " + (contador + 1));
                System.out.println("Introduce id del profesional " + (contador + 1));
                System.out.println("Introduce id del tratamiento " + (contador + 1));
                System.out.println("Introduce id de la liquidacion " + (contador + 1));

                rs_.moveToInsertRow();
                rs_.updateDate("Fecha", fecharea);
                rs_.updateString("Precio", precio);
                rs_.updateString("Cobro", cobro);

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
    public String toString() {
        return this.Historia + "," + this.Apellidos + "," + this.Nombre + "," + this.DNI + "," + this.FechaNacimiento
                + "," + this.Genero + "," + this.Direccion + "," + this.CP + "," + this.CodProvincia + "," + this.email
                + "," + this.Telefono1 + "," + this.Telefono2;
    }

}
