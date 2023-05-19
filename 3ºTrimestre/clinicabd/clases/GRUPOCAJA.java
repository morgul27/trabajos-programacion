package clinicabd.clases;

public class GRUPOCAJA {
    protected int CodGrCaja;
    protected String Nombre;

    public GRUPOCAJA() {
    }

    public GRUPOCAJA(int codGrCaja, String nombre) {
        CodGrCaja = codGrCaja;
        Nombre = nombre;
    }

    public int getCodGrCaja() {
        return CodGrCaja;
    }

    public void setCodGrCaja(int codGrCaja) {
        CodGrCaja = codGrCaja;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

}
