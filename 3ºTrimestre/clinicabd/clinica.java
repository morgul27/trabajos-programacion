package clinicabd;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class clinica {
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
                            "DNI VARCHAR (250)," +
                            "FECHA_NACIMIENTO DATE, TELEFONO INTEGER" +
                            "(9), EMAIL VARCHAR(250), PRIMARY KEY (ID_CLIENTE)" +
                            "GENERO VARCHAR (250)," +
                            "DIRECCION VARCHAR (250)," +
                            "CODIGO POSTAL VARCHAR (250)," +
                            "CODIGO PROVINCIA VARCHAR (250)," +
                            "EMAIL VARCHAR (250)," +
                            "TELEFONO_1 VARCHAR (250)," +
                            "TELEFONO_2 VARCHAR (250)," +
                            ")");

            System.out.println("Creacion de la tabla FCOBRO...");
            st_.executeUpdate(
                    "CREATE TABLE FCOBRO (" +
                            "ID_FCOBRO INT NOT NULL AUTO_INCREMENT," +
                            "NOMBRE VARCHAR(250), " +
                            "PRIMARY KEY (ID_FCOBRO))");

            System.out.println("Creacion de la tabla COBROS...");
            st_.executeUpdate(
                    "CREATE TABLE COBROS (" +
                            "ID_FCOBRO INT NOT NULL AUTO_INCREMENT," +
                            "NOMBRE VARCHAR(250), " +
                            "FECHA DATE," +
                            "IDPACIENTE VARCHAR(250)," +
                            "IDFCOBRO VARCHAR(250)," +
                            "COBRADO INT," +
                            "IMPUTADO INT," +
                            "PRIMARY KEY (ID_FCOBRO))");

            System.out.println("Creacion de la tabla TTOSCOBROS...");
            st_.executeUpdate(
                    "CREATE TABLE TTOSCOBROS (" +
                            "IDCOBRO INT, " +
                            "IDSERVICIOS INT, " +
                            "IMPUTADO INT " +
                            "PRIMARY KEY (NUM_FACTURA), " +
                            ")");

            System.out.println("Creacion de la tabla LIQUIDACIONES...");
            st_.executeUpdate(
                    "CREATE TABLE LIQUIDACIONES (" +
                            "ID_LIQUIDACION INT NOT NULL AUTO_INCREMENT, " +
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
