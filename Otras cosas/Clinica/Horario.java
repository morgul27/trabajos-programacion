package Clinica;

public class Horario {
    protected String dia;
    protected int visitas;
    protected int urgencia;

    // dia
    public String getdia() {
        return this.dia;
    }

    public void setdia(String x) {
        this.dia = x;
    }

    // visitas
    public int getvisitas() {
        return this.visitas;
    }

    public void setvisitas(int x) {
        this.visitas = x;
    }

    // urgencia
    public int geturgencia() {
        return this.urgencia;
    }

    public void seturgencia(int x) {
        this.urgencia = x;
    }

    // creacion de constructor
    // Horario
    public Horario() {
    }

    public Horario(String dia, int visitas, int urgencia) {
        this.dia = dia;
        this.visitas = visitas;
        this.urgencia = urgencia;
    }

    // metodos aleatorio
    public static int aleatorio() {
        int ran;

        ran = (int) (Math.floor((16 - 15 + 1) * Math.random() + 15));
        return ran;
    }

    public static int aleatorio(int max) {
        int ran;

        ran = (int) (Math.floor((max) * Math.random()));
        return ran;
    }
}
