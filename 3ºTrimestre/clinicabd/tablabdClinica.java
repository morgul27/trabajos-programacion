package clinicabd;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class tablabdClinica {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int x = 0;
                boolean salirMenu = false;

                do {
                        // menu
                        System.out.println();
                        System.out.println("1. Crear la base de datos");
                        System.out.println("2. Insertar un servicio");
                        System.out.println("3. "); // de momento, tengo que cambiarlo
                        System.out.println("4. ");
                        System.out.println("5. ");
                        System.out.println("6. ");
                        System.out.println("7. ");
                        System.out.println("8. Menu administrador");
                        System.out.println("9. Salir");
                        System.out.println();

                        // Ingresar numero
                        System.out.println("Ingresa un numero entre el 1 y el 8");
                        try {
                                x = Integer.parseInt(sc.nextLine()); // lo paso a int, aunque sea un caracter

                        } catch (NumberFormatException e) {
                                System.out.println("Debes ingresar un numero entero valido");
                        }

                        switch (x) {
                                case 1:
                                        // crear la base de datos

                                        System.out.println();
                                        break;
                                case 2:
                                        // insertar un servicio
                                        System.out.println();

                                        break;
                                case 3:
                                        // modificar un tratamiento, todavia no lo modifica
                                        System.out.println();
                                        break;
                                case 4:
                                        // insertar cobro
                                        // 5d, debe indicar el cobro y el tratamiento realizado
                                        System.out.println();
                                        break;
                                case 5:
                                        // modifica un cobro, es opcional en principio
                                        System.out.println();
                                        break;
                                case 6:
                                        // liquidaciones
                                        System.out.println();
                                        break;
                                case 7:
                                        // hacer consultas, clicando en cosas
                                        System.out.println();
                                        break;
                                case 8:
                                        administracion();
                                        break;
                                // hacer menu con contraseña para crear la base de datos
                                case 9:
                                        salirMenu = true;
                                        break;
                                default:
                                        System.out.println();
                                        System.out.println("Debe introducir un numero entre 1 y 8");
                                        System.out.println();
                        }
                } while (!salirMenu);

        }

        // funcion 2 para insertar datos de servicios, cambiarlo
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

                        System.out.println("Conexion a base de datos" + db_ + " correcta");
                        st_ = connection_.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

                        System.out.println("Se va a modificar la tabla SERVICIOS");

                        rs_ = st_.executeQuery("select * from TtosRealizados");

                        System.out.println("Cuantos tratamientos quieres insertar");
                        int contador = sc.nextInt();

                        // necesito insertar los id de todo
                        for (int i = 0; i < contador; i++) {
                                System.out.println("Introduce la fecha de realizacion del servicio (yyyy-mm-dd) numero "
                                                + (contador + 1));
                                java.sql.Date fecharea = java.sql.Date.valueOf(sc.nextLine());
                                System.out.println("Introduce precio del servicio " + (contador + 1));
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

        // funcion 8 del menu de administrador
        public static void administracion() {
                Scanner sc = new Scanner(System.in);
                int x = 0;
                boolean salirMenu = false;

                System.out.println("Ingrese la contrasegna para continuar");
                try {
                        x = Integer.parseInt(sc.nextLine()); // lo paso a int, aunque sea un caracter

                } catch (NumberFormatException e) {
                        System.out.println("Debes ingresar la contrasegna segura");
                }
                if (x == 666) {
                        do {
                                // menu
                                System.out.println();
                                System.out.println("1. Crear la base de datos");
                                System.out.println("2. Insertar un servicio");
                                System.out.println("3. Crear 3000 paciente"); // de momento, tengo que cambiarlo
                                System.out.println("9. Salir");
                                System.out.println();

                                // Ingresar numero
                                System.out.println("Ingresa un numero entre el 1 y el 8");
                                try {
                                        x = Integer.parseInt(sc.nextLine()); // lo paso a int, aunque sea un caracter

                                } catch (NumberFormatException e) {
                                        System.out.println("Debes ingresar un numero entero valido");
                                }

                                switch (x) {
                                        case 1:
                                                // crear la base de datos
                                                crearbasedatos();
                                                System.out.println();
                                                break;
                                        case 2:
                                                // insertar un servicio
                                                System.out.println();
                                                insertar();
                                                break;
                                        case 3:
                                                // modificar un tratamiento, todavia no lo modifica
                                                System.out.println();
                                                crearPacsv();
                                                insertPacienteBBDD();
                                                break;
                                        case 4:
                                                // insertar cobro
                                                // 5d, debe indicar el cobro y el tratamiento realizado
                                                System.out.println();
                                                break;
                                        case 5:
                                                // modifica un cobro, es opcional en principio
                                                System.out.println();
                                                break;
                                        case 6:
                                                // liquidaciones
                                                System.out.println();
                                                break;
                                        case 7:
                                                // hacer consultas, clicando en cosas
                                                System.out.println();
                                                break;
                                        case 8:
                                                salirMenu = true;
                                                break;
                                        // hacer menu con contraseña para crear la base de datos
                                        case 9:
                                                salirMenu = true;
                                                break;
                                        default:
                                                System.out.println();
                                                System.out.println("Debe introducir un numero entre 1 y 8");
                                                System.out.println();
                                }
                        } while (!salirMenu);
                }

        }

        // funcion para crear la base de datos con los datos correspondientes desde el
        // menu administrador
        public static void crearbasedatos() {
                String db_ = "ClinicaDental";
                String login_ = "root";
                String password_ = "";
                String url_ = "jdbc:mysql://127.0.0.1/" + db_;
                Connection connection_;
                Statement st_;

                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection_ = DriverManager.getConnection(url_, login_, password_);

                        System.out.println("Conexion a base de datos");
                        st_ = connection_.createStatement();

                        System.out.println("Creacion de la tabla PACIENTES..."); // PACIENTES
                        st_.executeUpdate(
                                        "CREATE TABLE PACIENTES (" +
                                                        "IDPaciente INT NOT NULL AUTO_INCREMENT," +
                                                        "Historia INT NOT NULL," + // Codigo de la historia clinica
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
                                                        "PRIMARY KEY (IDPaciente, Historia)" +
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
                                                        "Cobrado INT," +
                                                        "Imputado INT," +
                                                        "FOREIGN KEY(IDPaciente) REFERENCES PACIENTES (IDPaciente)," +
                                                        "FOREIGN KEY(IDFCobro) REFERENCES FCOBRO (IDFCobro)," +
                                                        "PRIMARY KEY (IDCobro)" +
                                                        ")");

                        System.out.println("Creacion de la tabla TTOSCOBROS..."); // TTOSCOBROS - tabla N N
                        st_.executeUpdate(
                                        "CREATE TABLE TTOSCOBROS (" +
                                                        "IDCobro INT NOT NULL, " +
                                                        "IDServicio INT NOT NULL, " +
                                                        "Imputado INT," +
                                                        "FOREIGN KEY(IDCobro) REFERENCES COBROS (IDCobro)," +
                                                        "FOREIGN KEY(IDServicio) REFERENCES TtosRealizados (IDServicio),"
                                                        +
                                                        "PRIMARY KEY (IDCobro, IDServicio)" +
                                                        ")");

                        System.out.println("Se han creado todas las tablas correctamente!!");

                        connection_.close();
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

        // ------------------
        // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        public static void insertPacienteBBDD() {
                String db_ = "ClinicaDental";
                String login_ = "root";
                String password_ = "";
                String url_ = "jdbc:mysql://127.0.0.1/" + db_;
                Connection connection_;
                Statement st_;

                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection_ = DriverManager.getConnection(url_, login_, password_);

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
                                                " (Historia, Apellidos, Nombre, DNI, FechaNacimiento, Genero) VALUES (?, ?, ?, ?, ?, ?)");
                                ps.setInt(1, i++);
                                ps.setString(2, apellidos);
                                ps.setString(3, nombre);
                                ps.setString(4, DNI);
                                ps.setString(5, fechaNacimiento);
                                ps.setString(6, genero);
                                ps.executeUpdate();
                                ps.close();
                        }

                        System.out.println("Insertado los 3000 pacientes en la base de datos");
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

        // por si tengo que crear el csv como tal aqui, sino borrar
        public static void crearPacsv() {
                ArrayList<String> mujeres = new ArrayList<String>();
                ArrayList<String> hombres = new ArrayList<String>();
                ArrayList<String> apellidos = new ArrayList<String>();
                ArrayList<String> DNI = new ArrayList<String>();

                try {

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

                        for (int i = 0; i < 3000; i++) {
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
                        System.out.println("tamaño final de dni es: " + DNI.size());
                        System.out.println(DNI.get(0));
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

}