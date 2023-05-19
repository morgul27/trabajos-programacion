package clinicabd.clases;

public class TRATAMIENTOS {
    protected String CodTto;
    protected String Nombre;
    protected int CodFamilia;
    protected double Precio;

    public TRATAMIENTOS() {
    }

    public TRATAMIENTOS(String codTto, String nombre, int codFamilia, double precio) {
        CodTto = codTto;
        Nombre = nombre;
        CodFamilia = codFamilia;
        Precio = precio;
    }

    public String getCodTto() {
        return CodTto;
    }

    public void setCodTto(String codTto) {
        CodTto = codTto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCodFamilia() {
        return CodFamilia;
    }

    public void setCodFamilia(int codFamilia) {
        CodFamilia = codFamilia;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

}
