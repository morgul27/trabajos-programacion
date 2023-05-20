package clinicabd.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FCOBRO {
    protected int IDLiquidacion;
    protected String Fecha;
    protected int IDProfesional;

    public FCOBRO(int iDLiquidacion, String fecha, int iDProfesional) {
        IDLiquidacion = iDLiquidacion;
        Fecha = fecha;
        IDProfesional = iDProfesional;
    }

    public FCOBRO() {
    }

    public int getIDLiquidacion() {
        return IDLiquidacion;
    }

    public void setIDLiquidacion(int iDLiquidacion) {
        IDLiquidacion = iDLiquidacion;
    }

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

}
