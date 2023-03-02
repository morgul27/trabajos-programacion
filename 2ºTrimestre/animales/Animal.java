package animales;

public class Animal {
    private String nombre;
    private String alimentacion;
    private int edad;

    public Animal() {
    }

    public Animal(String n, String a, int e) {
        this.nombre = n;
        this.alimentacion = a;
        this.edad = e;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getAlimenta() {
        return this.alimentacion;
    }

    public void setAlimentacion(String a) {
        this.alimentacion = a;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int e) {
        this.edad = e;
    }

    public String toString() {
        return this.nombre + "," + this.alimentacion + "," + this.edad;
    }
}