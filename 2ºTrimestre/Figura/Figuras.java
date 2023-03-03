package Figura;

public abstract class Figuras {
    protected int coor_x;
    protected int coord_y;
    protected int ancho;
    protected int alto;

    // coord_x
    public int getcoor_x() {
        return this.coor_x;
    }

    public void setcoor_x(int x) {
        this.coor_x = x;
    }

    // coord_y
    public int getcoor_y() {
        return this.coord_y;
    }

    public void setcoor_y(int y) {
        this.coord_y = y;
    }

    // ancho
    public int getancho() {
        return this.ancho;
    }

    public void setancho(int an) {
        this.ancho = an;
    }

    // alto
    public int getalto() {
        return this.alto;
    }

    public void setalto(int al) {
        this.alto = al;
    }

    // figuras
    public Figuras() {
    };

    abstract public float perimetro();

    abstract public float area();
}