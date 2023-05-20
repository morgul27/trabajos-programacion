package clinicabd.clases;

public class TtosRealizados {
    protected int IDServicio;
    protected String Fecha;
    protected int IDPaciente;
    protected int IDProfesional;
    protected int IDTratamiento;
    protected double Precio;
    protected double Cobrado;
    protected int IDLiquidacion;

    public TtosRealizados(int iDServicio, String fecha, int iDPaciente, int iDProfesional, int iDTratamiento,
            double precio, double cobrado, int iDLiquidacion) {
        IDServicio = iDServicio;
        Fecha = fecha;
        IDPaciente = iDPaciente;
        IDProfesional = iDProfesional;
        IDTratamiento = iDTratamiento;
        Precio = precio;
        Cobrado = cobrado;
        IDLiquidacion = iDLiquidacion;
    }

    public TtosRealizados() {
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int iDServicio) {
        IDServicio = iDServicio;
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

    public int getIDProfesional() {
        return IDProfesional;
    }

    public void setIDProfesional(int iDProfesional) {
        IDProfesional = iDProfesional;
    }

    public int getIDTratamiento() {
        return IDTratamiento;
    }

    public void setIDTratamiento(int iDTratamiento) {
        IDTratamiento = iDTratamiento;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public double getCobrado() {
        return Cobrado;
    }

    public void setCobrado(double cobrado) {
        Cobrado = cobrado;
    }

    public int getIDLiquidacion() {
        return IDLiquidacion;
    }

    public void setIDLiquidacion(int iDLiquidacion) {
        IDLiquidacion = iDLiquidacion;
    }

}
