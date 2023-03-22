package Equipos;

public class equipo implements Comparable<equipo> {
    protected String nombre;
    protected String terreno;
    protected int ranking;
    protected int capacidad;
    protected int equipaciones;
    protected int socios;

    // terreno
    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    // nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // capacidad
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // equipaciones
    public int getEquipaciones() {
        return equipaciones;
    }

    public void setEquipaciones(int equipaciones) {
        this.equipaciones = equipaciones;
    }

    // socios
    public int getSocios() {
        return socios;
    }

    public void setSocios(int socios) {
        this.socios = socios;
    }

    // ranking
    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    // constructor
    public equipo(String nombre, String terreno, int ranking, int capacidad, int equipaciones, int socios) {
        this.nombre = nombre;
        this.terreno = terreno;
        this.ranking = ranking;
        this.capacidad = capacidad;
        this.equipaciones = equipaciones;
        this.socios = socios;
    }

    public equipo() {

    }

    // funcion compareTo
    public int compareTo(equipo e) {
        int resultado = 0;

        if (this.ranking < e.ranking) {
            resultado = 1;
        } else if (this.ranking > e.ranking) {
            resultado = -1;
        }

        return resultado;
    }

    // metodo toString, lo hago para poder comprobar si sale correctamente los
    // atributos que le he añadido
    public String toString() {
        return nombre + " con un ranking de " + ranking;
    }

}
