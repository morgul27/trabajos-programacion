package Figura;

public class Triangulo extends Figuras {

    public Triangulo() {
        super();
    }

    public Triangulo(float ancho, float alto) {
        super(ancho, alto);
    }

    public float perimetro() {
        return (float) (alto + ancho + Math.sqrt(Math.pow(ancho, 2) + Math.pow(alto, 2)));
    }

    public float area() {
        return (alto * ancho) / 2;
    }

}