package animales;

public class Perro extends Mamifero {
    private String raza;

    public Perro() {
        super();
    }

    public Perro(String n, String a, int e, int g, String r) {
        super(n, a, e, g);
        this.raza = r;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String r) {
        this.raza = r;
    }

    public String toString() {
        return super.toString() + "," + this.raza;
    }
}
