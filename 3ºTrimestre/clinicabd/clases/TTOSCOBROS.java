package clinicabd.clases;

public class TTOSCOBROS {
    protected int IDCobro;
    protected int IDServicio;
    protected int Imputado;

    public TTOSCOBROS(int iDCobro, int iDServicio, int imputado) {
        IDCobro = iDCobro;
        IDServicio = iDServicio;
        Imputado = imputado;
    }

    public TTOSCOBROS() {
    }

    public int getIDCobro() {
        return IDCobro;
    }

    public void setIDCobro(int iDCobro) {
        IDCobro = iDCobro;
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int iDServicio) {
        IDServicio = iDServicio;
    }

    public int getImputado() {
        return Imputado;
    }

    public void setImputado(int imputado) {
        Imputado = imputado;
    }

}
