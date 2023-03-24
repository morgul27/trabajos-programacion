package Clinica2;

import java.util.Date;

public class visitas {
    protected Date fecha;
    protected String especialista;
    protected String especialidad;
    protected int paciente;
    protected int importe;
    protected int formadepago;
    protected boolean urgencia;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public int getFormadepago() {
        return formadepago;
    }

    public void setFormadepago(int formadepago) {
        this.formadepago = formadepago;
    }

    public boolean isUrgencia() {
        return urgencia;
    }

    public void setUrgencia(boolean urgencia) {
        this.urgencia = urgencia;
    }

    public visitas(Date fecha, String especialista, String especialidad, int paciente, int importe, int formadepago,
            boolean urgencia) {
        this.fecha = fecha;
        this.especialista = especialista;
        this.especialidad = especialidad;
        this.paciente = paciente;
        this.importe = importe;
        this.formadepago = formadepago;
        this.urgencia = urgencia;
    }

    public visitas() {
    }

}
