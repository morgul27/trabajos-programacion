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

                        System.out.println("Creacion de la tabla PACIENTES..."); // PACIENTES
                        st_.executeUpdate(
                                        "CREATE TABLE PACIENTES (" +
                                                        "IDPaciente INT NOT NULL AUTO_INCREMENT," +
                                                        "Historia INT NOT NULL," + // Codigo de la historia clinica
                                                        "Apellidos VARCHAR(250)," +
                                                        "Nombre VARCHAR (250)," +
                                                        "DNI VARCHAR (9)," +
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
                                                        "Nombre VARCHAR (250)," +
                                                        "DNI VARCHAR (9)," +
                                                        "Direccion VARCHAR(250)," +
                                                        "CP INT," +
                                                        "CodProvincia INT," +
                                                        "email VARCHAR(250)," +
                                                        "Telefono1 INT," +
                                                        "Telefono2 INT," +
                                                        "Comision DECIMAL(16,2)," +
                                                        "PRIMARY KEY (IDProfesional, NIF)," +
                                                        ")");

                        System.out.println("Creacion de la tabla TRATAMIENTOS...");// TRATAMIENTOS
                        st_.executeUpdate(
                                        "CREATE TABLE TRATAMIENTOS (" +
                                                        "IDTratamiento INT NOT NULL AUTO_INCREMENT, " +
                                                        "CodTto INT NOT NULL," +
                                                        "Nombre VARCHAR(250) NOT NULL," +
                                                        "CodFamilia INT," +
                                                        "Precio DECIMAL(16,2)," +
                                                        "PRIMARY KEY (IDTratamiento, CodTto)," +
                                                        "FOREIGN KEY(CodFamilia) REFERENCES FAMILIAS (CodFamilia)," +
                                                        ")");

                        System.out.println("Creacion de la tabla FAMILIAS..."); // FAMILIAS
                        st_.executeUpdate(
                                        "CREATE TABLE FAMILIAS (" +
                                                        "CodFamilia INT NOT NULL AUTO_INCREMENT," +
                                                        "Nombre VARCHAR(250) NOT NULL," +
                                                        "PRIMARY KEY (CodFamilia)," +
                                                        ")");

                        System.out.println("Creacion de la tabla FCOBRO..."); // FORMAS COBRO
                        st_.executeUpdate(
                                        "CREATE TABLE FCOBRO (" +
                                                        "IDFCobro INT NOT NULL AUTO_INCREMENT," +
                                                        "Nombre VARCHAR(250) NOT NULL, " +
                                                        "CodGrCaja INT NOT NULL" +
                                                        "PRIMARY KEY (IDFCobro)" +
                                                        "FOREIGN KEY(CodGrCaja) REFERENCES GRUPOCAJA (CodGrCaja)," +
                                                        ")");

                        System.out.println("Creacion de la tabla GRUPOCAJA..."); // GRUPOCAJA
                        st_.executeUpdate(
                                        "CREATE TABLE GRUPOCAJA (" +
                                                        "CodGrCaja INT NOT NULL AUTO_INCREMENT," +
                                                        "Nombre VARCHAR(250) NOT NULL, " +
                                                        "PRIMARY KEY (CodGrCaja)" +
                                                        ")");

                        System.out.println("Creacion de la tabla TtosRealizados..."); // SERVICIOS
                        st_.executeUpdate(
                                        "CREATE TABLE TtosRealizados (" +
                                                        "IDServicio INT NOT NULL AUTO_INCREMENT, " +
                                                        "Fecha DATE," +
                                                        "IDPaciente INT NOT NULL" +
                                                        "IDProfesional INT NOT NULL" +
                                                        "IDTratamiento INT NOT NULL" +
                                                        "Precio DECIMAL(16,2)" +
                                                        "Cobrado DECIMAL(16,2)" +
                                                        "IDLiquidacion INT NOT NULL" +
                                                        "PRIMARY KEY(IDServicio)," +
                                                        "FOREIGN KEY(IDPaciente) REFERENCES PACIENTES (IDPaciente)," +
                                                        "FOREIGN KEY(IDProfesional) REFERENCES PROFESIONALES (IDProfesional),"
                                                        +
                                                        "FOREIGN KEY(IDTratamiento) REFERENCES TRATAMIENTOS (IDTratamiento),"
                                                        +
                                                        "FOREIGN KEY(IDLiquidacion) REFERENCES LIQUIDACIONES (IDLiquidacion),"
                                                        +
                                                        ")");

                        System.out.println("Creacion de la tabla COBROS..."); // COBROS
                        st_.executeUpdate(
                                        "CREATE TABLE COBROS (" +
                                                        "IDCobro INT NOT NULL AUTO_INCREMENT," +
                                                        "Fecha DATE," +
                                                        "IDPaciente VARCHAR(250) NOT NULL," +
                                                        "IDFCobro VARCHAR(250) NOT NULL," +
                                                        "Cobrado INT," +
                                                        "Imputado INT," +
                                                        "PRIMARY KEY (IDCobro)" +
                                                        "FOREIGN KEY(IDPaciente) REFERENCES PACIENTES (IDPaciente)," +
                                                        "FOREIGN KEY(IDFCobro) REFERENCES FCOBRO (IDFCobro)," +
                                                        ")");

                        System.out.println("Creacion de la tabla TTOSCOBROS..."); // TTOSCOBROS - tabla N N
                        st_.executeUpdate(
                                        "CREATE TABLE TTOSCOBROS (" +
                                                        "IDCobro INT NOT NULL, " +
                                                        "IDServicio INT NOT NULL, " +
                                                        "Imputado INT " +
                                                        "PRIMARY KEY (IDCobro, IDServicio), " +
                                                        "FOREIGN KEY(IDCobro) REFERENCES COBROS (IDCobro)," +
                                                        "FOREIGN KEY(IDServicio) REFERENCES TtosRealizados (IDServicio),"
                                                        +
                                                        ")");

                        System.out.println("Creacion de la tabla LIQUIDACIONES..."); // LIQUIDACIONES
                        st_.executeUpdate(
                                        "CREATE TABLE LIQUIDACIONES (" +
                                                        "IDLiquidacion INT NOT NULL AUTO_INCREMENT, " +
                                                        "Fecha DATE," +
                                                        "IDProfesional VARCHAR(250) NOT NULL," +
                                                        "PRIMARY KEY(IDLiquidacion)," +
                                                        "FOREIGN KEY(IDProfesional) REFERENCES PROFESIONALES (IDProfesional),"
                                                        +
                                                        ")");

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