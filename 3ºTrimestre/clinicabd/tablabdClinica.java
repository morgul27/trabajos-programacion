package clinicabd;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class tablabdClinica {

        public static void main(String[] args) {
                // si quiero mostrar algo mirar act9 y ahi mas o menos veo algo
                fConfiguracion();
                Connection connection_ = coneccion();

                try {
                        claseMenus.primerMenu(connection_);
                        System.out.println("Fin del programa");
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public static Connection coneccion() {
                String db_ = "ClinicaDental";
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

        public static void fConfiguracion() {
                Properties configuracion = new Properties();
                configuracion.setProperty("pacientes", "3000");
                configuracion.setProperty("selectPa", "select * from PACIENTES");

                try {
                        configuracion.store(new FileOutputStream("bdconfiguracion.cfg"),
                                        "basededatosconfiguracion.cfg");

                } catch (Exception e) {
                        e.printStackTrace();
                }

        }

}