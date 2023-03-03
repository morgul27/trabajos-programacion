package Figura;

public class Cuadrado extends Figuras {

    public Cuadrado() {
        super();
    }

    public Cuadrado(float lado) {
        super(lado, lado);
    }

    public float perimetro() {
        return (float) (alto + ancho) * 2;
    }

    public float area() {
        return alto * alto;
    }
}
