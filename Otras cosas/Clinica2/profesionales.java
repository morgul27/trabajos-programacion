package Clinica2;

public class profesionales extends Personas {
    protected int codigo;
    protected String especialidades;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    // constructor
    public profesionales(int codigo, String especialidades) {
        this.codigo = codigo;
        this.especialidades = especialidades;
    }

    public profesionales() {
    }

}
