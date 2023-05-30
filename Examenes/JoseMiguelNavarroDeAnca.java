import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class JoseMiguelNavarroDeAnca {
    public static void main(String[] args) {

        Connection connection_ = coneccion();

        try {

            gFichero(connection_);// 4
            evaluacion(connection_); // 3 T
            actualizaralumno(connection_); // 2 M
            veralumnos(connection_); // 1 T

            System.out.println("Fin del programa");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // coneccion a base de datos
    public static Connection coneccion() {
        String db_ = "examen";
        String login_ = "root";
        String password_ = "";
        String url_ = "jdbc:mysql://127.0.0.1/" + db_;
        Connection connection_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection_ = DriverManager.getConnection(url_, login_, password_);
            System.out.println("coneccion establecida");
            return connection_;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 1. visualizar alumnos
    public static void veralumnos(Connection connection_) {

        Statement st_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Scanner sc = new Scanner(System.in);
            ArrayList<String> listaAlumnos = new ArrayList<String>();

            st_ = connection_.createStatement();

            System.out.println("Introduce el codigo de una de las clases");
            String idclas = sc.nextLine();

            ResultSet rs_ = st_.executeQuery(
                    "select * from alumnos where IDCLASE ='" + idclas + "'");

            while (rs_.next()) {
                String CODALUMNO = rs_.getString("CODALUMNO");
                String NOMBRE = rs_.getString("NOMBRE");
                String IDCLASE = rs_.getString("IDCLASE");
                listaAlumnos.add(CODALUMNO + " | " + NOMBRE + " | " + IDCLASE);
            }

            System.out.println("La lista de alumnos es: ");
            for (String Alumnos : listaAlumnos) {
                System.out.println(Alumnos);
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

    // 2. actualizar alumnos
    public static void actualizaralumno(Connection connection_) {

        Statement st_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Scanner sc = new Scanner(System.in);

            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            System.out.println("Introduce el codigo del alumno");
            int coda = sc.nextInt();

            System.out.println("introduce el nombre nuevo del usuario");
            String nombre = sc.nextLine();
            st_.executeQuery("select * from alumnos");
            st_.executeQuery("update alumnos set NOMBRE= '" + nombre + "' where CODALUMNO= '" + coda + "'");

            st_.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 3. introducir evaluacion
    public static void evaluacion(Connection connection_) {
        Statement st_ = null;
        ResultSet rs_ = null;
        String IDCLASE = "";
        String IDPER = "";
        String IDASIG = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce el codigo de la clase");
            IDCLASE = sc.nextLine();

            if (IDCLASE == rs_.getString("IDCLASE")) {
                System.out.println("Introduce el codigo del periodo");
                IDPER = sc.nextLine();
                if (IDPER == rs_.getString("IDPER")) {
                    System.out.println("Introduce el codigo de la asignatura");
                    IDASIG = sc.nextLine();
                    if (IDASIG == rs_.getString("IDASIG")) {

                        rs_ = st_.executeQuery("select * from alumnos a" +
                                "inner join clases c on a.IDCLASE = c.IDCLASE" +
                                "inner join evaluaciones e on c.IDCLASE = e.IDCLASE" +
                                "inner join periodos p on e.IDPER = p.IDPER" +
                                "inner join asignaturas as on p.IDASIG = as.IDASIG" +
                                "where IDCLASE='" + IDCLASE + "' and  IDPER='" + IDPER + "' AND IDASIG='" + IDASIG
                                + "' )");
                        while (rs_.next()) {
                            System.out.println("Introduce la nota del alumno " + rs_.getString("NOMBRE"));
                            int nota = sc.nextInt();

                            // insersion
                            PreparedStatement ps = connection_
                                    .prepareStatement(
                                            "select NOTA from notas where CODALUMNO='" + rs_.getInt("CODALUMNO")
                                                    + "'),?)");

                            connection_.setAutoCommit(false);
                            ps.setInt(1, nota);
                            ps.executeUpdate();
                            ps.close();
                            connection_.commit();
                            connection_.setAutoCommit(true);
                        }
                        System.out.println("Ha finalizado la insercion");
                        connection_.close();
                        st_.close();
                    }
                }
            } else {
                System.out.println("Se ha equivocado en algun campo");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection_.rollback();
            } catch (SQLException e1) {
                System.err.println("Error");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4.Generar fichero
    public static void gFichero(Connection connection_) {
        Statement st_ = null;
        ResultSet rs_ = null;
        Scanner sc = new Scanner(System.in);

        try {
            st_ = connection_.createStatement();
            ArrayList<String> listaliqui = new ArrayList<String>();

            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "ficheroExamen.csv"));

            rs_ = st_.executeQuery("select notas.IDNOTA, notas.IDEVAL," +
                    "notas.CODALUMNO, alumnos.NOMBRE, " +
                    "evaluaciones.IDPER, periodos.NOMBRE, " +
                    "evaluaciones.IDCLASE, clases.NOMBRE, " +
                    "evaluaciones.IDASIG, asignaturas.NOMBRE," +
                    "notas.NOTA,evaluaciones.IDEVAL,alumnos.CODALUMNO, " +
                    "periodos.IDPER, periodos.NOMBRE, alumnos.IDCLASE, asignaturas.IDASIG" +
                    "from evaluaciones " +
                    "LEFT join periodos on periodos.IDPER = evaluaciones.IDPER " +
                    "LEFT join asignaturas on evaluaciones.IDASIG = asignaturas.IDASIG " +
                    "LEFT join notas on evaluaciones.IDEVAL = notas.IDEVAL " +
                    "LEFT join clases on evaluaciones.IDCLASE = clases.IDCLASE " +
                    "LEFT join alumnos on clases.IDCLASE = alumnos.IDCLASE " +
                    "ORDER BY evaluaciones.IDPER, clases.NOMBRE, alumnos.NOMBRE, notas.CODALUMNO " +
                    "");

            while (rs_.next()) {

                bw.write(rs_.getInt("notas.IDNOTA") + ";" + rs_.getInt("evaluaciones.IDEVAL") + ";"
                        + rs_.getString("alumnos.CODALUMNO")
                        + ";"
                        + rs_.getString("periodos.IDPER") + ";" + rs_.getString("periodos.NOMBRE") + ";"
                        + rs_.getString("alumnos.IDCLASE")
                        + ";"
                        + rs_.getString("clases.NOMBRE") + ";" + rs_.getString("asignaturas.IDASG") + ";"
                        + rs_.getString("asignaturas.NOMBRE")
                        + ";" + rs_.getString("notas.NOTA"));

            }

            for (String liquidacion : listaliqui) {
                System.out.println(liquidacion);
            }

            bw.close();
            System.out.println("Creado el csv");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}