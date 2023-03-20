package Equipos;

public class equipo implements Comparable<equipo> {
    protected String nombre;
    protected int ranking;

    // nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // ranking
    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    // constructor
    public equipo(String nombre, int ranking) {
        this.nombre = nombre;
        this.ranking = ranking;
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

    // funcion separar nombre
    public char caracter(String nombre) {
        char caracter;
        caracter = nombre.charAt(0);

        return caracter;
    }

}
