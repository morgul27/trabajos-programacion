package Figura;

public abstract class Figuras {
    protected float coor_x;
    protected float coord_y;
    protected float ancho;
    protected float alto;

    // coord_x
    public float getcoor_x() {
        return this.coor_x;
    }

    public void setcoor_x(float x) {
        this.coor_x = x;
    }

    // coord_y
    public float getcoor_y() {
        return this.coord_y;
    }

    public void setcoor_y(float y) {
        this.coord_y = y;
    }

    // ancho
    public float getancho() {
        return this.ancho;
    }

    public void setancho(float an) {
        this.ancho = an;
    }

    // alto
    public float getalto() {
        return this.alto;
    }

    public void setalto(float al) {
        this.alto = al;
    }

    // figuras
    public Figuras(float ancho, float alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public Figuras() {
    }

    abstract public float perimetro();

    abstract public float area();
}