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
                // si quiero mostrar algo mirar act9 y ahi mas o menos veo algo
                Connection connection_ = coneccion();
                try {
                        claseMenus.primerMenu(connection_);
                        System.out.println("Fin del programa");
                } catch (Exception e) {
                        System.out.println();
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

}