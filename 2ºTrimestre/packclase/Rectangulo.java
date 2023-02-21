package packclase;

public class Rectangulo {
    public int l;
    public int ancho;

    public Rectangulo(Double area, Double perimetro) {
        area = 0.0;
        perimetro = 0.0;
    }

    public double getarea(int l, int a) {
        double area;
        area = l * a;
        return area;
    }

    public double getperimetro(int l, int a) {
        double perimetro;
        perimetro = l + l + a + a;
        return perimetro;
    }
}
