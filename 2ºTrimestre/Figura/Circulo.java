package Figura;

public class Circulo extends Figuras {

    public Circulo() {
        super();
    }

    public Circulo(float radio) {
        super(radio * 2, radio * 2);
    }

    public float perimetro() {
        return (float) (this.alto * Math.PI);
    }

    public float area() {
        return (float) (Math.PI * Math.pow(alto / 2, 2));
    }
}