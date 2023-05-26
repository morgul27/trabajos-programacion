package clinicabd;

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

public class insercionFunciones {
    public static Connection connection_;

    // insertar PACIENTES
    public static void insertarPac(Connection connection_) {
        Properties configuracion = new Properties();
        Statement st_ = null;
        ResultSet rs_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Scanner sc = new Scanner(System.in);
            Scanner ss = new Scanner(System.in);

            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            System.out.println("Se va a modificar la tabla PACIENTES");

            configuracion.load(new BufferedReader(new FileReader("bdconfiguracion.cfg")));
            String paciente = (configuracion.getProperty("selectPa"));

            rs_ = st_.executeQuery(paciente);

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
                    "(Apellidos,Nombre,DNI,FechaNacimiento,Genero,Direccion,CP,CodProvincia,email,Telefono1,Telefono2)"
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
    public static void insetarProfesional(Connection connection_) {

        Statement st_ = null;
        ResultSet rs_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

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
    public static void insertCobros(Connection connection_) {
        Statement st_ = null;
        ResultSet rs_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Scanner sc = new Scanner(System.in);

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
    public static void insertarservicios(Connection connection_) {

        Statement st_ = null;
        ResultSet rs_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ;

            Scanner sc = new Scanner(System.in);
            Scanner ss = new Scanner(System.in);
            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            System.out.println("Se va a modificar la tabla SERVICIOS");

            rs_ = st_.executeQuery("select * from TtosRealizados");

            System.out.println("Cuantos tratamientos quieres insertar");
            int contador = sc.nextInt();

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
    public static void insertarliquidacion(Connection connection_) {

        Statement st_ = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            Scanner sc = new Scanner(System.in);

            System.out.println("Que fecha es con el formato yyyymmdd");
            String fecha = sc.nextLine();
            System.out.println("El DNI del profesional");
            String dni = sc.nextLine();
            System.out.println("La comision que le pertenece");
            Double comision = sc.nextDouble();

            connection_.setAutoCommit(false);
            PreparedStatement ps = connection_.prepareStatement("INSERT INTO LIQUIDACION" +
                    "(?,(select IDProfesional from IDProfesional where NIF=" + dni + " ),?)");
            ps.setString(1, fecha);
            ps.setDouble(2, comision);
            ps.executeUpdate();
            ps.close();

            System.out.println("Ha finalizado la insercion");
            connection_.close();
            st_.close();
            connection_.commit();
            connection_.setAutoCommit(true);

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

    //

    // ------------------
    public static void insert3000Paciente(Connection connection_) {
        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Conexion a base de datos");
            st_ = connection_.createStatement();

            //
            // Empieza la escritura
            BufferedReader br = new BufferedReader(new FileReader("csv1.csv"));

            int i = 1;
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                String apellidos = parts[0];
                String nombre = parts[1];
                String DNI = parts[2];
                String fechaNacimiento = parts[3];
                String genero = parts[4];

                PreparedStatement ps = connection_.prepareStatement("INSERT INTO PACIENTES" +
                        " (Apellidos, Nombre, DNI, FechaNacimiento, Genero) VALUES ( ?, ?, ?, ?, ?)");
                ps.setString(1, apellidos);
                ps.setString(2, nombre);
                ps.setString(3, DNI);
                ps.setString(4, fechaNacimiento);
                ps.setString(5, genero);
                ps.executeUpdate();
                ps.close();
            }

            System.out.println("Insertado los 3000 pacientes en la base de datos");
            //

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

    // creacion de csv de pacientes
    public static void crearPacsv() {
        ArrayList<String> mujeres = new ArrayList<String>();
        ArrayList<String> hombres = new ArrayList<String>();
        ArrayList<String> apellidos = new ArrayList<String>();
        ArrayList<String> DNI = new ArrayList<String>();

        Properties configuracion = new Properties();

        try {
            configuracion.load(new BufferedReader(new FileReader("bdconfiguracion.cfg")));
            String paciente = (configuracion.getProperty("pacientes"));

            int max = Integer.valueOf(paciente);
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "csv1.csv"));
            int gen;

            // para declarar una matriz de ArrayList <String> array []
            ArrayList<String> array1[] = new ArrayList[4];
            array1[0] = mujeres;
            array1[1] = hombres;
            array1[2] = apellidos;
            array1[3] = DNI;

            String genero[] = { "mujeres", "hombres" };
            String rutas[] = {
                    "mujeres.txt",
                    "hombres.txt",
                    "apellidos.txt",
                    "DNI.csv"
            };

            // hacer esto con un for que envie esto 3 veces con una i y j que vayan sumando
            for (int i = 0, j = 0; i < rutas.length; i++, j++) {
                lectura(rutas[i], array1[j]);
            }
            // int maxuser = Integer.parseInt("3000");

            for (int i = 0; i < max; i++) {
                // gen es el genero, que sale aleatoriamente sin tener que preguntar más tarde
                // cual es
                gen = aleatorio(0, 100) / 55; // para quitar la parte entera dividir entre 55, enviar 0
                                              // al 100

                // estoy cogiendo dentro del array, el nombre aleatoriamente del Arraylist
                String nombres = (array1[gen])
                        .get(aleatorio(0, ((array1[gen]).size() - 1)));

                // Aqui estoy escribiendo el nombre de la persona y los dos apellidos con un
                // salto de linea al final
                bw.write("'" + nombres + "';'" + apellidos.get(aleatorio(0, apellidos.size() - 1)) + " "
                        + apellidos.get(aleatorio(0, apellidos.size() - 1)) + "';"
                        + DNI.remove(aleatorio(0, DNI.size() - 1))
                        + ";" + fechas()
                        + ";'" + genero[gen]
                        + "' \n");

            }

            bw.close();

        } catch (IOException ioe) {
            System.out.println("Se ha producido un error de lectura/escritura");
            System.err.println(ioe.getMessage());
        }
        System.out.println("Creado los 3000 pacientes en csv");
    }

    // funcion de fechas para la funcion de crear pacientes
    public static String fechas() {

        // Aqui cogemos el primer dia que quiero y luego el ultimo dia que quiero mirar
        LocalDate dia1 = LocalDate.of(1923, Month.JANUARY, 1);
        LocalDate dia2 = LocalDate.of(2017, Month.DECEMBER, 30);
        LocalDate fechana; // fecha de nacimiento

        // Con el ChronoUnit mira el intervalo de los dos dias que he puesto
        long intervalo = ChronoUnit.DAYS.between(dia1, dia2);
        intervalo = aleatorio(0, intervalo);
        fechana = dia1.plusDays(intervalo);

        return String.format("%04d%02d%02d", fechana.getYear(), fechana.getMonthValue(),
                fechana.getDayOfMonth());

    }

    // leer fichero y guardando los nombre o el apellido en un ArrayList
    public static void lectura(String texto, ArrayList<String> array) {
        String linea1 = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(texto));

            while ((linea1 != null)) {
                linea1 = br.readLine();
                (array).add(linea1);
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println("Se ha producido un error de lectura/escritura");
            System.err.println(ioe.getMessage());
        }

    }

    // Método para GENERAR UN ENTERO ALEAORIO DENTRO DE UN RANGO
    public static int aleatorio(int menor, int mayor) {
        int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
        return n;
    }

    // Método sobrecargado de aleatorio para poder hacelo con las fechas
    public static int aleatorio(int menor, Long mayor) {
        int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
        return n;
    }

    // funcion para crear la base de datos con los datos correspondientes desde el
    // menu administrador
    public static void crearbasedatos(Connection connection_) {
        Statement st_;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conexion a base de datos");
            st_ = connection_.createStatement();

            System.out.println("Creacion de la tabla PACIENTES..."); // PACIENTES
            st_.executeUpdate(
                    "CREATE TABLE PACIENTES (" +
                            "IDPaciente INT NOT NULL AUTO_INCREMENT," +
                            "Apellidos VARCHAR(250)," +
                            "Nombre VARCHAR (250)," +
                            "DNI VARCHAR (15)," +
                            "FechaNacimiento DATE," +
                            "Genero VARCHAR (100)," +
                            "Direccion VARCHAR(250)," +
                            "CP INT," +
                            "CodProvincia INT," + // Los primeros numeros de CP
                            "email VARCHAR(250)," +
                            "Telefono1 INT," +
                            "Telefono2 INT," +
                            "PRIMARY KEY (IDPaciente)" +
                            ")");

            System.out.println("Creacion de la tabla PROFESIONALES..."); // PROFESIONALES
            st_.executeUpdate(
                    "CREATE TABLE PROFESIONALES (" +
                            "IDProfesional INT NOT NULL AUTO_INCREMENT," +
                            "NIF VARCHAR(9)," +
                            "Apellidos VARCHAR(250)," +
                            "Nombre VARCHAR(250)," +
                            "Direccion VARCHAR(250)," +
                            "CP INT," +
                            "CodProvincia INT," +
                            "email VARCHAR(250)," +
                            "Telefono1 INT," +
                            "Telefono2 INT," +
                            "Comision DECIMAL(16,2)," +
                            "PRIMARY KEY (IDProfesional, NIF)" +
                            ")");

            System.out.println("Creacion de la tabla FAMILIAS..."); // FAMILIAS
            st_.executeUpdate(
                    "CREATE TABLE FAMILIAS (" +
                            "CodFamilia INT NOT NULL AUTO_INCREMENT," +
                            "Nombre VARCHAR(250) NOT NULL," +
                            "PRIMARY KEY (CodFamilia)" +
                            ")");

            System.out.println("Creacion de la tabla TRATAMIENTOS...");// TRATAMIENTOS
            st_.executeUpdate(
                    "CREATE TABLE TRATAMIENTOS (" +
                            "IDTratamiento INT NOT NULL AUTO_INCREMENT, " +
                            "CodTto VARCHAR(250) NOT NULL," +
                            "Nombre VARCHAR(250) NOT NULL," +
                            "CodFamilia INT," +
                            "Precio DECIMAL(16,2)," +
                            "PRIMARY KEY (IDTratamiento, CodTto)," +
                            "FOREIGN KEY(CodFamilia) REFERENCES FAMILIAS (CodFamilia)" +
                            ")");

            System.out.println("Creacion de la tabla GRUPOCAJA..."); // GRUPOCAJA
            st_.executeUpdate(
                    "CREATE TABLE GRUPOCAJA (" +
                            "CodGrCaja INT NOT NULL AUTO_INCREMENT," +
                            "Nombre VARCHAR(250) NOT NULL, " +
                            "PRIMARY KEY (CodGrCaja)" +
                            ")");

            System.out.println("Creacion de la tabla FCOBRO..."); // FORMAS COBRO
            st_.executeUpdate(
                    "CREATE TABLE FCOBRO (" +
                            "IDFCobro INT NOT NULL AUTO_INCREMENT," +
                            "Nombre VARCHAR(250) NOT NULL, " +
                            "CodGrCaja INT NOT NULL," +
                            "PRIMARY KEY (IDFCobro)," +
                            "FOREIGN KEY(CodGrCaja) REFERENCES GRUPOCAJA (CodGrCaja)" +
                            ")");

            System.out.println("Creacion de la tabla LIQUIDACIONES..."); // LIQUIDACIONES
            st_.executeUpdate(
                    "CREATE TABLE LIQUIDACIONES (" +
                            "IDLiquidacion INT NOT NULL AUTO_INCREMENT, " +
                            "Fecha DATE," +
                            "IDProfesional INT NOT NULL," +
                            "Comision DECIMAL(16,2)," +
                            "PRIMARY KEY(IDLiquidacion)," +
                            "FOREIGN KEY(IDProfesional) REFERENCES PROFESIONALES (IDProfesional)"
                            +
                            ")");

            System.out.println("Creacion de la tabla TtosRealizados..."); // SERVICIOS
            st_.executeUpdate(
                    "CREATE TABLE TtosRealizados (" +
                            "IDServicio INT NOT NULL AUTO_INCREMENT, " +
                            "Fecha DATE," +
                            "IDPaciente INT NOT NULL," +
                            "IDProfesional INT NOT NULL," +
                            "IDTratamiento INT NOT NULL," +
                            "Precio DECIMAL(16,2)," +
                            "Cobrado DECIMAL(16,2)," +
                            "IDLiquidacion INT NOT NULL," +
                            "FOREIGN KEY(IDPaciente) REFERENCES PACIENTES (IDPaciente)," +
                            "FOREIGN KEY(IDProfesional) REFERENCES PROFESIONALES (IDProfesional),"
                            +
                            "FOREIGN KEY(IDTratamiento) REFERENCES TRATAMIENTOS (IDTratamiento),"
                            +
                            "FOREIGN KEY(IDLiquidacion) REFERENCES LIQUIDACIONES (IDLiquidacion),"
                            +
                            "PRIMARY KEY(IDServicio)" +
                            ")");

            System.out.println("Creacion de la tabla COBROS..."); // COBROS
            st_.executeUpdate(
                    "CREATE TABLE COBROS (" +
                            "IDCobro INT NOT NULL AUTO_INCREMENT," +
                            "Fecha DATE," +
                            "IDPaciente INT NOT NULL," +
                            "IDFCobro INT NOT NULL," +
                            "Cobrado DECIMAL(16,2)," +
                            "Imputado DECIMAL(16,2)," +
                            "FOREIGN KEY(IDPaciente) REFERENCES PACIENTES (IDPaciente)," +
                            "FOREIGN KEY(IDFCobro) REFERENCES FCOBRO (IDFCobro)," +
                            "PRIMARY KEY (IDCobro)" +
                            ")");

            System.out.println("Creacion de la tabla TTOSCOBROS..."); // TTOSCOBROS - tabla N N
            st_.executeUpdate(
                    "CREATE TABLE TTOSCOBROS (" +
                            "IDCobro INT NOT NULL, " +
                            "IDServicio INT NOT NULL, " +
                            "Imputado DECIMAL(16,2)," +
                            "FOREIGN KEY(IDCobro) REFERENCES COBROS (IDCobro)," +
                            "FOREIGN KEY(IDServicio) REFERENCES TtosRealizados (IDServicio),"
                            +
                            "PRIMARY KEY (IDCobro, IDServicio)" +
                            ")");

            System.out.println("Se han creado todas las tablas correctamente!!");

            st_.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: Puede que ya esten creadas las tablas");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}