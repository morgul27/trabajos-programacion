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
                try {
                        claseMenus.primerMenu();
                        System.out.println("Fin del programa");
                } catch (Exception e) {
                        System.out.println();
                }
        }

}