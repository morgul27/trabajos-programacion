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
    public static void mostrarPac(Connection connection_) {

        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            ArrayList<String> listaClientes = new ArrayList<String>();

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
    public static void mostrarliquid(Connection connection_) {

        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            ArrayList<String> listaliqui = new ArrayList<String>();

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
    public static void HistorialPacientes(Connection connection_) {
        Statement st_;
        int idp = 1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Scanner sc = new Scanner(System.in);
            ArrayList<String> listaClientes = new ArrayList<String>();

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

            st_.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // sacar la liquidacion
    public static void sacarliquidacion(Connection connection_) {

        Statement st_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            Scanner sc = new Scanner(System.in);
            ArrayList<String> listaliqui = new ArrayList<String>();
            System.out.println(
                    "Dime la fecha desde la que quieres revisar hasta el dia de hoy con el formato yyyymmdd");
            String fecha = sc.nextLine();
            System.out.println("El DNI del profesional");
            String dni = sc.nextLine();

            System.out.println("La comision seria de");
            ResultSet rs_ = st_.executeQuery(
                    "select ((p.comsion/100)*sum(c.cobrado)) from PROFESIONALES p" +
                            "inner join TtosRealizados s on p.IDProfesional=s.IDProfesional" +
                            "inner join TTOSCOBROS t on t.IDServicio=s.IDServicio" +
                            "inner join COBROS c on c.IDCobro=t.IDCobro" +
                            "where p.NIF=" + dni + " and t.Fecha between " + fecha + " and now()");

            System.out.println("La lista de tratamientos realizados han sido");

            ResultSet dc_ = st_.executeQuery(
                    "select IDServicio,Fecha,IDProfesional from TtosRealizados t" +
                            "inner join PROFESIONALES p on p.IDProfesional=t.IDProfesional" +
                            "where p.NIF=" + dni + " and t.Fecha between " + fecha + " and now()");
            while (dc_.next()) {
                int idser = dc_.getInt("IDServicio");
                String fech = dc_.getString("Fecha");
                int idpro = dc_.getInt("IDProfesional");
                listaliqui.add(idser + " | " + fech + " | " + idpro);
            }

            System.out.println("La lista de tratamienots realizados han sido");

            for (String liquidacion : listaliqui) {
                System.out.println(liquidacion);
            }
            st_.close();
            dc_.close();
            rs_.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // consultas de odontologia
    public static void consultaOdonto(Connection connection_) {
        Statement st_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            Scanner sc = new Scanner(System.in);
            ArrayList<String> listaliqui = new ArrayList<String>();
            System.out.println(
                    "Dime la fecha desde la que quieres revisar hasta el dia de hoy con el formato yyyymmdd");
            String fecha = sc.nextLine();
            System.out.println("El DNI del profesional");
            String dni = sc.nextLine();

            System.out.println("Los profesionales de esta clinica son");
            ResultSet rs_ = st_.executeQuery(
                    "select * from PROFESIONALES p" +
                            "inner join TtosRealizados s on p.IDProfesional=s.IDProfesional" +
                            "where p.NIF=" + dni + " and t.Fecha between " + fecha + " and now()");

            ResultSet dc_ = st_.executeQuery(
                    "select Fecha,Cobrado,t.Nombre from TtosRealizados t" +
                            "inner join PROFESIONALES p on p.IDProfesional=t.IDProfesional" +
                            "inner join TtosRealizados tr on p.IDServicio = tr.IDServicio" +
                            "inner join TRATAMIENTOS t on tr.IDTratamiento = t.IDTratamiento" +
                            "where p.NIF=" + dni + " and t.Fecha between " + fecha + " and now()");
            while (dc_.next()) {
                int nombre = dc_.getInt("t.Nombre");
                String fech = dc_.getString("Fecha");
                int cobrado = dc_.getInt("Cobrado");
                listaliqui.add(nombre + " | " + fech + " | " + cobrado);
            }

            System.out.println("La lista de Odontologo realizados han sido");

            for (String liquidacion : listaliqui) {
                System.out.println(liquidacion);
            }

            st_.close();
            dc_.close();
            rs_.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // consultas de Familia y tipo de tratamiento
    public static void consultaFamilia(Connection connection_) {
        Statement st_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            Scanner sc = new Scanner(System.in);
            ArrayList<String> listafamilia = new ArrayList<String>();
            System.out.println(
                    "Dime la fecha desde la que quieres revisar hasta el dia de hoy con el formato yyyymmdd");
            String fecha = sc.nextLine();
            System.out.println("Dime el Codigo de la familia del tratamiento");
            String nomCodFa = sc.nextLine();

            System.out.println("La comision seria de");
            ResultSet rs_ = st_.executeQuery(
                    "select CodFamilia from FAMILIAS f" +
                            "where f.Nombre = " + nomCodFa);

            System.out.println("La lista de resumen de Odontologo han sido");

            ResultSet dc_ = st_.executeQuery(
                    "select Fecha,t.Nombre,CodTto,Cobrado from FAMILIAS f" +
                            "inner join TRATAMIENTOS t on f.CodFamilia = t.CodFamilia" +
                            "inner join TtosRealizados tr on t.IDTratamiento = tr.IDTratamiento" +
                            "where f.Nombre=" + nomCodFa + " and t.Fecha between " + fecha + " and now()");
            while (dc_.next()) {
                String fech = dc_.getString("Fecha");
                String nombre = dc_.getString("t.Nombre");
                String tipo = dc_.getString("CodTto");
                int cobrado = dc_.getInt("Cobrado");
                listafamilia.add(nombre + " | " + fech + " | " + tipo + " | " + cobrado);
            }

            System.out.println("La lista de tratamienots realizados han sido");

            for (String familia : listafamilia) {
                System.out.println(familia);
            }
            System.out.println("Ha finalizado la insercion");
            st_.close();
            dc_.close();
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
