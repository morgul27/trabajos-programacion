package prisma;

import java.util.ArrayList;

public class prisma implements Comparable<prisma> {
    protected float largo;
    protected float ancho;
    protected float alto;

    // largo
    public float getlargo() {
        return this.largo;
    }

    public void setlargo(float x) {
        this.largo = x;
    }

    // ancho
    public float getancho() {
        return this.ancho;
    }

    public void setancho(float x) {
        this.ancho = x;
    }

    // alto
    public float getalto() {
        return this.alto;
    }

    public void setalto(float x) {
        this.alto = x;
    }

    // creacion de clase
    // prisma
    public void prisma() {
    }

    public void prisma(float largo, float ancho, float alto) {
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    // volumen
    public float volumen() {
        return this.ancho * this.largo * this.alto;
    }

    // equals
    public boolean equals(Object objetoDos) {
        boolean ok = false;

        if (objetoDos instanceof prisma) {
            prisma other = (prisma) objetoDos;
            ok = (this.volumen() == other.volumen());
        }

        return ok;
    }

    public boolean equalsDimension(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof prisma))
            return false;
        prisma other = (prisma) obj;
        if (other.equals(this)) {
            ArrayList<Float> prisma1 = new ArrayList<Float>();
            prisma1.add(alto);
            prisma1.add(ancho);
            prisma1.add(largo);
            return prisma1.remove(other.alto) && prisma1.remove(other.largo) && prisma1.remove(ancho);
        }
        return false;
    }

    // hashCode
    public int hashCode() {
        return Float.hashCode(this.ancho) + Float.hashCode(this.alto) + Float.hashCode(this.largo);
    }

    // funcion compareTo
    public int compareTo(prisma p) {
        int resultado = 0;

        if (this.volumen() < p.volumen()) {
            resultado = -1;
        } else if (this.volumen() > p.volumen()) {
            resultado = 1;
        }

        return resultado;
    }

    public String toString() {
        return "El largo es " + largo + ", el alto " + alto + " y el ancho " + ancho;
    }

}