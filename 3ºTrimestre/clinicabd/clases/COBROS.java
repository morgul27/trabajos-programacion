package clinicabd.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class COBROS {

    protected String Fecha;
    protected int IDPaciente;
    protected int IDFCobro;
    protected int Cobrado;
    protected int Imputado;

    public COBROS(String fecha, int iDPaciente, int iDFCobro, int cobrado, int imputado) {
        Fecha = fecha;
        IDPaciente = iDPaciente;
        IDFCobro = iDFCobro;
        Cobrado = cobrado;
        Imputado = imputado;
    }

    public COBROS() {
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public int getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(int iDPaciente) {
        IDPaciente = iDPaciente;
    }

    public int getIDFCobro() {
        return IDFCobro;
    }

    public void setIDFCobro(int iDFCobro) {
        IDFCobro = iDFCobro;
    }

    public int getCobrado() {
        return Cobrado;
    }

    public void setCobrado(int cobrado) {
        Cobrado = cobrado;
    }

    public int getImputado() {
        return Imputado;
    }

    public void setImputado(int imputado) {
        Imputado = imputado;
    }

}
