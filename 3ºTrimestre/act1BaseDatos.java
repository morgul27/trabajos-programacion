import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class act1BaseDatos {
    public static void main(String[] args) {
        String db_ = "Prueba";
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

            System.out.println("Creacion de la tabla CLIENTE...");
            st_.executeUpdate(
                    "CREATE TABLE CLIENTES (" +
                            "ID_CLIENTE INT NOT NULL AUTO_INCREMENT," +
                            "NOMBRE VARCHAR (250)," +
                            "APELLIDOS VARCHAR(250), DIRECCION VARCHAR(250)," +
                            "FECHA_NACIMIENTO DATE, TELEFONO INTEGER" +
                            "(9), EMAIL VARCHAR(250), PRIMARY KEY (ID_CLIENTE)" +
                            ")");

            System.out.println("Creacion de la tabla PRODUCTOS...");
            st_.executeUpdate(
                    "CREATE TABLE PRODUCTOS (" +
                            "ID_PRODUCTO INT NOT NULL AUTO_INCREMENT," +
                            "NOMBRE VARCHAR(250), " +
                            "PRECIO DOUBLE(10,2), " +
                            "STOCK INT, " +
                            "PRIMARY KEY (ID_PRODUCTO))");

            System.out.println("Creacion de la tabla FACTURAS...");
            st_.executeUpdate(
                    "CREATE TABLE FACTURAS (" +
                            "NUM_FACTURA INT NOT NULL AUTO_INCREMENT," +
                            "ID_CLIENTE INT,FECHA DATE, " +
                            "PRIMARY KEY (NUM_FACTURA), " +
                            "FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTES (ID_CLIENTE))");

            System.out.println("Creacion de la tabla DETALLES...");
            st_.executeUpdate(
                    "CREATE TABLE DETALLES (" +
                            "NUM_DETALLE INT NOT NULL AUTO_INCREMENT, " +
                            "NUM_FACTURA INT, " +
                            "ID_PRODUCTO INT, " +
                            "CANTIDAD INT," +
                            "PRIMARY KEY(NUM_DETALLE)," +
                            "FOREIGN KEY(ID_PRODUCTO) REFERENCES PRODUCTOS (ID_PRODUCTO)," +
                            "FOREIGN KEY (NUM_FACTURA) REFERENCES FACTURAS (NUM_FACTURA))");

            System.out.println("Se han creado todas las tablas correctamente!!");

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
