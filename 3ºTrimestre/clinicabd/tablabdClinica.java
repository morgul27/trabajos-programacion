package clinicabd;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class tablabdClinica {
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

                        System.out.println("Creacion de la tabla PACIENTES...");
                        st_.executeUpdate(
                                        "CREATE TABLE PACIENTES (" +
                                                        "IDPaciente INT NOT NULL AUTO_INCREMENT," +
                                                        "Historia INT," + // Codigo de la historia clinica
                                                        "Apellidos VARCHAR(250)," +
                                                        "Nombre VARCHAR (250)," +
                                                        "DNI VARCHAR (250)," +
                                                        "FechaNacimiento DATE," +
                                                        "Genero VARCHAR (250)," +
                                                        "Direccion VARCHAR(250)," +
                                                        "CP INT," +
                                                        "CodProvincia INT," + // Los primeros numeros de CP
                                                        "email VARCHAR(250)," +
                                                        "Telefono1 INT null," +
                                                        "Telefono2 INT null," +
                                                        "PRIMARY KEY (IDPaciente, Historia)" +
                                                        ")");

                        System.out.println("Creacion de la tabla PROFESIONALES...");
                        st_.executeUpdate(
                                        "CREATE TABLE PROFESIONALES (" +
                                                        "IDProfesional INT NOT NULL AUTO_INCREMENT," +
                                                        "NIF VARCHAR(250)," +
                                                        "Apellidos VARCHAR(250)," +
                                                        "Nombre VARCHAR (250)," +
                                                        "DNI VARCHAR (250)," +
                                                        "Direccion VARCHAR(250)," +
                                                        "CP VARCHAR(250)," +
                                                        "CodProvincia INT," +
                                                        "email VARCHAR(250)," +
                                                        "Telefono1 INT null," +
                                                        "Telefono2 INT null," +
                                                        "Comision DECIMAL(16,2)," +

                                                        ")");

                        System.out.println("Creacion de la tabla TRATAMIENTOS...");
                        st_.executeUpdate(
                                        "CREATE TABLE TRATAMIENTOS (" +
                                                        "IDTratamiento INT NOT NULL AUTO_INCREMENT, " +
                                                        "CodTto INT" +
                                                        "Nombre VARCHAR(250)" +
                                                        "CodFamilia INT" +
                                                        "Precio DECIMAL(16,2)" +
                                                        "PRIMARY KEY ()" +
                                                        ")");

                        System.out.println("Creacion de la tabla FAMILIAS...");
                        st_.executeUpdate(
                                        "CREATE TABLE FAMILIAS (" +
                                                        "CodFamilia INT NOT NULL AUTO_INCREMENT," +
                                                        "Nombre VARCHAR(250)" +
                                                        ")");

                        System.out.println("Creacion de la tabla FCOBRO...");
                        st_.executeUpdate(
                                        "CREATE TABLE FCOBRO (" +
                                                        "ID_FCOBRO INT NOT NULL AUTO_INCREMENT," +
                                                        "NOMBRE VARCHAR(250), " +
                                                        "PRIMARY KEY (ID_FCOBRO))");

                        System.out.println("Creacion de la tabla GRUPOCAJA...");
                        st_.executeUpdate(
                                        "CREATE TABLE GRUPOCAJA (" +
                                                        "ID_FCOBRO INT NOT NULL AUTO_INCREMENT," +
                                                        "NOMBRE VARCHAR(250), " +
                                                        "PRIMARY KEY (ID_FCOBRO))");

                        System.out.println("Creacion de la tabla TtosRealizados...");
                        st_.executeUpdate(
                                        "CREATE TABLE TtosRealizados (" +
                                                        "ID_Servicio INT NOT NULL AUTO_INCREMENT, " +
                                                        "FECHA DATE," +
                                                        "ID_PACIENTE INT" +
                                                        "ID_PROFESIONAL INT" +
                                                        "ID_TRATAMIENTO INT" +
                                                        "PRECIO DECIMAL(16,2)" +
                                                        "COBRADO DECIMAL(16,2)" +
                                                        "IDLIQUIDACION INT" +
                                                        "PRIMARY KEY(NUM_DETALLE)," +
                                                        ")");

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
