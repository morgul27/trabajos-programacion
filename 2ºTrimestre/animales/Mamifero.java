package animales;

public class Mamifero extends Animal {
    private int gestacion;

    public Mamifero() {
        super();
    }

    public Mamifero(String n, String a, int e, int g) {
        super(n, a, e);
        this.gestacion = g;
    }

    public int getGestacion() {
        return this.gestacion;
    }

    public void setGestacion(int g) {
        this.gestacion = g;
    }

    public String toString() {
        return super.toString() + "," + this.gestacion;
    }
}
