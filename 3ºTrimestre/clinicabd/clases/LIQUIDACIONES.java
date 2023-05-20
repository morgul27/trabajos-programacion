package clinicabd.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LIQUIDACIONES {
    protected String Fecha;
    protected int IDProfesional;

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public int getIDProfesional() {
        return IDProfesional;
    }

    public void setIDProfesional(int iDProfesional) {
        IDProfesional = iDProfesional;
    }

    public LIQUIDACIONES() {
    }

    public LIQUIDACIONES(String fecha, int iDProfesional) {
        Fecha = fecha;
        IDProfesional = iDProfesional;
    }

}
