package Clinica2;

public class pacientes extends Personas {
    protected int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public pacientes(int codigo) {
        this.codigo = codigo;
    }

    public pacientes() {
    }

}
