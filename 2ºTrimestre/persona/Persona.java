package persona;

import java.util.ArrayList;

public class Persona implements Comparable<Persona> {
    protected String nombre;
    protected int edad;
    protected double altura;

    // nombre
    public String getnombre() {
        return this.nombre;
    }

    public void setnombre(String x) {
        this.nombre = x;
    }

    // edad
    public int getedad() {
        return this.edad;
    }

    public void setedad(int x) {
        this.edad = x;
    }

    // altura
    public double getaltura() {
        return this.altura;
    }

    public void setaltura(double x) {
        this.altura = x;
    }

    // creacion de clase
    // Persona
    public void Persona() {
    }

    public void Persona(int edad, double altura) {
        this.edad = edad;
        this.altura = altura;
    }

    // funcion compareTo
    public int compareTo(Persona p) {
        int resultado = 0;

        if (this.edad < p.edad) {
            resultado = 1;
        } else if (this.edad > p.edad) {
            resultado = -1;
        }

        return resultado;
    }

    public String toString() {
        return "El nombre de la persona es " + nombre + ", la altura es " + altura + " y la edad " + edad;
    }

    // mostrar
    public static void mostrar(Persona array1[]) {
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i].toString());
        }

    }
}
