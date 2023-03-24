package Clinica2;

import java.sql.Date;

public class Personas {
    protected String nombre;
    protected String apellidos;
    protected Date fechanaci;
    protected boolean genero;
    protected String DNI;
    protected String direccion;
    protected int telefono;

    // nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Apellidos
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // fecha
    public Date getFechanaci() {
        return fechanaci;
    }

    public void setFechanaci(Date fechanaci) {
        this.fechanaci = fechanaci;
    }

    // genero
    public boolean getGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    // DNI
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    // direccion
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // telefono
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    // constructor
    public Personas(String nombre, String apellidos, Date fechanaci, boolean genero, String DNI, String direccion,
            int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanaci = fechanaci;
        this.genero = genero;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Personas() {
    }

}
