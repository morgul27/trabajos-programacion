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

public class PROFESIONALES {
    protected String NIF;
    protected String Apellidos;
    protected String Nombre;
    protected String DNI; // esto al final no se pone
    protected String Direccion;
    protected int CP;
    protected int CodProvincia;
    protected String email;
    protected int Telefono1;
    protected int Telefono2;
    protected double Comision;

    public PROFESIONALES() {
    }

    public PROFESIONALES(String nIF, String apellidos, String nombre, String dNI, String direccion, int cP,
            int codProvincia, String email, int telefono1, int telefono2, double comision) {
        NIF = nIF;
        Apellidos = apellidos;
        Nombre = nombre;
        DNI = dNI;
        Direccion = direccion;
        CP = cP;
        CodProvincia = codProvincia;
        this.email = email;
        Telefono1 = telefono1;
        Telefono2 = telefono2;
        Comision = comision;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String nIF) {
        NIF = nIF;
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

    public double getComision() {
        return Comision;
    }

    public void setComision(double comision) {
        Comision = comision;
    }

    // borrar / Delete PROFESIONALES
    public void borrarPro() {
        String db_ = "clinica";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_ = null;
        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);
            Scanner sc = new Scanner(System.in);

            ArrayList<String> listaClientes = new ArrayList<String>();

            System.out.println("Conexion a base de datos" + db_ + " correcta");
            st_ = connection_.createStatement();

            System.out.println("Dime la id del profesional que quieres borrar");
            int id = sc.nextInt();

            ResultSet rs_ = st_.executeQuery("select * from PROFESIONALES where id=" + id);

            while (rs_.next()) {
                String nombre = rs_.getString("NOMBRE");
                String apellidos = rs_.getString("APELLIDOS");
                String Direccion = rs_.getString("Direccion");
                String NIF = rs_.getString("NIF");
                listaClientes.add(nombre + " | " + apellidos + " | " + Direccion + " | " + NIF);
            }

            System.out.println("El profesional que quieres borrar es este? 1 para aceptar, 2 para denegar");
            for (String cliente : listaClientes) {
                System.out.println(cliente);
            }

            int x = sc.nextInt();

            if (x == 1) {
                rs_ = st_.executeQuery("delete from PROFESIONALES where id=" + id);
                System.out.println("Profesional borrado correctamente");
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
