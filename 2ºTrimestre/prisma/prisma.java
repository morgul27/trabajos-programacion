package prisma;

public class prisma {
    private int largo;
    private int ancho;
    private int alto;

    // largo
    public float getlargo() {
        return this.largo;
    }

    public void setlargo(int x) {
        this.largo = x;
    }

    // ancho
    public float getancho() {
        return this.ancho;
    }

    public void setancho(int x) {
        this.ancho = x;
    }

    // alto
    public float getalto() {
        return this.alto;
    }

    public void setalto(int x) {
        this.alto = x;
    }

    // prisma
    public void prisma() {

    }

    public void prisma(int largo, int ancho, int alto) {
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    // volumen
    public int volumen() {
        return this.ancho * this.largo * this.alto;
    }

    public boolean equals(Object objetoDos) {
        boolean ok = false;

        if (objetoDos instanceof prisma) {
            prisma other = (prisma) objetoDos;
            ok = (this.volumen() == other.volumen());
        }

        return true;
    }
}
