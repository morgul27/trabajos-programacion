package packclase;

public class Rectangulo {

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    // lo anterior es el largo y ancho para devolver o establecer el valor
    // get devuelve el valor
    // set establecer el valor

    private double largo;
    private double ancho;

    public Rectangulo(Double largo, Double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public Rectangulo() {

    }

    public double area() {
        double area;
        area = largo * ancho;
        return area;
    }

    public double perimetro() {
        double peri;
        peri = (largo * 2) + (ancho * 2);
        return peri;
    }

    public void mostrar() {
        System.out.println("El largo es " + largo + " y el ancho es " + ancho);
        System.out.println("El area obtenida es " + area());
        System.out.println("el perimetro es " + perimetro());
    }
}
